package bg.nra.webServices.core.lpControlActivity.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * NotFoundException
 *
 * @author Nikolay Simitchiyski
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class LpControlActivityNotFoundException extends RuntimeException {
    public LpControlActivityNotFoundException(final @NotNull @NotEmpty String uin) {
        super("Could not find ControlActivity with UIN= " + uin, null, false, false);
    }
}
