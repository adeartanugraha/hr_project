package com.dimata.service.general.harisma.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "hr_appraisal")
public class HrAppraisal extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "HR_APPRAISAL_ID")
    public Long id;

    @Column(name = "EMP_COMMENT")
    @Type(type = "text")
    public String empComment;

    @Column(name = "ASS_COMMENT")
    @Type(type = "text")
    public String assComment;

    @Column(name = "RATING")
    public Double rating;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "HR_APP_MAIN_ID")
    public HrAppMain hrAppMain;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ASS_FORM_ITEM_ID")
    public HrAssFormItem hrAssFormItem;

    @Column(name = "ANSWER_1")
    @NotNull
    @Type(type = "text")
    public String answer1;

    @Column(name = "ANSWER_2")
    @NotNull
    @Type(type = "text")
    public String answer2;

    @Column(name = "ANSWER_3")
    @NotNull
    @Type(type = "text")
    public String answer3;

    @Column(name = "ANSWER_4")
    @NotNull
    @Type(type = "text")
    public String answer4;

    @Column(name = "ANSWER_5")
    @NotNull
    @Type(type = "text")
    public String answer5;

    @Column(name = "ANSWER_6")
    @NotNull
    @Type(type = "text")
    public String answer6;

    @Column(name = "REALIZATION")
    public BigDecimal realization;

    @Column(name = "EVIDENCE")
    public String evidence;

    @Column(name = "POINT")
    public BigDecimal point;

    @Column(name = "WEIGHT")
    public Double weight;

    @Column(name = "KPI_ID")
    public Long kpiId = Long.valueOf(0);

    //---------------- ACTIVE RECORD

    public static Optional<HrAppraisal> findById(long id) {
        return find("id = ?1", id).firstResultOptional();
    }

    public static List<HrAppraisal> getAllData() {
        return HrAppraisal.listAll();
    }

}
