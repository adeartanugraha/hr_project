package com.dimata.service.general.harisma.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contact_list")
public class ContactList extends PanacheEntityBase {
    @Id
//    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "CONTACT_ID")
    public Long id;

    @Column(name = "CONTACT_CODE")
    public String contactCode;

    @Column(name = "CONTACT_TYPE")
    public Integer contactType;

    @Column(name = "CIN")
    public String cin;

    @Column(name = "CIN_COUNTER")
    public Integer cinCounter;

    @Column(name = "REG_DATE")
    public LocalDateTime reg_Date;

    @Column(name = "SALUTATION")
    public String salutation;

    @Column(name = "DATE_OF_BIRTH")
    public LocalDateTime dateOfBirth;

    @Column(name = "PERSON_NAME")
    public String personName;

    @Column(name = "PERSON_LASTNAME")
    public String personLastname;

    @Column(name = "MOTHER_NAME")
    public String motherName;

    @Column(name = "NATIONALITY")
    public String nationality;

    @Column(name = "OCCUPATION")
    public String occupation;

    @Column(name = "IGNORE_BIRTH_DATE")
    public Integer ignoreBirthDate;

    @Column(name = "DRIVING_LICENCE_NO")
    public String drivingLicenceNo;

    @Column(name = "PASSPORT_NO")
    public String passportNo;

    @Column(name = "KTP_NO")
    public String ktpNo;

    @Column(name = "HOME_ADDRESS")
    public String homeAddrees;

    @Column(name = "HOME_CITY")
    public String homeCity;

    @Column(name = "HOME_STATE")
    public String homeState;

    @Column(name = "HOME_PO_BOX")
    public String homePOBox;

    @Column(name = "HOME_COUNTRY")
    public String homeCountry;

    @Column(name = "HOME_PH_NUMBER")
    public String homePhNumber;

    @Column(name = "HOME_MOBILE_PHONE")
    public String homeMobileNumber;

    @Column(name = "HOME_EMAIL")
    public String homeEmail;

    @Column(name = "HOME_FAX")
    public String homeFax;

    @Column(name = "HOME_WEBSITE")
    public String homeWebsite;

    @Column(name = "HOME_PROVINCE")
    public String homeProvince;

    @Column(name = "HOME_ZIP_CODE")
    public String homeZipCode;

    @Column(name = "COMP_NAME")
    public String compName;

    @Column(name = "COMP_ADDRESS")
    public String compAddress;

    @Column(name = "COMP_CITY")
    public String compCity;

    @Column(name = "COMP_STATE")
    public String compState;

    @Column(name = "COMP_ZIP_CODE")
    public String comZipCode;

    @Column(name = "COMP_PO_BOX")
    public String compPOBox;

    @Column(name = "COMP_COUNTRY")
    public String compCountry;

    @Column(name = "COMP_PROVINCE")
    public String compProvince;

    @Column(name = "COMP_REGENCY")
    public String compRegency;

    @Column(name = "COMP_PH_NUMBER1")
    public String compPhNumber1;

    @Column(name = "COMP_PH_NUMBER2")
    public String compPhNumber2;

    @Column(name = "COMP_FAX")
    public String compFax;

    @Column(name = "COMP_EMAIL")
    public String compEmail;

    @Column(name = "COMP_WEBSITE")
    public String compWebsite;

    @Column(name = "REFERENCE")
    public String reference;

    @Column(name = "MESSAGE")
    public String message;

    @Column(name = "NOTES")
    public String notes;

    @Column(name = "BANK_ACC")
    public String bankAcc;

    @Column(name = "BANK_ACC2")
    public String bankAcc2;

    @Column(name = "EMPLOYEE_ID")
    public Long idEmployee;

    @Column(name = "PARENT_ID")
    public Long idParent;

    @Column(name = "COUNTRY_ID")
    public Long idCountry;

    @Column(name = "PROCESS_STATUS")
    public Integer processStatus;

    @Column(name = "HOME_ADDR")
    public String homeAddr;

    @Column(name = "HOME_TELP")
    public String homeTelp;

    @Column(name = "HOME_TOWN")
    public String homeTown;

    @Column(name = "MEMBER_BARCODE")
    public String memberBarcode;

    @Column(name = "MEMBER_BIRTH_DATE")
    public LocalDateTime memberBirthDate;

    @Column(name = "MEMBER_COUNTER")
    public Integer memberCounter;

    @Column(name = "MEMBER_GROUP_ID")
    public Long memberGroupId;

    @Column(name = "MEMBER_ID_CARD_NUMBER")
    public String memberIdCardNumber;

    @Column(name = "MEMBER_LAST_UPDATE")
    public LocalDateTime memberLastUpdate;

    @Column(name = "CONSIGMENT_LIMIT")
    public Double consigmentLimit;

    @Column(name = "CREDIT_LIMIT")
    public Double creditLimit;

    @Column(name = "MEMBER_USER_ID")
    public String memberUserId;

    @Column(name = "MEMBER_PASSWORD_ID")
    public String memberPasswordId;

    @Column(name = "CURRENCY_TYPE_ID_CONSIGMENT_LIMIT")
    public Long currencyTypeIdConsigmentLimit;

    @Column(name = "CURRENCY_TYPE_ID_CREDIT_LIMIT")
    public Long currencyTypeIdCreditLimit;

    @Column(name = "EMAIL1")
    public String email1;

    @Column(name = "LAST_UPDATE")
    public LocalDateTime lastUpdate;

    @Column(name = "MEMBER_RELIGION_ID")
    public Long memberReligionId;

    @Column(name = "MEMBER_SEX")
    public Integer memberSex;

    @Column(name = "MEMBER_STATUS")
    public Integer memberStatus;

    @Column(name = "BUSS_ADDRESS")
    public String bussAddress;

    @Column(name = "REGDATE")
    public LocalDateTime regDate;

    @Column(name = "TOWN")
    public String town;

    @Column(name = "PROVINCE")
    public String province;

    @Column(name = "COUNTRY")
    public String country;

    @Column(name = "TELP_NR")
    public String telpNr;

    @Column(name = "TELP_MOBILE")
    public String telpMobile;

    @Column(name = "FAX")
    public String Fax;

    @Column(name = "DIRECTIONS")
    public String directions;

    @Column(name = "EMAIL")
    public String email;

    @Column(name = "COMPANY_BANK_ACC")
    public String companyBankAcc;

    @Column(name = "POSITION_PERSON")
    public String positionPerson;

    @Column(name = "POSTAL_CODE_COMPANY")
    public String postalCodeCompany;

    @Column(name = "WEBSITE_COMPANY")
    public String websiteCompany;

    @Column(name = "EMAIL_COMPANY")
    public String emailCompany;

    @Column(name = "POSTAL_CODE_HOME")
    public String postalCodeHome;

    @Column(name = "DIRECTION")
    public String direction;

    @Column(name = "FULL_NAME")
    public String fullName;

    @Column(name = "LOCATION_ID")
    public Long idLocation;

    @Column(name = "TERM_OF_PAYMENT")
    public Integer termOfPayment;

    @Column(name = "DAYS_TERM_OF_PAYMENT")
    public Integer daysTermOfPayment;

    @Column(name = "SISTEM_OF_PAYMENT")
    public Long sistemOfPayment;

    @Column(name = "WEEK_DAY_OF_PAYMENT")
    public String weekDayOfPayment;

    @Column(name = "WEEK_DAY_OF_SALES_VISIT")
    public String weekDayOfSalesVisit;

    @Column(name = "TERM_OF_DELIVERY")
    public Integer termOfDelivery;
}
