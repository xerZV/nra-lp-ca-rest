package bg.nra.webServices.core.lpControlActivity.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * SQLException
 *
 * @author Nikolay Simitchiyski
 */
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class LpControlActivitySQLException extends RuntimeException {
    public LpControlActivitySQLException(final @NotNull @NotEmpty String sqlExceptionMessage) {
        super(sqlExceptionMessage, null, false, false);
    }
}
