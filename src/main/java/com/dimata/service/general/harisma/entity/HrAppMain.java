package com.dimata.service.general.harisma.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "hr_app_main")
public class HrAppMain extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "HR_APP_MAIN_ID")
    public Long id;

//    @Column(name = "EMPLOYEE_ID")
//    public Long employeeId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID")
    public EmployeeStart employeeId;

    @Column(name = "EMP_POSITION_ID")
    public Long empPositionId = Long.valueOf(0);

    @Column(name = "EMP_DEPARTMENT_ID")
    public Long empDepartmentId = Long.valueOf(0);

    @Column(name = "DATE_ASSUMED_POSITION")
    public LocalDate dateAssumedPosition;

    @Column(name = "DATE_JOINED_HOTEL")
    public LocalDate dateJoinedHotel;

    @Column(name = "ASSESSOR_ID")
    public Long assessorId = Long.valueOf(0);

    @Column(name = "ASS_POSITION_ID")
    public Long assPositionId = Long.valueOf(0);

    @Column(name = "DATE_OF_ASSESSMENT")
    public LocalDate dateOfAssessment;

    @Column(name = "DATE_OF_LAST_ASSESSMENT")
    public LocalDate dateOfLastAssessment;

    @Column(name = "DATE_OF_NEXT_ASSESSMENT")
    public LocalDate dateOfNextAssessment;

    @Column(name = "LEVEL_ID")
    public Long levelId = Long.valueOf(0);

    @Column(name = "TOTAL_ASS")
    public Integer totalAss;

    @Column(name = "TOTAL_SCORE")
    public Double totalScore;

    @Column(name = "SCORE_AVERAGE")
    public Double scoreAverage;

    @Column(name = "DIVISION_HEAD")
    public Long divisionHead;

    @Column(name = "EMP_SIGN_DATE")
    public LocalDate empSignDate;

    @Column(name = "ASS_SIGN_DATE")
    public LocalDate assSignDate;

    @Column(name = "DIV_SIGN_DATE")
    public LocalDate divSignDate;

    @Column(name = "APPROVAL_1_ID")
    public Long approval1Id = Long.valueOf(0);

    @Column(name = "TIME_APPROVAL_1")
    public LocalDateTime timeApproval1;

    @Column(name = "APPROVAL_2_ID")
    public Long approval2Id = Long.valueOf(0);

    @Column(name = "TIME_APPROVAL_2")
    public LocalDateTime timeApproval2;

    @Column(name = "APPROVAL_3_ID")
    public Long approval3Id = Long.valueOf(0);

    @Column(name = "TIME_APPROVAL_3")
    public LocalDateTime timeApproval3;

    @Column(name = "APPROVAL_4_ID")
    public Long approval4Id = Long.valueOf(0);

    @Column(name = "TIME_APPROVAL_4")
    public LocalDateTime timeApproval4;

    @Column(name = "APPROVAL_5_ID")
    public Long approval5Id = Long.valueOf(0);

    @Column(name = "TIME_APPROVAL_5")
    public LocalDateTime timeApproval5;

    @Column(name = "APPROVAL_6_ID")
    public Long approval6Id = Long.valueOf(0);

    @Column(name = "TIME_APPROVAL_6")
    public LocalDateTime timeApproval6;

    @Column(name = "DATA_PERIOD_FROM")
    public LocalDate dataPeriodFrom;

    @Column(name = "DATA_PERIOD_TO")
    public LocalDate dataPeriodTo;

    //---------------- ACTIVE RECORD
    public static Optional<HrAppMain> findById(long id) {
        return find("id = ?1", id).firstResultOptional();
    }

    public static List<HrAppMain> getAllData() {
        return HrAppMain.listAll();
    }
}
