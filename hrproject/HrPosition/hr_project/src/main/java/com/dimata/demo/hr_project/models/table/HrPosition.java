package com.dimata.demo.hr_project.models.table;

import java.time.LocalDate;
import java.util.Objects;

import javax.swing.text.Position;

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
public class HrPosition implements UpdateAvailable<HrPosition>, Persistable<Long>{
    
    public static final String TABLE_NAME = "hr_position";
    public static final String ID_COL = "POSITION_ID";
    public static final String POSITION_COL = "POSITION";
    public static final String DESCRIPTION_COL = "DESCRIPTION";
    public static final String POSITION_LEVEL_COL = "POSITION_LEVEL";
    public static final String DISABLED_APP_UNDER_SUPERVISOR_COL = "DISABLED_APP_UNDER_SUPERVISOR";
    public static final String DISABLED_APP_DEPT_SCOPE_COL = "DISABLED_APP_DEPT_SCOPE";
    public static final String DISABLED_APP_DIV_SCOPE_COL = "DISABLED_APP_DIV_SCOPE";
    public static final String ALL_DEPARTMENT_COL = "ALL_DEPARTMENT";
    public static final String DEDLINE_SCH_BEFORE_COL = "DEDLINE_SCH_BEFORE";
    public static final String DEDLINE_SCH_AFTER_COL = "DEDLINE_SCH_AFTER";
    public static final String DEDLINE_SCH_LEAVE_BEFORE_COL = "DEDLINE_SCH_LEAVE_BEFORE";
    public static final String DEDLINE_SCH_LEAVE_AFTER_COL = "DEDLINE_SCH_LEAVE_AFTER";
    public static final String HEAD_TITLE = "HEAD_TITLE";
    public static final String POSITION_LEVEL_PAYROL_COL = "POSITION_LEVEL_PAYROL";
    public static final String POSITION_KODE_COL = "POSITION_KODE";
    public static final String FLAG_POSITION_SHOW_IN_PAYROLL_INPUT_COL = "FLAG_POSITION_SHOW_IN_PAYROLL_INPUT";
    public static final String AGE_MIN_COL = "AGE_MIN";
    public static final String AGE_RECOMMENDED_COL = "AGE_RECOMMENDED";
    public static final String AGE_MAX_COL = "AGE_MAX";
    public static final String LENGTH_OF_SERVICE_MIN_COL = "LENGTH_OF_SERVICE_MIN";
    public static final String LENGTH_OF_SERVICE_RECOMMENDED_COL = "LENGTH_OF_SERVICE_RECOMMENDED";
    public static final String LENGTH_OF_EXPERIENCE_MIN_COL = "LENGTH_OF_EXPERIENCE_MIN";
    public static final String LENGTH_OF_EXPERIENCE_RECOMMENDED_COL = "LENGTH_OF_EXPERIENCE_RECOMMENDED";
    public static final String VALID_STATUS_COL = "VALID_STATUS";
    public static final String VALID_START_COL = "VALID_START";
    public static final String VALID_END_COL = "VALID_END";
    public static final String LEVEL_ID_COL = "LEVEL_ID";
    public static final String START_DATE_COL = "START_DATE";
    public static final String END_DATE_COL = "END_DATE";
    public static final String POSITION_GROUP_ID_COL = "POSITION_GROUP_ID";
    public static final String TENAGA_KERJA_COL = "TENAGA_KERJA";
    public static final String JENIS_JABATAN_COL = "JENIS_JABATAN";
    public static final String ALIAS = "ALIAS";
    public static final String POSITION_TYPE_ID_COL = "POSITION_TYPE_ID";

    @Accessors(fluent = true)
    @Setter
    public static class Builder {

        private Long id;
        private String position;
        private String description;
        private Integer positionLevel;
        private Integer disableAppUnderSupervisor;
        private Integer disableAppDebtScore;
        private Integer disableAppDivScore;
        private Integer allDepartment;
        private Integer dedlineSchBefore;
        private Integer dedlineSchAfter;
        private Integer dedlineSchLeaveBefore;
        private Integer dedlineSchLeaveAfter;
        private Integer headTitle;
        private Integer positionLevelPayrol;
        private String positionKode;
        private Integer flagPositionShowInPayrollInput;
        private Integer ageMin;
        private Integer ageRecommended;
        private Integer ageMax;
        private Integer lengthOfServiceMin;
        private Integer lengthOfServiceRecommended;
        private Integer lengthOfExperienceMin;
        private Integer lengthOfExperienceRecommended;
        private Integer validStatus;
        private LocalDate validStart;
        private LocalDate validEnd;
        private Long levelId;
        private LocalDate startDate;
        private LocalDate endDate;
        private Long positionGroupId;
        private Integer tenagaKerja;
        private Integer jenisJabatan;
        private String alias;
        private Long positionTypeId;
        @Setter(AccessLevel.PRIVATE)
        private boolean newRecord = false;

        public static Builder createNewRecord(String position, String city, String npwp, String province, String region, String subRegion, String village) {
            return new Builder().newRecord(true)
                .position(Objects.requireNonNull(position, "position tidak boleh kosong"));
                // .city(Objects.requireNonNull(city, "City tidak boleh kosong"))
                // .npwp(Objects.requireNonNull(npwp, "NPWP tidak boleh kosong"))
                // .province(Objects.requireNonNull(province, "Province tidak boleh kosong"))
                // .region(Objects.requireNonNull(region, "Region tidak boleh kosong"))
                // .subRegion(Objects.requireNonNull(subRegion, "Sub Region tidak boleh kosong"))
                // .village(Objects.requireNonNull(village, "Village tidak boleh kosong"));
        }

        public static Builder updateBuilder(HrPosition oldRecord, HrPosition newRecord) {
            return new Builder()
                .id(oldRecord.getId())
                .position(changeItOrNot(newRecord.getPosition(), oldRecord.getPosition()))
                .description(changeItOrNot(newRecord.getDescription(), oldRecord.getDescription()))
                .positionLevel(changeItOrNot(newRecord.getPositionLevel(), oldRecord.getPositionLevel()))
                .disableAppUnderSupervisor(changeItOrNot(newRecord.getDisableAppDebtScore(), oldRecord.getDisableAppUnderSupervisor()))
                .disableAppDebtScore(changeItOrNot(newRecord.getDisableAppDebtScore(), oldRecord.getDisableAppDebtScore()))
                .disableAppDivScore(changeItOrNot(newRecord.getDisableAppDivScore(), oldRecord.getDisableAppDivScore()))
                .allDepartment(changeItOrNot(newRecord.getAllDepartment(), oldRecord.getAllDepartment()))
                .dedlineSchBefore(changeItOrNot(newRecord.getDedlineSchBefore(), oldRecord.getDedlineSchBefore()))
                .dedlineSchAfter(changeItOrNot(newRecord.getDedlineSchAfter(), oldRecord.getDedlineSchAfter()))
                .dedlineSchLeaveBefore(changeItOrNot(newRecord.getDedlineSchLeaveBefore(), oldRecord.getDedlineSchLeaveBefore()))
                .dedlineSchLeaveAfter(changeItOrNot(newRecord.getDedlineSchLeaveAfter(), oldRecord.getDedlineSchLeaveAfter()))
                .headTitle(changeItOrNot(newRecord.getHeadTitle(), oldRecord.getHeadTitle()))
                .positionLevelPayrol(changeItOrNot(newRecord.getPositionLevelPayrol(), oldRecord.getPositionLevelPayrol()))
                .positionKode(changeItOrNot(newRecord.getPositionKode(), oldRecord.getPositionKode()))
                .flagPositionShowInPayrollInput(changeItOrNot(newRecord.getFlagPositionShowInPayrollInput(), oldRecord.getFlagPositionShowInPayrollInput()))
                .ageMin(changeItOrNot(newRecord.getAgeMin(), oldRecord.getAgeMin()))
                .ageRecommended(changeItOrNot(newRecord.getAgeRecommended(), oldRecord.getAgeRecommended()))
                .ageMax(changeItOrNot(newRecord.getAgeMax(), oldRecord.getAgeMax()))
                .lengthOfServiceMin(changeItOrNot(newRecord.getLengthOfServiceMin(), oldRecord.getLengthOfServiceMin()))
                .lengthOfServiceRecommended(changeItOrNot(newRecord.getLengthOfServiceRecommended(), oldRecord.getLengthOfServiceRecommended()))
                .lengthOfExperienceMin(changeItOrNot(newRecord.getLengthOfExperienceMin(), oldRecord.getLengthOfExperienceMin()))
                .lengthOfExperienceRecommended(changeItOrNot(newRecord.getLengthOfExperienceRecommended(), oldRecord.getLengthOfExperienceRecommended()))
                .validStatus(changeItOrNot(newRecord.getValidStatus(), oldRecord.getValidStatus()))
                .validStart(changeItOrNot(newRecord.getValidStart(), oldRecord.getValidStart()))
                .validEnd(changeItOrNot(newRecord.getValidEnd(), oldRecord.getValidEnd()))
                .levelId(changeItOrNot(newRecord.getLevelId(), oldRecord.getLevelId()))
                .startDate(changeItOrNot(newRecord.getStartDate(), oldRecord.getStartDate()))
                .endDate(changeItOrNot(newRecord.getEndDate(), oldRecord.getEndDate()))
                .positionGroupId(changeItOrNot(newRecord.getPositionGroupId(), oldRecord.getPositionGroupId()))
                .tenagaKerja(changeItOrNot(newRecord.getTenagaKerja(), oldRecord.getTenagaKerja()))
                .jenisJabatan(changeItOrNot(newRecord.getJenisJabatan(), oldRecord.getJenisJabatan()))
                .positionTypeId(changeItOrNot(newRecord.getPositionTypeId(), oldRecord.getPositionTypeId()));
        }

        public static Builder emptyBuilder() {
            return new Builder();
        }

        public HrPosition build() {
            HrPosition result = new HrPosition();
            
            result.setId(id);
            result.setPosition(position);
            result.setDescription(description);
            result.setPositionLevel(positionLevel);
            result.setDisableAppUnderSupervisor(disableAppUnderSupervisor);
            result.setDisableAppDebtScore(disableAppDebtScore);
            result.setDisableAppDivScore(disableAppDivScore);
            result.setAllDepartment(allDepartment);
            result.setDedlineSchBefore(dedlineSchBefore);
            result.setDedlineSchAfter(dedlineSchAfter);
            result.setDedlineSchLeaveBefore(dedlineSchLeaveBefore);
            result.setDedlineSchLeaveAfter(dedlineSchLeaveAfter);
            result.setHeadTitle(headTitle);
            result.setPositionLevelPayrol(positionLevelPayrol);
            result.setPositionKode(positionKode);
            result.setFlagPositionShowInPayrollInput(flagPositionShowInPayrollInput);
            result.setAgeMin(ageMin);
            result.setAgeRecommended(ageRecommended);
            result.setAgeMax(ageMax);
            result.setLengthOfServiceMin(lengthOfServiceMin);
            result.setLengthOfServiceRecommended(lengthOfServiceRecommended);
            result.setLengthOfExperienceMin(lengthOfExperienceMin);
            result.setLengthOfExperienceRecommended(lengthOfExperienceRecommended);
            result.setValidStatus(validStatus);
            result.setValidStart(validStart);
            result.setValidEnd(validEnd);
            result.setLevelId(levelId);
            result.setStartDate(startDate);
            result.setEndDate(endDate);
            result.setPositionGroupId(positionGroupId);
            result.setTenagaKerja(tenagaKerja);
            result.setJenisJabatan(jenisJabatan);
            result.setAlias(alias);
            result.setPositionTypeId(positionTypeId);

            return result;
        }
    }

    @Id
    @Column(ID_COL)
    private Long id;
    private String position;
    private String description;
    private Integer positionLevel;
    private Integer disableAppUnderSupervisor;
    private Integer disableAppDebtScore;
    private Integer disableAppDivScore;
    private Integer allDepartment;
    private Integer dedlineSchBefore;
    private Integer dedlineSchAfter;
    private Integer dedlineSchLeaveBefore;
    private Integer dedlineSchLeaveAfter;
    private Integer headTitle;
    private Integer positionLevelPayrol;
    private String positionKode;
    private Integer flagPositionShowInPayrollInput;
    private Integer ageMin;
    private Integer ageRecommended;
    private Integer ageMax;
    private Integer lengthOfServiceMin;
    private Integer lengthOfServiceRecommended;
    private Integer lengthOfExperienceMin;
    private Integer lengthOfExperienceRecommended;
    private Integer validStatus;
    private LocalDate validStart;
    private LocalDate validEnd;
    private Long levelId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long positionGroupId;
    private Integer tenagaKerja;
    private Integer jenisJabatan;
    private String alias;
    private Long positionTypeId;
    @Transient
    @JsonIgnore
    private Long insertId;


    public static HrPosition fromRow(Row row) {
        var result = new HrPosition();
        result.setId(ManipulateUtil.parseRow(row, ID_COL, Long.class));
        result.setPosition(ManipulateUtil.parseRow(row, POSITION_COL, String.class));
        result.setDescription(ManipulateUtil.parseRow(row, DESCRIPTION_COL, String.class));
        result.setPositionLevel(ManipulateUtil.parseRow(row, POSITION_LEVEL_COL, Integer.class));
        result.setDisableAppUnderSupervisor(ManipulateUtil.parseRow(row, DISABLED_APP_UNDER_SUPERVISOR_COL, Integer.class));
        result.setDisableAppDebtScore(ManipulateUtil.parseRow(row, DISABLED_APP_DEPT_SCOPE_COL, Integer.class));
        result.setDisableAppDivScore(ManipulateUtil.parseRow(row, DISABLED_APP_DIV_SCOPE_COL, Integer.class));
        result.setAllDepartment(ManipulateUtil.parseRow(row, ALL_DEPARTMENT_COL, Integer.class));
        result.setDedlineSchBefore(ManipulateUtil.parseRow(row, DEDLINE_SCH_BEFORE_COL, Integer.class));
        result.setDedlineSchAfter(ManipulateUtil.parseRow(row, DEDLINE_SCH_AFTER_COL, Integer.class));
        result.setDedlineSchLeaveBefore(ManipulateUtil.parseRow(row, DEDLINE_SCH_LEAVE_BEFORE_COL, Integer.class));
        result.setDedlineSchLeaveAfter(ManipulateUtil.parseRow(row, DEDLINE_SCH_LEAVE_AFTER_COL, Integer.class));
        result.setHeadTitle(ManipulateUtil.parseRow(row, HEAD_TITLE, Integer.class));
        result.setPositionLevelPayrol(ManipulateUtil.parseRow(row, POSITION_LEVEL_PAYROL_COL, Integer.class));
        result.setPositionKode(ManipulateUtil.parseRow(row, POSITION_KODE_COL, String.class));
        result.setAgeMin(ManipulateUtil.parseRow(row, AGE_MIN_COL, Integer.class));
        result.setAgeRecommended(ManipulateUtil.parseRow(row, AGE_RECOMMENDED_COL, Integer.class));
        result.setAgeMax(ManipulateUtil.parseRow(row, AGE_MAX_COL, Integer.class));
        result.setLengthOfServiceMin(ManipulateUtil.parseRow(row, LENGTH_OF_SERVICE_MIN_COL, Integer.class));
        result.setLengthOfServiceRecommended(ManipulateUtil.parseRow(row, LENGTH_OF_SERVICE_RECOMMENDED_COL, Integer.class));
        result.setLengthOfExperienceMin(ManipulateUtil.parseRow(row, LENGTH_OF_EXPERIENCE_MIN_COL, Integer.class));
        result.setLengthOfExperienceRecommended(ManipulateUtil.parseRow(row, LENGTH_OF_EXPERIENCE_RECOMMENDED_COL, Integer.class));
        result.setValidStatus(ManipulateUtil.parseRow(row, VALID_STATUS_COL, Integer.class));
        result.setValidStart(ManipulateUtil.parseRow(row, VALID_START_COL, LocalDate.class));
        result.setValidEnd(ManipulateUtil.parseRow(row, VALID_END_COL, LocalDate.class));
        result.setLevelId(ManipulateUtil.parseRow(row, LEVEL_ID_COL, Long.class));
        result.setStartDate(ManipulateUtil.parseRow(row, START_DATE_COL, LocalDate.class));
        result.setEndDate(ManipulateUtil.parseRow(row, END_DATE_COL, LocalDate.class));
        result.setPositionGroupId(ManipulateUtil.parseRow(row, POSITION_GROUP_ID_COL, Long.class));
        result.setTenagaKerja(ManipulateUtil.parseRow(row, TENAGA_KERJA_COL, Integer.class));
        result.setJenisJabatan(ManipulateUtil.parseRow(row, JENIS_JABATAN_COL, Integer.class));
        result.setAlias(ManipulateUtil.parseRow(row, ALIAS, String.class));
        result.setPositionTypeId(ManipulateUtil.parseRow(row, POSITION_TYPE_ID_COL, Long.class));


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
    public HrPosition update(HrPosition newData) {
        return Builder.updateBuilder(this, newData).build();
    }

    
}
