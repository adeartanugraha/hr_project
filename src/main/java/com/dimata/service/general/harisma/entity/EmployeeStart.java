package com.dimata.service.general.harisma.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee_start")
public class EmployeeStart extends PanacheEntityBase {
    @Id
//    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "ID")
    public Long id;

    @Column(name = "REG")
    @Type(type = "text")
    public String reg;

    @Column(name = "NIK")
    @Type(type = "text")
    public String nik;

    @Column(name = "NAME")
    @Type(type = "text")
    public String name;

    @Column(name = "ADDRESS1")
    @Type(type = "text")
    public String address1;

    @Column(name = "ADDRESS2")
    @Type(type = "text")
    public String address2;

    @Column(name = "CITY")
    @Type(type = "text")
    public String city;

    @Column(name = "PHONE")
    public String phone;

    @Column(name = "SEX")
    @Type(type = "text")
    public String sex;

    @Column(name = "RELIGION")
    @Type(type = "text")
    public String religion;

    @Column(name = "DIVITION")
    public Double divition;

    @Column(name = "DEP")
    @Type(type = "text")
    public String dep;

    @Column(name = "LOCATION")
    @Type(type = "text")
    public String location;

    @Column(name = "STATUS")
    @Type(type = "text")
    public String status;

    @Column(name = "POSITION")
    @Type(type = "text")
    public String position;

    @Column(name = "CHILD")
    public Double child;

    @Column(name = "DOB")
    @Type(type = "text")
    public String dob;

    @Column(name = "START")
    public LocalDateTime start;

    @Column(name = "LEVEL")
    public String level;
}
