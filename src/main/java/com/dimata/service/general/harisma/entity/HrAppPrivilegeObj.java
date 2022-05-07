package com.dimata.service.general.harisma.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "hr_app_privilege_obj")
public class HrAppPrivilegeObj extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "PRIV_OBJ_ID")
    public Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRIV_ID")
    public HrAppPrivilege idPriv;

    @Column(name = "CODE")
    public Integer code;

    //---------------- ACTIVE RECORD

    public static Optional<HrAppPrivilegeObj> findById(long id) {
        return find("id = ?1", id).firstResultOptional();
    }

    public static List<HrAppPrivilegeObj> getAllData() {
        return HrAppPrivilegeObj.listAll();
    }
}
