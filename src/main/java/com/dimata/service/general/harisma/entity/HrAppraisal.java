package com.dimata.service.general.harisma.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;
import org.hibernate.type.TextType;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "hr_appraisal")
public class HrAppraisal extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "HR_APPRAISAL_ID")
    public Long id;

    @Column(name = "EMP_COMMENT")
    @NotBlank
    public TextType empComment;

    @Column(name = "ASS_COMMENT")
    @NotBlank
    public TextType assComment;

    @Column(name = "RATING")
    @NotBlank
    public Double rating;

    @Column(name = "HR_APP_MAIN_ID")
    @NotNull
    public Long hrAppMain;

    @Column(name = "ASS_FORM_ITEM_ID")
    @NotBlank
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
    public TextType answer1;

    @Column(name = "ANSWER_2")
    @NotNull
    public TextType answer2;

    @Column(name = "ANSWER_3")
    @NotNull
    public TextType answer3;

    @Column(name = "ANSWER_4")
    @NotNull
    public TextType answer4;

    @Column(name = "ANSWER_5")
    @NotNull
    public TextType answer5;

    @Column(name = "ANSWER_6")
    @NotNull
    public TextType answer6;

    @Column(name = "REALIZATION")
    @NotBlank
    public BigDecimal realization;

    @Column(name = "EVIDENCE")
    @NotBlank
    public String evidence;

    @Column(name = "POINT")
    @NotBlank
    public BigDecimal point;

    @Column(name = "WEIGHT")
    @NotBlank
    public Double weight;

    @Column(name = "KPI_ID")
    @NotBlank
    public Long kpiId;

    //---------------- ACTIVE RECORD

//    public static boolean isAppExist(long appId, long main) {
//        var count = count("id = ?1 and hrAppMain", appId, main);
//        return count > 0;
//    }

    public static Optional<HrAppraisal> findById(long id) {
        return find("id = ?1", id).firstResultOptional();
    }

//    public static List<HrAppraisal> findByAppMain(long appMain) {
//        return list("hrAppMain.id = ?1", appMain);
//    }
//
//    public static List<HrAppraisal> findByAssFormItem(long formItem) {
//        return list("hrAssFormItem.id = ?1", formItem);
//    }
}
