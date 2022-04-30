package com.dimata.service.general.harisma.entity;

import com.dimata.service.general.harisma.entity.enums.HrAppGroupStatus;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "hr_arap_main")
public class HrArapMain extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "arap_main_id")
    public Long id;

    @Column(name = "voucher_no")
    public String voucherNo;

    @Column(name = "voucher_date")
    public LocalDate voucherDate;

    @Column(name = "contact_id")
    @NotNull
    public Long idContact;

    @Column(name = "number_of_payment")
    @NotNull
    public Integer numberOfPayment;

    @Column(name = "id_perkiraan_lawan")
    @NotNull
    public Long idPerkiraanLawan;

    @Column(name = "id_perkiraan")
    @NotNull
    public Long idPerkiraan;

    @Column(name = "id_currency")
    @NotNull
    public Long idCurrency;

    @Column(name = "counter")
    public Integer counter;

    @Column(name = "rate")
    public Double rate;

    @Column(name = "amount")
    public Double amount;

    @Column(name = "nota_no")
    public String notaNo;

    @Column(name = "nota_date")
    public LocalDate notaDate;

    @Column(name = "description")
    @Type(type = "text")
    public String description;

    @Column(name = "arap_type")
    @NotNull
    public Integer arapType;

    @Column(name = "arap_doc_status")
    @NotNull
    public Integer arapDocStatus;

    @Column(name = "arap_main_status")
    @NotNull
    public Integer arapMainStatus;

    @UpdateTimestamp
    @Column(name = "last_update")
    @NotNull
    public LocalDateTime lastUpdate;

    @Column(name = "jurnal_id")
    public Long idJurnal;

    @Column(name = "component_deduction_id")
    public Long idComponentDeduction;

    @Column(name = "employee_id")
    public Long idEmployee;

    @Column(name = "entry_date")
    public LocalDate entryDate;

    @Enumerated
    @Column(name = "period_every")
    public HrAppGroupStatus periodEvery;

    @Enumerated
    @Column(name = "period_every_dmy")
    public HrAppGroupStatus periodEveryDmy;

    @Column(name = "start_of_payment_date")
    public LocalDate startOfPaymentDate;

    @Column(name = "payment_amount_plan")
    public Double paymentAmountPlan;

    @Enumerated
    @Column(name = "PERIOD_TYPE")
    public HrAppGroupStatus periodType;

    @Column(name = "PERIOD_ID")
    public Long idPeriod;

    //---------------- ACTIVE RECORD

    public static Optional<HrArapMain> findById(long id) {
        return find("id = ?1", id).firstResultOptional();
    }

    public static List<HrArapMain> getAllData() {
        return HrArapMain.listAll();
    }
}
