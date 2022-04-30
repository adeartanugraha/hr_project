package com.dimata.service.general.harisma.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "hr_arap_creditor")
public class HrArapCreditor extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "ARAP_CREDITOR_ID")
    public Long id;

    @Column(name = "CREDITOR_NAME")
    public String creditorName;

    @Column(name = "DESCRIPTION")
    @Type(type = "text")
    public String description;

    //---------------- ACTIVE RECORD

    public static Optional<HrArapCreditor> findById(long id) {
        return find("id = ?1", id).firstResultOptional();
    }

    public static List<HrArapCreditor> getAllData() {
        return HrArapCreditor.listAll();
    }
}
