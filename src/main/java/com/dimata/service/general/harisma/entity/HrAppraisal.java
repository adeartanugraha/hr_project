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
    @GeneratedValue(strategy = GenerationType.IDENTITY)//,generator = "dimata_id_gen")
    @Column(name = "HR_APPRAISAL_ID")
    public Long id;

    @Column(name = "EMP_COMMENT")
//    @NotBlank
    @Type(type = "text")
    public String empComment;

    @Column(name = "ASS_COMMENT")
//    @NotBlank
    @Type(type = "text")
    public String assComment;

    @Column(name = "RATING")
//    @NotBlank
    public Double rating;
    @Column(name = "HR_APP_MAIN_ID", nullable = false)
    public Long hrAppMain;

    @Column(name = "ASS_FORM_ITEM_ID", nullable = false)
    public Long hrAssFormItem;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "HR_APP_MAIN_ID")
//    public HrAppMain hrAppMain;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "ASS_FORM_ITEM_ID")
//    public HrAssFormItem hrAssFormItem;

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
//    @NotBlank
    public BigDecimal realization;

    @Column(name = "EVIDENCE")
//    @NotBlank
    public String evidence;

    @Column(name = "POINT")
//    @NotBlank
    public BigDecimal point;

    @Column(name = "WEIGHT")
//    @NotBlank
    public Double weight;

    @Column(name = "KPI_ID")
//    @NotBlank
    public Long kpiId;

    //---------------- ACTIVE RECORD

    public static Optional<HrAppraisal> findById(long id) {
        return find("id = ?1", id).firstResultOptional();
    }

    public static List<HrAppraisal> getAllData() {
        return HrAppraisal.listAll();
    }

}
