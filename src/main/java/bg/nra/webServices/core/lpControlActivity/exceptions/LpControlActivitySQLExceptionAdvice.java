package bg.nra.webServices.core.lpControlActivity.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * SQLException advice
 *
 * @author Nikolay Simitchiyski
 */
public class LpControlActivitySQLExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(LpControlActivitySQLException.class)
    String vwRptLpControlActivitySQLExceptionHandler(LpControlActivitySQLException ex) {
        return ex.getMessage();
    }
}
