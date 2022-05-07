package com.dimata.service.general.harisma.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "hr_arap_item")
public class HrArapItem extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "arap_item_id")
    public Long id;

//    @Column(name = "arap_main_id")
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "arap_main_id")
    public HrArapMain idArapMain;

    @Column(name = "angsuran")
    public Double angsuran;

    @Column(name = "due_date")
    public LocalDate dueDate;

    @Column(name = "description")
    public String description;

    @Column(name = "left_to_pay")
    public Double leftToPay;

    @Column(name = "rate")
    public Double rate;

    @Column(name = "receive_aktiva_id")
    public Long idReceiveAktiva = Long.valueOf(0);

    @Column(name = "selling_aktiva_id")
    public Long idSellingAktiva = Long.valueOf(0);

    @Column(name = "currency_id")
    public Long idCurrency = Long.valueOf(0);

    @Column(name = "arap_item_status")
    public Integer arapItemStatus;

    @UpdateTimestamp
    @Column(name = "last_update")
    public LocalDateTime lastUpdate;

    //---------------- ACTIVE RECORD

    public static Optional<HrArapItem> findById(long id) {
        return find("id = ?1", id).firstResultOptional();
    }

    public static List<HrArapItem> getAllData() {
        return HrArapItem.listAll();
    }
}
