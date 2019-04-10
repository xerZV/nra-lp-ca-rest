package bg.nra.webServices.core.lpControlActivity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * DATA TRANSFER OBJECT
 *
 * @author Nikolay Simitchiyski
 */
@ApiModel
public class LpControlActivityDTO {
    @ApiModelProperty(notes = "УИН на производството")
    private String caUin;

    @ApiModelProperty(notes = "Тип на производството")
    private String caTypeName;

    @ApiModelProperty(notes = "УИН")
    private String caDescription;

    @ApiModelProperty(notes = "Дата възлагане")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date caStartDate;

    @ApiModelProperty(notes = "Срок изпълнение")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date deadline;

    @ApiModelProperty(notes = "Обхват (в случай на ревизия/ППВ) ИЛИ Обект (в случай на Проверка в Обект)")
    private String caScope;

    @ApiModelProperty(notes = "Екип на контролно производство")
    private String caTeam;

    @ApiModelProperty(notes = "Идентификатор на задълженото лице")
    private String lpPin;

    @ApiModelProperty(notes = "Име на задълженото лице")
    private String lpName;


    public LpControlActivityDTO() {
    }

    public LpControlActivityDTO(String caUin, String caTypeName, String caDescription, Date caStartDate, Date deadline, String caScope, String caTeam, String lpPin, String lpName) {
        this.caUin = caUin;
        this.caTypeName = caTypeName;
        this.caDescription = caDescription;
        this.caStartDate = caStartDate;
        this.deadline = deadline;
        this.caScope = caScope;
        this.caTeam = caTeam;
        this.lpPin = lpPin;
        this.lpName = lpName;
    }

    public String getCaUin() {
        return this.caUin;
    }

    public void setCaUin(String caUin) {
        this.caUin = caUin;
    }

    public String getCaTypeName() {
        return this.caTypeName;
    }

    public void setCaTypeName(String caTypeName) {
        this.caTypeName = caTypeName;
    }

    public String getCaDescription() {
        return this.caDescription;
    }

    public void setCaDescription(String caDescription) {
        this.caDescription = caDescription;
    }

    public Date getCaStartDate() {
        return this.caStartDate;
    }

    public void setCaStartDate(Date caStartDate) {
        this.caStartDate = caStartDate;
    }

    public Date getDeadline() {
        return this.deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getCaScope() {
        return this.caScope;
    }

    public void setCaScope(String caScope) {
        this.caScope = caScope;
    }

    public String getCaTeam() {
        return this.caTeam;
    }

    public void setCaTeam(String caTeam) {
        this.caTeam = caTeam;
    }

    public String getLpPin() {
        return this.lpPin;
    }

    public void setLpPin(String lpPin) {
        this.lpPin = lpPin;
    }

    public String getLpName() {
        return this.lpName;
    }

    public void setLpName(String lpName) {
        this.lpName = lpName;
    }


    @Override
    public String toString() {
        return "{" +
                "caUin='" + caUin + '\'' +
                ", caTypeName='" + caTypeName + '\'' +
                ", caDescription='" + caDescription + '\'' +
                ", caStartDate=" + caStartDate +
                ", deadline=" + deadline +
                ", caScope='" + caScope + '\'' +
                ", caTeam='" + caTeam + '\'' +
                ", lpPin='" + lpPin + '\'' +
                ", lpName='" + lpName + '\'' +
                '}';
    }
}
