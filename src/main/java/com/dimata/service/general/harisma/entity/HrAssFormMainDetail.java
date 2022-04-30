package com.dimata.service.general.harisma.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "hr_ass_form_main_detail")
public class HrAssFormMainDetail extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "ASS_FORM_MAIN_ID")
    public Long id;

    @Column(name = "GROUP_RANK_ID")
    public Long idGroupRank;

    //---------------- ACTIVE RECORD

    public static Optional<HrAssFormMainDetail> findById(long id) {
        return find("id = ?1", id).firstResultOptional();
    }

    public static List<HrAssFormMainDetail> getAllData() {
        return HrAssFormMainDetail.listAll();
    }
}
