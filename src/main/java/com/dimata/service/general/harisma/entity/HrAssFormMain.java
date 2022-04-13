package com.dimata.service.general.harisma.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "hr_ass_form_main")
public class HrAssFormMain extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "ASS_FORM_MAIN_ID")
    public Long id;

    @Column(name = "GROUP_RANK_ID")
    @NotNull
    public Long groupRankId;

    @Column(name = "TITLE")
    @NotBlank
    public String title;

    @Column(name = "SUBTITLE")
    @NotBlank
    public String subtitle;

    @Column(name = "TITLE_L2")
    @NotBlank
    public String titleL2;

    @Column(name = "SUBTITLE_L2")
    @NotBlank
    public String subtitleL2;

    @Column(name = "MAIN_DATA")
    @NotBlank
    public String mainData;

    @Column(name = "NOTE")
    @NotBlank
    public String note;
}
