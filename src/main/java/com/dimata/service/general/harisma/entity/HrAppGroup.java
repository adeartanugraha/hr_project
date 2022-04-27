package com.dimata.service.general.harisma.entity;

import com.dimata.service.general.harisma.entity.enums.HrAppGroupStatus;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "hr_app_group")
public class HrAppGroup extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "GROUP_ID")
    public Long id;

    @Column(name = "GROUP_NAME")
    @NotBlank
    public String groupName;

    @CreationTimestamp
    @Column(name = "REG_DATE")
    @NotNull
    public LocalDateTime regDate;

    @Enumerated
    @Column(name = "STATUS")
//    @NotBlank
    public HrAppGroupStatus status;

    @Column(name = "DESCRIPTION")
    @Type(type = "text")
    @NotBlank
    public String description;

    //---------------- ACTIVE RECORD
    public static Optional<HrAppGroup> findById(long id) {
        return find("id = ?1", id).firstResultOptional();
    }

    public static List<HrAppGroup> getAllData() {
        return HrAppGroup.listAll();
    }
}
