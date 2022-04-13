//package com.dimata.service.general.harisma.entity;
//
//import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//
//@Entity
//@Table(name = "hr_ass_form_section")
//public class HrAssFormSection extends PanacheEntityBase {
//    @Id
//    @GeneratedValue(generator = "dimata_id_gen")
//    @Column(name = "ASS_FORM_SECTION_ID")
//    public Long id;
//
//    @Column(name = "SECTION")
//    @NotBlank
//    public String section;
//
//    @Column(name = "DESCRIPTION")
//    @NotBlank
//    public String description;
//
//    @Column(name = "SECTION_L2")
//    @NotBlank
//    public String sectionL2;
//
//    @Column(name = "DESCRIPTION_L2")
//    @NotBlank
//    public String descriptionL2;
//}
