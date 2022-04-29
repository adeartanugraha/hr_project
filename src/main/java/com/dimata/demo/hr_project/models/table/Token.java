package com.dimata.demo.hr_project.models.table;


import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.GeneratedValue;

import static com.dimata.demo.hr_project.core.util.ManipulateUtil.changeItOrNot;

import com.dimata.demo.hr_project.core.api.UpdateAvailable;
import com.dimata.demo.hr_project.core.util.GenerateUtil;
import com.dimata.demo.hr_project.core.util.ManipulateUtil;
import com.dimata.demo.hr_project.core.util.jackson.DateDeserialize;
import com.dimata.demo.hr_project.core.util.jackson.DateSerialize;
import com.dimata.demo.hr_project.core.util.jackson.TimeSerialize;
import com.dimata.demo.hr_project.enums.IsActive;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import io.r2dbc.spi.Row;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Data
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Token implements Persistable<String>, UpdateAvailable<Token> {
    public static final String TABLE_NAME = "token";
    public static final String ID_COL = "token_code";
    public static final String IS_ACTIVE_COL = "is_active";
    public static final String CRETED_AT_COL = "created_at";
    
    @Accessors(fluent = true)
    @Setter
    public static class Builder {

        private String id;
        private IsActive isActive;
        private LocalDateTime createdAt;
        @Setter(AccessLevel.PRIVATE)
        private boolean newRecord = false;

        public static Builder createNewRecord(IsActive isActive) {
            return new Builder().newRecord(true)
                .isActive(Objects.requireNonNull(isActive, "is active tidak boleh kosong"));
        }

        public static Builder updateBuilder(Token oldRecord, Token newRecord) {
            return new Builder()
                .id(oldRecord.getId())
                .isActive(changeItOrNot(newRecord.getIsActive(), oldRecord.getIsActive()))
                .createdAt(oldRecord.getCreatedAt());
        }

        public static Builder emptyBuilder() {
            return new Builder();
        }

        public Token build() {
            Token result = new Token();
            result.setId(id);
            result.setIsActive(isActive);
            result.setCreatedAt(createdAt);
            return result;
        }
    }

    @Id
    @Column(ID_COL)
    private String id;
    private Integer isActive;
    
    @JsonSerialize(converter = TimeSerialize.class)
    private LocalDateTime createdAt;

    
    @Transient
    @JsonIgnore
    private String insertId;

    public void setIsActive(IsActive isactive) {
        if (isactive!= null) {
            this.isActive= isactive.getCode();
        }
    }

    public IsActive getIsActive() {
        if (isActive != null) {
            return IsActive.getIsActive(this.isActive);
        }
        return null;
    }

    public static Token fromRow(Row row) {
        var result = new Token();
        result.setId(ManipulateUtil.parseRow(row, ID_COL, String.class));
        result.setIsActive(IsActive.getIsActive(ManipulateUtil.parseRow(row, IS_ACTIVE_COL, Integer.class)));
        result.setCreatedAt(ManipulateUtil.parseRow(row, CRETED_AT_COL, LocalDateTime.class));
        return result;
    }

    

    @Override
    public boolean isNew() {
        if (id == null && insertId == null) {
            id = UUID.randomUUID().toString();
            createdAt = LocalDateTime.now();
            return true;
        } else if (id == null) {
            id = insertId;
            createdAt = LocalDateTime.now();
            return true;
        }
        return false;
    }

    @Override
    public Token update(Token newData) {
        return Builder.updateBuilder(this, newData).build();
    }
}
