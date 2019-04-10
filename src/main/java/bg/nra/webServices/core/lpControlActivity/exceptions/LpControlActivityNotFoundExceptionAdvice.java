package bg.nra.webServices.core.lpControlActivity.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * NotFoundAdvice
 *
 * @author Nikolay Simitchiyski
 */
public class LpControlActivityNotFoundExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(LpControlActivityNotFoundException.class)
    String vwRptLpControlActivityNotFoundHandler(LpControlActivityNotFoundException ex) {
        return ex.getMessage();
    }
}
