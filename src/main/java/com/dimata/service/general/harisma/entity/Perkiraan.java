package com.dimata.service.general.harisma.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "aiso_perkiraan")
public class Perkiraan extends PanacheEntityBase {
    @Id
//    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "id_perkiraan")
    public Long id;

    @Column(name = "nomor_perkiraan")
    public String nomorPerkiraan;

    @Column(name = "level")
    public Integer level;

    @Column(name = "nama")
    public String nama;

    @Column(name = "tanda_debet_kredit")
    public Integer tandaDebetKredit;

    @Column(name = "postable")
    public Integer postable;

    @Column(name = "id_parent")
    public Long idParent;

    @Column(name = "department_id")
    public Long idDepartment;

    @Column(name = "account_name_english")
    public String accountNameEnglish;

    @Column(name = "weight")
    public Double weight;

    @Column(name = "general_account_link")
    public Long generalAccountLink;

    @Column(name = "account_group")
    public Integer accountGroup;

    @Column(name = "last_update")
    public LocalDateTime lastUpdate;

    @Column(name = "company_id")
    public Long idCompany;

    @Column(name = "arap_account")
    public Integer arapAccount;

    @Column(name = "expense_type")
    public Integer expenseType;

    @Column(name = "expense_fixed_variable")
    public Integer expenseFixedVariable;

    @Column(name = "kode_perkiraan")
    public String kodePerkiraan;
}
