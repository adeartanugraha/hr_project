package com.dimata.service.general.harisma.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "hr_ass_form_section")
public class HrAssFormSection extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "ASS_FORM_SECTION_ID")
    public Long id;

    @Column(name = "SECTION")
    @NotBlank
    public String section;

    @Column(name = "DESCRIPTION")
    @NotBlank
    public String description;

    @Column(name = "SECTION_L2")
    @NotBlank
    public String sectionL2;

    @Column(name = "DESCRIPTION_L2")
    @NotBlank
    public String descriptionL2;

    @Column(name = "ASS_FORM_MAIN_ID")
    @NotBlank
    public Long idAssFormMain;

    @Column(name = "ORDER_NUMBER")
    @NotNull
    public Integer orderNumber;

    @Column(name = "TYPE_SECTION")
    @NotNull
    public Integer typeSection;

    @Column(name = "PAGE")
    @NotNull
    public Integer page;

    @Column(name = "WEIGHT_POINT")
    @NotBlank
    public BigDecimal weightPoint;

    @Column(name = "POINT_EVALUATION_ID")
    @NotBlank
    public Long idPointEvaluation;

    @Column(name = "PREDICATE_EVALUATION_ID")
    @NotBlank
    public Long idPredicateEvaluation;

    //---------------- ACTIVE RECORD

    public static Optional<HrAssFormSection> findById(long id) {
        return find("id = ?1", id).firstResultOptional();
    }

    public static List<HrAssFormSection> getAllData() {
        return HrAssFormSection.listAll();
    }
}
