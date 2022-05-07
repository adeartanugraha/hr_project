package com.dimata.service.general.harisma.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "hr_ass_form_item")
public class HrAssFormItem extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "ASS_FORM_ITEM_ID")
    public Long id;

    @Column(name = "TITLE")
    public String title;

    @Column(name = "TITLE_L2")
    public String titleL2;

    @Column(name = "ITEM_POIN_1")
    @Type(type = "text")
    public String itemPoin1;

    @Column(name = "ITEM_POIN_2")
    @Type(type = "text")
    public String itemPoin2;

    @Column(name = "ITEM_POIN_3")
    @Type(type = "text")
    public String itemPoin3;

    @Column(name = "ITEM_POIN_4")
    @Type(type = "text")
    public String itemPoin4;

    @Column(name = "ITEM_POIN_5")
    @Type(type = "text")
    public String itemPoin5;

    @Column(name = "ITEM_POIN_6")
    @Type(type = "text")
    public String itemPoin6;

    @Column(name = "TYPE")
    public Integer type;

    @Column(name = "ORDER_NUMBER")
    public Integer orderNumber;

    @Column(name = "NUMBER")
    public Integer number;

    @Column(name = "PAGE")
    @NotNull
    public Integer page;

    @Column(name = "HEIGHT")
    @NotNull
    public Integer height;

//    @Column(name = "ASS_FORM_SECTION_ID")
//    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ASS_FORM_SECTION_ID")
    public HrAssFormSection idAssFormSection;

    @Column(name = "KPI_LIST_ID")
    public Long idKpiList = Long.valueOf(0);

    @Column(name = "WEIGHT_POINT")
    public BigDecimal weightPoint;

    @Column(name = "KPI_TARGET")
    public BigDecimal kpiTarget;

    @Column(name = "KPI_UNIT")
    public String kpiUnit;

    @Column(name = "KPI_NOTE")
    public String kpiNote;

    @Column(name = "FORMULA")
    @Type(type = "text")
    public String formula;

    //---------------- ACTIVE RECORD

    public static Optional<HrAssFormItem> findById(long id) {
        return find("id = ?1", id).firstResultOptional();
    }

    public static List<HrAssFormItem> getAllData() {
        return HrAssFormItem.listAll();
    }
}
