package com.dimata.service.general.harisma.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

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
    @Type(type = "text")
    public String note;

    //---------------- ACTIVE RECORD

    public static Optional<HrAssFormMain> findById(long id) {
        return find("id = ?1", id).firstResultOptional();
    }

    public static List<HrAssFormMain> getAllData() {
        return HrAssFormMain.listAll();
    }
}
