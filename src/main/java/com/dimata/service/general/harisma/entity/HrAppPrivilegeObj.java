package com.dimata.service.general.harisma.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "hr_app_privilege_obj")
public class HrAppPrivilegeObj extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "PRIV_OBJ_ID")
    public Long id;

    @Column(name = "PRIV_ID")
    public Long idPriv;

    @Column(name = "CODE")
    public Integer code;
}
