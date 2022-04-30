package com.dimata.service.general.harisma.entity;

import com.dimata.service.general.harisma.entity.enums.HrAppGroupStatus;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "hr_arap_payment")
public class HrArapPayment extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "arap_payment_id")
    public Long id;

    @Column(name = "arap_main_id")
    @NotNull
    public Long idArapMain;

    @Column(name = "payment_no")
    public String paymentNo;

    @Column(name = "payment_date")
    public LocalDate paymentDate;

    @Column(name = "id_perkiraan_payment")
    @NotNull
    public Long idPerkiraanPayment;

    @Column(name = "id_currency")
    @NotNull
    public Long idCurrency;

    @Column(name = "counter")
    @NotNull
    public Integer counter;

    @Column(name = "rate")
    public Double rate;

    @Column(name = "amount")
    public Double amount;

    @Column(name = "selling_aktiva_id")
    @NotNull
    public Long idSellingAktiva;

    @Column(name = "receive_aktiva_id")
    @NotNull
    public Long idReceiveAktiva;

    @Enumerated
    @Column(name = "arap_type")
    @NotNull
    public HrAppGroupStatus arapType;

    @Column(name = "contact_id")
    @NotNull
    public Long idContact;

    @Column(name = "left_to_pay")
    public Double leftToPay;

    @Enumerated
    @Column(name = "payment_status")
    @NotNull
    public HrAppGroupStatus paymentStatus;

    @UpdateTimestamp
    @Column(name = "last_update")
    @NotNull
    public LocalDateTime lastUpdate;

    @Column(name = "jurnal_id")
    public Long idJurnal;

    @Column(name = "bo_payment_id")
    public Long idBoPaymnet;

    @Column(name = "employee_id")
    public Long idEmployee;

    @Enumerated
    @Column(name = "payment_type")
    public HrAppGroupStatus paymentType;

    //---------------- ACTIVE RECORD

    public static Optional<HrArapPayment> findById(long id) {
        return find("id = ?1", id).firstResultOptional();
    }

    public static List<HrArapPayment> getAllData() {
        return HrArapPayment.listAll();
    }
}
