//package com.dimata.service.general.harisma.entity;
//
//import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "hr_app_main")
//public class HrAppMain extends PanacheEntityBase {
//    @Id
//    @GeneratedValue(generator = "dimata_id_gen")
//    @Column(name = "HR_APP_MAIN_ID")
//    public Long id;
//
//    @Column(name = "EMPLOYEE_ID")
//    @NotBlank
//    public Long employeeId;
//
//    @Column(name = "EMP_POSITION_ID")
//    @NotBlank
//    public Long empPositionId;
//
//    @Column(name = "EMP_DEPARTMENT_ID")
//    @NotBlank
//    public Long empDepartmentId;
//
//    @Column(name = "DATE_ASSUMED_POSITION")
//    @NotBlank
//    public LocalDate dateAssumedPosition;
//
//    @Column(name = "DATE_JOINED_HOTEL")
//    @NotBlank
//    public LocalDate dateJoinedHotel;
//}
