package bg.nra.webServices.core.lpControlActivity.exceptions;

/**
 * Error bean/dto
 *
 * @author Nikolay Simitchiyski
 */
public class Error {
    private String field;
    private String rejectedValue;
    private String expectedDateFormat;
    private String validTypeFormats;
    private String errorMessage;

    public Error() {
    }

    public Error(String field, String rejectedValue, String expectedDateFormat, String validTypeFormats, String errorMessage) {
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.expectedDateFormat = expectedDateFormat;
        this.validTypeFormats = validTypeFormats;
        this.errorMessage = errorMessage;
    }

    public String getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getRejectedValue() {
        return this.rejectedValue;
    }

    public void setRejectedValue(String rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

    public String getExpectedDateFormat() {
        return this.expectedDateFormat;
    }

    public void setExpectedDateFormat(String expectedDateFormat) {
        this.expectedDateFormat = expectedDateFormat;
    }

    public String getValidTypeFormats() {
        return this.validTypeFormats;
    }

    public void setValidTypeFormats(String validTypeFormats) {
        this.validTypeFormats = validTypeFormats;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
