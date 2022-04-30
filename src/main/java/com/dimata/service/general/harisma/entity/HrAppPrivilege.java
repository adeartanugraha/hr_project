package com.dimata.service.general.harisma.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "hr_app_privilege")
public class HrAppPrivilege extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "PRIV_ID")
    public Long id;

    @Column(name = "PRIV_NAME")
    public String privName;

    @CreationTimestamp
    @Column(name = "REG_DATE")
    public LocalDateTime regDate;

    @Column(name = "DESCRIPTION")
    @Type(type = "text")
    public String description;

    //---------------- ACTIVE RECORD

    public static Optional<HrAppPrivilege> findById(long id) {
        return find("id = ?1", id).firstResultOptional();
    }

    public static List<HrAppPrivilege> getAllData() {
        return HrAppPrivilege.listAll();
    }
}
