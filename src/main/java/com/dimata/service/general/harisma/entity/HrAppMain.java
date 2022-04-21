package com.dimata.service.general.harisma.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "hr_app_main")
public class HrAppMain extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "HR_APP_MAIN_ID")
    public Long id;

    @Column(name = "EMPLOYEE_ID")
    @NotBlank
    public Long employeeId;

    @Column(name = "EMP_POSITION_ID")
    @NotBlank
    public Long empPositionId;

    @Column(name = "EMP_DEPARTMENT_ID")
    @NotBlank
    public Long empDepartmentId;

    @Column(name = "DATE_ASSUMED_POSITION")
    @NotBlank
    public LocalDate dateAssumedPosition;

    @Column(name = "DATE_JOINED_HOTEL")
    @NotBlank
    public LocalDate dateJoinedHotel;

    @Column(name = "ASSESSOR_ID")
    @NotBlank
    public Long assessorId;

    @Column(name = "ASS_POSITION_ID")
    @NotBlank
    public Long assPositionId;

    @Column(name = "DATE_OF_ASSESSMENT")
    @NotBlank
    public LocalDate dateOfAssessment;

    @Column(name = "DATE_OF_LAST_ASSESSMENT")
    @NotBlank
    public LocalDate dateOfLastAssessment;

    @Column(name = "DATE_OF_NEXT_ASSESSMENT")
    @NotBlank
    public LocalDate dateOfNextAssessment;

    @Column(name = "LEVEL_ID")
    @NotBlank
    public Long levelId;

    @Column(name = "TOTAL_ASS")
    @NotBlank
    public Integer totalAss;

    @Column(name = "TOTAL_SCORE")
    @NotBlank
    public Double totalScore;

    @Column(name = "SCORE_AVERAGE")
    @NotBlank
    public Double scoreAverage;

    @Column(name = "DIVISION_HEAD")
    @NotBlank
    public Long divisionHead;

    @Column(name = "EMP_SIGN_DATE")
    @NotBlank
    public LocalDate empSignDate;

    @Column(name = "ASS_SIGN_DATE")
    @NotBlank
    public LocalDate assSignDate;

    @Column(name = "DIV_SIGN_DATE")
    @NotBlank
    public LocalDate divSignDate;

    @Column(name = "APPROVAL_1_ID")
    @NotBlank
    public Long approval1Id;

    @Column(name = "TIME_APPROVAL_1")
    @NotBlank
    public LocalDateTime timeApproval1;

    @Column(name = "APPROVAL_2_ID")
    @NotBlank
    public Long approval2Id;

    @Column(name = "TIME_APPROVAL_2")
    @NotBlank
    public LocalDateTime timeApproval2;

    @Column(name = "APPROVAL_3_ID")
    @NotBlank
    public Long approval3Id;

    @Column(name = "TIME_APPROVAL_3")
    @NotBlank
    public LocalDateTime timeApproval3;

    @Column(name = "APPROVAL_4_ID")
    @NotBlank
    public Long approval4Id;

    @Column(name = "TIME_APPROVAL_4")
    @NotBlank
    public LocalDateTime timeApproval4;

    @Column(name = "APPROVAL_5_ID")
    @NotBlank
    public Long approval5Id;

    @Column(name = "TIME_APPROVAL_5")
    @NotBlank
    public LocalDateTime timeApproval5;

    @Column(name = "APPROVAL_6_ID")
    @NotBlank
    public Long approval6Id;

    @Column(name = "TIME_APPROVAL_6")
    @NotBlank
    public LocalDateTime timeApproval6;

    @Column(name = "DATA_PERIOD_FROM")
    @NotBlank
    public LocalDate dataPeriodFrom;

    @Column(name = "DATA_PERIOD_TO")
    @NotBlank
    public LocalDate dataPeriodTo;

    //---------------- ACTIVE RECORD
    public static Optional<HrAppMain> findById(long id) {
        return find("id = ?1", id).firstResultOptional();
    }

}
