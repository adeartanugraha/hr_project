//package com.dimata.service.general.harisma.entity;
//
//
//import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
//import io.smallrye.common.constraint.NotNull;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//
//@Entity
//@Table(name = "hr_ass_form_item")
//public class HrAssFormItem extends PanacheEntityBase {
//    @Id
//    @GeneratedValue(generator = "dimata_id_gen")
//    @Column(name = "ASS_FORM_ITEM_ID")
//    public Long id;
//
//    @Column(name = "TITLE")
//    @NotBlank
//    public String title;
//
//    @Column(name = "TITLE_L2")
//    @NotBlank
//    public String titleL2;
//
//    @Column(name = "ITEM_POIN_1")
//    @NotBlank
//    public String itemPoin1;
//
//    @Column(name = "ITEM_POIN_2")
//    @NotBlank
//    public String itemPoin2;
//
//    @Column(name = "ITEM_POIN_3")
//    @NotBlank
//    public String itemPoin3;
//
//    @Column(name = "ITEM_POIN_4")
//    @NotBlank
//    public String itemPoin4;
//
//    @Column(name = "ITEM_POIN_5")
//    @NotBlank
//    public String itemPoin5;
//
//    @Column(name = "ITEM_POIN_6")
//    @NotBlank
//    public String itemPoin6;
//
//    @Column(name = "TYPE")
//    @NotBlank
//    public Integer type;
//
//    @Column(name = "ORDER_NUMBER")
//    @NotBlank
//    public Integer orderNumber;
//
//    @Column(name = "NUMBER")
//    @NotBlank
//    public Integer number;
//
//    @Column(name = "PAGE")
//    @NotNull
//    public Integer page;
//
//    @Column(name = "HEIGHT")
//    @NotNull
//    public Integer height;
//}
