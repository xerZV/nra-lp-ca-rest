package bg.nra.webServices.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Pin type enum
 *
 * @author Nikolay Simitchiyski
 */
public enum PinType {
    LNC("LNC"), //лична карта номер
    EGN("EGN"), //егн
    BLS("BLS"); //булстат

    private String pinTypeCode;

    PinType(String pinTypeCode) {
        this.pinTypeCode = pinTypeCode;
    }

    @JsonCreator
    public static PinType create(String pinTypeCode) {
        if (pinTypeCode == null) {
            throw new IllegalArgumentException();
        }
        for (PinType pinType : values()) {
            if (pinTypeCode.equals(pinType.getPinTypeCode())) {
                return pinType;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return this.pinTypeCode;
    }

    public String getPinTypeCode() {
        return this.pinTypeCode;
    }
}
