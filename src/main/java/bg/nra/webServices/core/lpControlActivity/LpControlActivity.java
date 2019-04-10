package bg.nra.webServices.core.lpControlActivity;


import bg.nra.webServices.core.enums.PinType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Entity
 *
 * @author Nikolay Simitchiyski
 */
@Entity
public class LpControlActivity {
    /**
     * ID на контролното производство
     */
    @Id
    @Column(name = "column_name")
    private Long controlActivityId;

    /**
     * УИН на контролното производство
     */
    @Column(name = "column_name", length = 30)
    private String controlActivityUin;
    /**
     * Код на типа контролна дейност
     */
    @Column(name = "column_name", nullable = false, length = 5)
    private String controlActivityTypeId;

    /**
     * Описание на контролното производство
     */
    @Column(name = "column_name", length = 600)
    private String controlActivityDescritiopn;

    /**
     * Име на типа контролна дейност
     */
    @Column(name = "column_name", length = 150)
    private String controlActivityTypeName;

    /**
     * Обхват на контролната дейност, ако има такава
     */
    @Column(name = "column_name", length = 500)
    private String controlActivityScope;

    /**
     * Екип, рапотещ по контролната дейност
     */
    @Column(name = "column_name", length = 500)
    private String controlActivityTeam;

    /**
     * Начална дата на контролната дейност
     */
    @Column(name = "column_name")
    private LocalDateTime controlActivityStartDate;

    /**
     * ID на задълженото лице
     */
    @Column(name = "column_name")
    private Long controlActivityLiablePersonId;

    /**
     * Идентификатор на задълженото лице
     */
    @Column(name = "column_name", length = 15)
    private String controlActivityLiablePersonPin;

    /**
     * Тип на идентификатора на задълженото лице
     */
    @Column(name = "column_name", length = 5)
    private String controlActivityLiablePersonPinTypeCode;

    /**
     * Име на задълженото лице
     */
    @Column(name = "column_name", length = 200)
    private String controlActivityLiablePersonName;

    /**
     * Дедлайн - крайна дата
     */
    @Column(name = "column_name")
    private LocalDateTime deadlineDate;

    public LpControlActivity() {
    }

    public LpControlActivity(final @NotNull @NotEmpty String uin, Optional<PinType> type, Optional<String> pin) {
        this.controlActivityUin = uin;
        if (type != null && type.isPresent())
            this.controlActivityLiablePersonPinTypeCode = type.get().getPinTypeCode();
        if (pin != null && pin.isPresent())
            this.controlActivityLiablePersonPin = pin.get();
    }

    public LpControlActivity(Long controlActivityId, String controlActivityUin, String controlActivityTypeId, String controlActivityDescritiopn, String controlActivityTypeName, String controlActivityScope, String controlActivityTeam, LocalDateTime controlActivityStartDate, Long controlActivityLiablePersonId, String controlActivityLiablePersonPin, String controlActivityLiablePersonPinTypeCode, String controlActivityLiablePersonName, LocalDateTime deadlineDate) {
        this.controlActivityId = controlActivityId;
        this.controlActivityUin = controlActivityUin;
        this.controlActivityTypeId = controlActivityTypeId;
        this.controlActivityDescritiopn = controlActivityDescritiopn;
        this.controlActivityTypeName = controlActivityTypeName;
        this.controlActivityScope = controlActivityScope;
        this.controlActivityTeam = controlActivityTeam;
        this.controlActivityStartDate = controlActivityStartDate;
        this.controlActivityLiablePersonId = controlActivityLiablePersonId;
        this.controlActivityLiablePersonPin = controlActivityLiablePersonPin;
        this.controlActivityLiablePersonPinTypeCode = controlActivityLiablePersonPinTypeCode;
        this.controlActivityLiablePersonName = controlActivityLiablePersonName;
        this.deadlineDate = deadlineDate;
    }

    public static LpControlActivity of(@NotNull @Valid LpControlActivityFilterBean filterBean) {
        return new LpControlActivity(filterBean.getUin(), filterBean.getType(), filterBean.getPin());
    }

    public Long getControlActivityId() {
        return this.controlActivityId;
    }

    public void setControlActivityId(Long controlActivityId) {
        this.controlActivityId = controlActivityId;
    }

    public String getControlActivityUin() {
        return this.controlActivityUin;
    }

    public void setControlActivityUin(String controlActivityUin) {
        this.controlActivityUin = controlActivityUin;
    }

    public String getControlActivityTypeId() {
        return this.controlActivityTypeId;
    }

    public void setControlActivityTypeId(String controlActivityTypeId) {
        this.controlActivityTypeId = controlActivityTypeId;
    }

    public String getControlActivityDescritiopn() {
        return this.controlActivityDescritiopn;
    }

    public void setControlActivityDescritiopn(String controlActivityDescritiopn) {
        this.controlActivityDescritiopn = controlActivityDescritiopn;
    }

    public String getControlActivityTypeName() {
        return this.controlActivityTypeName;
    }

    public void setControlActivityTypeName(String controlActivityTypeName) {
        this.controlActivityTypeName = controlActivityTypeName;
    }

    public String getControlActivityScope() {
        return this.controlActivityScope;
    }

    public void setControlActivityScope(String controlActivityScope) {
        this.controlActivityScope = controlActivityScope;
    }

    public String getControlActivityTeam() {
        return this.controlActivityTeam;
    }

    public void setControlActivityTeam(String controlActivityTeam) {
        this.controlActivityTeam = controlActivityTeam;
    }

    public LocalDateTime getControlActivityStartDate() {
        return this.controlActivityStartDate;
    }

    public void setControlActivityStartDate(LocalDateTime controlActivityStartDate) {
        this.controlActivityStartDate = controlActivityStartDate;
    }

    public Long getControlActivityLiablePersonId() {
        return this.controlActivityLiablePersonId;
    }

    public void setControlActivityLiablePersonId(Long controlActivityLiablePersonId) {
        this.controlActivityLiablePersonId = controlActivityLiablePersonId;
    }

    public String getControlActivityLiablePersonPin() {
        return this.controlActivityLiablePersonPin;
    }

    public void setControlActivityLiablePersonPin(String controlActivityLiablePersonPin) {
        this.controlActivityLiablePersonPin = controlActivityLiablePersonPin;
    }

    public String getControlActivityLiablePersonPinTypeCode() {
        return this.controlActivityLiablePersonPinTypeCode;
    }

    public void setControlActivityLiablePersonPinTypeCode(String controlActivityLiablePersonPinTypeCode) {
        this.controlActivityLiablePersonPinTypeCode = controlActivityLiablePersonPinTypeCode;
    }

    public String getControlActivityLiablePersonName() {
        return this.controlActivityLiablePersonName;
    }

    public void setControlActivityLiablePersonName(String controlActivityLiablePersonName) {
        this.controlActivityLiablePersonName = controlActivityLiablePersonName;
    }

    public LocalDateTime getDeadlineDate() {
        return this.deadlineDate;
    }

    public void setDeadlineDate(LocalDateTime deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    @Override
    public String toString() {
        return "{" +
                "controlActivityId=" + controlActivityId +
                ", controlActivityUin='" + controlActivityUin + '\'' +
                ", controlActivityTypeId='" + controlActivityTypeId + '\'' +
                ", controlActivityTypeName='" + controlActivityTypeName + '\'' +
                ", controlActivityScope='" + controlActivityScope + '\'' +
                ", controlActivityTeam='" + controlActivityTeam + '\'' +
                ", controlActivityStartDate=" + controlActivityStartDate +
                ", controlActivityLiablePersonId=" + controlActivityLiablePersonId +
                ", controlActivityLiablePersonPin='" + controlActivityLiablePersonPin + '\'' +
                ", controlActivityLiablePersonName='" + controlActivityLiablePersonName + '\'' +
                ", deadlineDate=" + deadlineDate +
                '}';
    }
}
