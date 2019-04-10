package bg.nra.webServices.web.rest.ca;

import bg.nra.webServices.core.enums.PinType;
import bg.nra.webServices.core.lpControlActivity.LpControlActivityDTO;
import bg.nra.webServices.core.lpControlActivity.LpControlActivityFilterBean;
import bg.nra.webServices.core.lpControlActivity.LpControlActivityService;
import bg.nra.webServices.core.lpControlActivity.exceptions.Error;
import bg.nra.webServices.core.lpControlActivity.exceptions.LpControlActivityNotFoundException;
import bg.nra.webServices.core.lpControlActivity.exceptions.LpControlActivitySQLException;
import bg.nra.webServices.core.lpControlActivity.exceptions.NotAcceptableError;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "Lp Control Activity", description = "API for Lp Control Activity")
@RestController
@RequestMapping(value = "/control-activity")
public class LpControlActivityController {
    @Autowired
    private LpControlActivityService lpControlActivityService;


    @ApiOperation(value = "View description for lp control activity", response = LpControlActivityDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of LpControlActivityDTOs", response = LpControlActivityDTO.class),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "The resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found", response = LpControlActivityNotFoundException.class),
            @ApiResponse(code = 406, message = "Not Acceptable - the response is custom json exception with messages for all rejected values and their expected values", response = NotAcceptableError.class),
            @ApiResponse(code = 500, message = "Internal server error", response = LpControlActivitySQLException.class)
    })
    @GetMapping
    public ResponseEntity<?> getControlActivityInfo(@Valid LpControlActivityFilterBean filterBean, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(getErrorResponse(bindingResult), HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>(this.lpControlActivityService.finAlldBy(filterBean).orElseThrow(() -> new LpControlActivityNotFoundException(filterBean.getUin())), HttpStatus.OK);
    }

    private NotAcceptableError getErrorResponse(BindingResult bindingResult) {
        NotAcceptableError notAcceptableError = new NotAcceptableError();
        notAcceptableError.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        List<Error> errorList = new ArrayList<>();
        bindingResult.getFieldErrors().stream().forEach(fieldError -> {
            Error error = new Error();
            error.setField(fieldError.getField());
            if (fieldError.getRejectedValue() != null)
                error.setRejectedValue(fieldError.getRejectedValue().toString());

            if (fieldError.getField().contains("Date"))
                error.setExpectedDateFormat("dd.MM.yyyy");

            if (fieldError.getField().contains("type"))
                error.setValidTypeFormats(Arrays.stream(PinType.values()).map(pinType -> pinType.getPinTypeCode()).collect(Collectors.joining(",")));

            error.setErrorMessage(fieldError.getDefaultMessage());

            errorList.add(error);
        });

        notAcceptableError.setErrors(errorList);

        return notAcceptableError;
    }

}
