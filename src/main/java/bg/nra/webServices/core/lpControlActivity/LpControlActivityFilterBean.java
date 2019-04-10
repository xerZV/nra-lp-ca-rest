package bg.nra.webServices.core.lpControlActivity;

import bg.nra.webServices.core.enums.PinType;
import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * The {@code LpControlActivityFilterBean} class contains filter params from the user <br/>
 * It should be used as request param
 *
 * @author Nikolay Simitchiyski
 */
public class LpControlActivityFilterBean {

    @ApiParam(value = "Search param uin - required", required = true, name = "uin", example = "exampleUin")
    @NotNull(message = "УИН е задължителен!")
    @NotEmpty(message = "УИН не може да бъде празен")
    private String uin;

    @ApiParam(value = "Search param type - optional", example = "BLS", name = "type")
    private Optional<PinType> type;


    @ApiParam(value = "Search param pin - optional", name = "pin", type = "String", example = "examplePin")
    private Optional<String> pin;

    public LpControlActivityFilterBean() {
    }

    public LpControlActivityFilterBean(@NotNull(message = "УИН е задължителен!") @NotEmpty(message = "УИН не може да бъде празен") String uin) {
        this.uin = uin;
    }

    public LpControlActivityFilterBean(final @NotNull @NotEmpty String uin, Optional<PinType> type, Optional<String> pin) {
        this.uin = uin;
        this.type = type;
        this.pin = pin;
    }

    public String getUin() {
        return this.uin;
    }

    public void setUin(String uin) {
        this.uin = uin;
    }

    public Optional<PinType> getType() {
        return this.type;
    }

    public void setType(Optional<PinType> type) {
        this.type = type;
    }

    public Optional<String> getPin() {
        return this.pin;
    }

    public void setPin(Optional<String> pin) {
        this.pin = pin;
    }


    @Override
    public String toString() {
        return "request with {" +
                "uin='" + uin + '\'' +
                ", type=" + type +
                ", pin=" + pin +
                '}';
    }
}
