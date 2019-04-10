package bg.nra.webServices.core.lpControlActivity.exceptions;

import java.util.List;

/**
 * NotAcceptableError bean/dto
 *
 * @author Nikolay Simitchiyski
 */
public class NotAcceptableError {
    private int status;
    private List<Error> errors;

    public NotAcceptableError() {
    }

    public NotAcceptableError(int status, List<Error> errors) {
        this.status = status;
        this.errors = errors;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Error> getErrors() {
        return this.errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}
