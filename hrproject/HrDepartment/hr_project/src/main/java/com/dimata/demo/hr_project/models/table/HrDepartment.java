package com.dimata.demo.hr_project.models.table;

import java.time.LocalDate;
import java.util.Objects;

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

@Data
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HrDepartment implements UpdateAvailable<HrDepartment>, Persistable<Long>{
    
    public static final String TABLE_NAME = "hr_department";
    public static final String ID_COL = "DEPARTMENT_ID";
    public static final String DIVISION_ID_COL = "DIVISION_ID";
    public static final String DEPARTMENT_COL = "DEPARTMENT";
    public static final String DESCRIPTION_COL = "DESCRIPTION";
    public static final String JOIN_TO_DEPARTMENT_ID_COL = "JOIN_TO_DEPARTMENT_ID";
    public static final String DEPARTMENT_TYPE_ID_COL = "DEPARTMENT_TYPE_ID";
    public static final String ADDRESS_COL = "ADDRESS";
    public static final String CITY_COL = "CITY";
    public static final String NPWP_COL = "NPWP";
    public static final String PROVINCE_COL = "PROVINCE";
    public static final String REGION_COL = "REGION";
    public static final String SUB_REGION_COL = "SUB_REGION";
    public static final String VILLAGE_COL = "VILLAGE";
    public static final String AREA_COL = "AREA";
    public static final String TELEPHONE_COL = "TELEPHONE";
    public static final String FAX_NUMBER_COL = "FAX_NUMBER";
    public static final String VALID_STATUS_COL = "VALID_STATUS";
    public static final String VALID_START_COL = "VALID_START";
    public static final String VALID_END_COL = "VALID_END";

    @Accessors(fluent = true)
    @Setter
    public static class Builder {

        private Long id;
        private Long divisionId;
        private String department;
        private String description;
        private Long joinToDepartmentId;
        private Long departmentTypeId;
        private String address;
        private String city;
        private String npwp;
        private String province;
        private String region;
        private String subRegion;
        private String village;
        private String area;
        private String telephone;
        private String faxNumber;
        private Integer validStatus;
        private LocalDate validStart;
        private LocalDate validEnd;
        @Setter(AccessLevel.PRIVATE)
        private boolean newRecord = false;

        public static Builder createNewRecord(String department, String city, String npwp, String province, String region, String subRegion, String village) {
            return new Builder().newRecord(true)
                .department(Objects.requireNonNull(department, "Department tidak boleh kosong"))
                .city(Objects.requireNonNull(city, "City tidak boleh kosong"))
                .npwp(Objects.requireNonNull(npwp, "NPWP tidak boleh kosong"))
                .province(Objects.requireNonNull(province, "Province tidak boleh kosong"))
                .region(Objects.requireNonNull(region, "Region tidak boleh kosong"))
                .subRegion(Objects.requireNonNull(subRegion, "Sub Region tidak boleh kosong"))
                .village(Objects.requireNonNull(village, "Village tidak boleh kosong"));
        }

        public static Builder updateBuilder(HrDepartment oldRecord, HrDepartment newRecord) {
            return new Builder()
                .id(oldRecord.getId())
                .divisionId(changeItOrNot(newRecord.getDivisionId(), oldRecord.getDivisionId()))
                .department(changeItOrNot(newRecord.getDepartment(), oldRecord.getDepartment()))
                .description(changeItOrNot(newRecord.getDescription(), oldRecord.getDescription()))
                .joinToDepartmentId(changeItOrNot(newRecord.getJoinToDepartmentId(), oldRecord.getJoinToDepartmentId()))
                .departmentTypeId(changeItOrNot(newRecord.getDepartmentTypeId(), oldRecord.getDepartmentTypeId()))
                .address(changeItOrNot(newRecord.getAddress(), oldRecord.getAddress()))
                .city(changeItOrNot(newRecord.getCity(), oldRecord.getCity()))
                .npwp(changeItOrNot(newRecord.getNpwp(), oldRecord.getNpwp()))
                .province(changeItOrNot(newRecord.getProvince(), oldRecord.getProvince()))
                .region(changeItOrNot(newRecord.getRegion(), oldRecord.getRegion()))
                .subRegion(changeItOrNot(newRecord.getSubRegion(), oldRecord.getSubRegion()))
                .village(changeItOrNot(newRecord.getVillage(), oldRecord.getVillage()))
                .area(changeItOrNot(newRecord.getArea(), oldRecord.getArea()))
                .telephone(changeItOrNot(newRecord.getTelephone(), oldRecord.getTelephone()))
                .faxNumber(changeItOrNot(newRecord.getFaxNumber(), oldRecord.getFaxNumber()))
                .validStatus(changeItOrNot(newRecord.getValidStatus(), oldRecord.getValidStatus()))
                .validStart(changeItOrNot(newRecord.getValidStart(), oldRecord.getValidStart()))
                .validEnd(changeItOrNot(newRecord.getValidEnd(), oldRecord.getValidEnd()));
        }

        public static Builder emptyBuilder() {
            return new Builder();
        }

        public HrDepartment build() {
            HrDepartment result = new HrDepartment();
            
            result.setId(id);
            result.setDivisionId(divisionId);
            result.setDepartment(department);
            result.setDescription(description);
            result.setJoinToDepartmentId(joinToDepartmentId);
            result.setDepartmentTypeId(departmentTypeId);
            result.setAddress(address);
            result.setCity(city);
            result.setNpwp(npwp);
            result.setProvince(province);
            result.setRegion(region);
            result.setSubRegion(subRegion);
            result.setVillage(village);
            result.setArea(area);
            result.setTelephone(telephone);
            result.setFaxNumber(faxNumber);
            result.setValidStatus(validStatus);
            result.setValidStart(validStart);
            result.setValidEnd(validEnd);

            return result;
        }
    }

    @Id
    @Column(ID_COL)
    private Long id;
    private Long divisionId;
    private String department;
    private String description;
    private Long joinToDepartmentId;
    private Long departmentTypeId;
    private String address;
    private String city;
    private String npwp;
    private String province;
    private String region;
    private String subRegion;
    private String village;
    private String area;
    private String telephone;
    private String faxNumber;
    private Integer validStatus;
    private LocalDate validStart;
    private LocalDate validEnd;
    @Transient
    @JsonIgnore
    private Long insertId;


    public static HrDepartment fromRow(Row row) {
        var result = new HrDepartment();
        result.setId(ManipulateUtil.parseRow(row, ID_COL, Long.class));
        result.setDivisionId(ManipulateUtil.parseRow(row, DIVISION_ID_COL, Long.class));
        result.setDepartment(ManipulateUtil.parseRow(row, DEPARTMENT_COL, String.class));
        result.setDescription(ManipulateUtil.parseRow(row, DESCRIPTION_COL, String.class));
        result.setJoinToDepartmentId(ManipulateUtil.parseRow(row, JOIN_TO_DEPARTMENT_ID_COL, Long.class));
        result.setDepartmentTypeId(ManipulateUtil.parseRow(row, DEPARTMENT_TYPE_ID_COL, Long.class));
        result.setAddress(ManipulateUtil.parseRow(row, ADDRESS_COL, String.class));
        result.setCity(ManipulateUtil.parseRow(row, DESCRIPTION_COL, String.class));
        result.setNpwp(ManipulateUtil.parseRow(row, NPWP_COL, String.class));
        result.setProvince(ManipulateUtil.parseRow(row, PROVINCE_COL, String.class));
        result.setRegion(ManipulateUtil.parseRow(row, REGION_COL, String.class));
        result.setSubRegion(ManipulateUtil.parseRow(row, SUB_REGION_COL, String.class));
        result.setVillage(ManipulateUtil.parseRow(row, VILLAGE_COL, String.class));
        result.setArea(ManipulateUtil.parseRow(row, AREA_COL, String.class));
        result.setTelephone(ManipulateUtil.parseRow(row, TELEPHONE_COL, String.class));
        result.setFaxNumber(ManipulateUtil.parseRow(row, FAX_NUMBER_COL, String.class));
        result.setValidStatus(ManipulateUtil.parseRow(row, VALID_STATUS_COL, Integer.class));
        result.setValidStart(ManipulateUtil.parseRow(row, VALID_START_COL, LocalDate.class));
        result.setValidEnd(ManipulateUtil.parseRow(row, VALID_END_COL, LocalDate.class));

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
    public HrDepartment update(HrDepartment newData) {
        return Builder.updateBuilder(this, newData).build();
    }

    
}
