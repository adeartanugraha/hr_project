package com.dimata.demo.hr_project.models.table;

import java.time.LocalDate;
import java.util.Objects;

import javax.print.DocFlavor.STRING;

import static com.dimata.demo.hr_project.core.util.ManipulateUtil.changeItOrNot;

import com.dimata.demo.hr_project.core.api.UpdateAvailable;
import com.dimata.demo.hr_project.core.util.GenerateUtil;
import com.dimata.demo.hr_project.core.util.ManipulateUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import io.r2dbc.spi.Row;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.bytebuddy.implementation.bytecode.Division;

@Data
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HrDivision implements UpdateAvailable<HrDivision>, Persistable<Long>{
    
    public static final String TABLE_NAME = "hr_division";
    public static final String ID_COL = "DIVISION_ID";
    public static final String DIVISION_COL = "DIVISION";
    public static final String COMPANY_ID_COL = "COMPANY_ID";
    public static final String DIVISION_TYPE_ID_COL = "DIVISION_TYPE_ID";
    public static final String DESCRIPTION_COL = "DESCRIPTION";
    public static final String CITY_COL = "CITY";
    public static final String NPWP_COL = "NPWP";
    public static final String PROVINCE_COL = "PROVINCE";
    public static final String REGION_COL = "REGION";
    public static final String SUB_REGION_COL = "SUB_REGION";
    public static final String VILLAGE_COL = "VILLAGE";
    public static final String AREA_COL = "AREA";
    public static final String TELEPHONE_COL = "TELEPHONE";
    public static final String FAX_NUMBER_COL = "FAX_NUMBER";
    public static final String TYPE_OF_DIVISION_COL = "TYPE_OF_DIVISION";
    public static final String VALID_STATUS_COL = "VALID_STATUS";
    public static final String VALID_START_COL = "VALID_START";
    public static final String VALID_END_COL = "VALID_END";
    public static final String PEMOTONG_COL = "PEMOTONG";
    public static final String EMPLOYE_ID_COL = "EMPLOYE_ID";

    @Accessors(fluent = true)
    @Setter
    public static class Builder {

        private Long id;
        private String division;
        private Long companyId;
        private Long divisionTypeId;
        private String description;
        private String city;
        private String npwp;
        private String province;
        private String region;
        private String subRegion;
        private String village;
        private String area;
        private String telephone;
        private String faxNumber;
        private Integer typeOfDivision;
        private Integer validStatus;
        private LocalDate validStart;
        private LocalDate validEnd;
        private String pemotong;
        private Long employeeId;
        @Setter(AccessLevel.PRIVATE)
        private boolean newRecord = false;

        public static Builder createNewRecord(String division, String city, String npwp, String province, String region, String subRegion, String village) {
            return new Builder().newRecord(true)
                .division(Objects.requireNonNull(division, "Division pany tidak boleh kosong"))
                .city(Objects.requireNonNull(city, "City tidak boleh kosong"))
                .npwp(Objects.requireNonNull(npwp, "NPWP tidak boleh kosong"))
                .province(Objects.requireNonNull(province, "Province tidak boleh kosong"))
                .region(Objects.requireNonNull(region, "Region tidak boleh kosong"))
                .subRegion(Objects.requireNonNull(subRegion, "Sub Region tidak boleh kosong"))
                .village(Objects.requireNonNull(village, "Village tidak boleh kosong"));
        }

        public static Builder updateBuilder(HrDivision oldRecord, HrDivision newRecord) {
            return new Builder()
                .id(oldRecord.getId())
                .division(changeItOrNot(newRecord.getDivision(), oldRecord.getDivision()))
                .companyId(changeItOrNot(newRecord.getCompanyId(), oldRecord.getCompanyId()))
                .divisionTypeId(changeItOrNot(newRecord.getDivisionTypeId(), oldRecord.getDivisionTypeId()))
                .description(changeItOrNot(newRecord.getDescription(), oldRecord.getDescription()))
                .city(changeItOrNot(newRecord.getCity(), oldRecord.getCity()))
                .npwp(changeItOrNot(newRecord.getNpwp(), oldRecord.getNpwp()))
                .province(changeItOrNot(newRecord.getProvince(), oldRecord.getProvince()))
                .region(changeItOrNot(newRecord.getRegion(), oldRecord.getRegion()))
                .subRegion(changeItOrNot(newRecord.getSubRegion(), oldRecord.getSubRegion()))
                .village(changeItOrNot(newRecord.getVillage(), oldRecord.getVillage()))
                .area(changeItOrNot(newRecord.getArea(), oldRecord.getArea()))
                .telephone(changeItOrNot(newRecord.getTelephone(), oldRecord.getTelephone()))
                .faxNumber(changeItOrNot(newRecord.getFaxNumber(), oldRecord.getFaxNumber()))
                .typeOfDivision(changeItOrNot(newRecord.getTypeOfDivision(), oldRecord.getTypeOfDivision()))
                .validStatus(changeItOrNot(newRecord.getValidStatus(), oldRecord.getValidStatus()))
                .validStart(changeItOrNot(newRecord.getValidStart(), oldRecord.getValidStart()))
                .validEnd(changeItOrNot(newRecord.getValidEnd(), oldRecord.getValidEnd()))
                .pemotong(changeItOrNot(newRecord.getPemotong(), oldRecord.getPemotong()))
                .employeeId(changeItOrNot(newRecord.getEmployeeId(), oldRecord.getEmployeeId()));
        }

        public static Builder emptyBuilder() {
            return new Builder();
        }

        public HrDivision build() {
            HrDivision result = new HrDivision();
            
            result.setId(id);
            result.setDivision(division);
            result.setCompanyId(companyId);
            result.setDivisionTypeId(divisionTypeId);
            result.setDescription(description);
            result.setCity(city);
            result.setNpwp(npwp);
            result.setProvince(province);
            result.setRegion(region);
            result.setSubRegion(subRegion);
            result.setVillage(village);
            result.setArea(area);
            result.setTelephone(telephone);
            result.setFaxNumber(faxNumber);
            result.setTypeOfDivision(typeOfDivision);
            result.setValidStatus(validStatus);
            result.setValidStart(validStart);
            result.setValidEnd(validEnd);
            result.setPemotong(pemotong);
            result.setEmployeeId(employeeId);

            return result;
        }
    }

    @Id
    @Column(ID_COL)
    private Long id;
    private String division;
    private Long companyId;
    private Long divisionTypeId;
    private String description;
    private String city;
    private String npwp;
    private String province;
    private String region;
    private String subRegion;
    private String village;
    private String area;
    private String telephone;
    private String faxNumber;
    private Integer typeOfDivision;
    private Integer validStatus;
    private LocalDate validStart;
    private LocalDate validEnd;
    private String pemotong;
    private Long employeeId;
    @Transient
    @JsonIgnore
    private Long insertId;


    public static HrDivision fromRow(Row row) {
        var result = new HrDivision();
        result.setId(ManipulateUtil.parseRow(row, ID_COL, Long.class));
        result.setDivision(ManipulateUtil.parseRow(row, DIVISION_COL, String.class));
        result.setCompanyId(ManipulateUtil.parseRow(row, COMPANY_ID_COL, Long.class));
        result.setDivisionTypeId(ManipulateUtil.parseRow(row, DIVISION_TYPE_ID_COL, Long.class));
        result.setDescription(ManipulateUtil.parseRow(row, DESCRIPTION_COL, String.class));
        result.setCity(ManipulateUtil.parseRow(row, DESCRIPTION_COL, String.class));
        result.setNpwp(ManipulateUtil.parseRow(row, NPWP_COL, String.class));
        result.setProvince(ManipulateUtil.parseRow(row, PROVINCE_COL, String.class));
        result.setRegion(ManipulateUtil.parseRow(row, REGION_COL, String.class));
        result.setSubRegion(ManipulateUtil.parseRow(row, SUB_REGION_COL, String.class));
        result.setVillage(ManipulateUtil.parseRow(row, VILLAGE_COL, String.class));
        result.setArea(ManipulateUtil.parseRow(row, AREA_COL, String.class));
        result.setTelephone(ManipulateUtil.parseRow(row, TELEPHONE_COL, String.class));
        result.setFaxNumber(ManipulateUtil.parseRow(row, FAX_NUMBER_COL, String.class));
        result.setTypeOfDivision(ManipulateUtil.parseRow(row, TYPE_OF_DIVISION_COL, Integer.class));
        result.setValidStatus(ManipulateUtil.parseRow(row, VALID_STATUS_COL, Integer.class));
        result.setValidStart(ManipulateUtil.parseRow(row, VALID_START_COL, LocalDate.class));
        result.setValidEnd(ManipulateUtil.parseRow(row, VALID_END_COL, LocalDate.class));
        result.setPemotong(ManipulateUtil.parseRow(row, PEMOTONG_COL, String.class));
        result.setEmployeeId(ManipulateUtil.parseRow(row, EMPLOYE_ID_COL, Long.class));

        return result;
    }

    @Override
    public boolean isNew() {
        if (id == null && insertId == null) {
            id = new GenerateUtil().generateOID();
            return true;
        } else if (id == null) {
            id = insertId;
            return true;
        }
        return false;
    }

    @Override
    public HrDivision update(HrDivision newData) {
        return Builder.updateBuilder(this, newData).build();
    }

    
}
