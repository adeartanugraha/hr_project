package com.dimata.service.general.harisma.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "hr_assessment_type")
public class HrAssessmentType extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "ASSESSMENT_ID")
    public Long id;

    @Column(name = "ASSESSMENT_TYPE")
    public String assessmentType;

    @Column(name = "DESCRIPTION")
    public String description;

    //---------------- ACTIVE RECORD

    public static Optional<HrAssessmentType> findById(long id) {
        return find("id = ?1", id).firstResultOptional();
    }

    public static List<HrAssessmentType> getAllData() {
        return HrAssessmentType.listAll();
    }
}
