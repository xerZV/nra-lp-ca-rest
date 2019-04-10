package bg.nra.webServices.core.lpControlActivity;

import bg.nra.webServices.core.lpControlActivity.exceptions.LpControlActivityNotFoundException;
import bg.nra.webServices.core.lpControlActivity.exceptions.LpControlActivitySQLException;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * Business layer implementation
 *
 * @author Nikolay Simitchiyski
 */
@Service
public class LpControlActivityServiceManager implements LpControlActivityService {

    @Autowired
    private LpControlActivityRepository lpControlActivityRepository;

    @Autowired
    private LpControlActivityCustomRepository lpControlActivityCustomRepository;

    @Override
    public Optional<List<LpControlActivityDTO>> finAlldBy(final @NotNull @Valid LpControlActivityFilterBean filterBean) {
//        return LpControlActivityDTOFactory.convert(Optional.of(this.vwRptLpControlActivityRepository.findAll(Example.of(LpControlActivity.of(filterBean))))); //used when data comes from view/table

        Optional<List<LpControlActivity>> vwRptLpControlActivities = Optional.empty();
        try {
            vwRptLpControlActivities = lpControlActivityCustomRepository.findAllBy(filterBean);
        } catch (Exception e) {
            if (e.getCause() != null && e.getCause() instanceof GenericJDBCException)
                throw new LpControlActivitySQLException(e.getCause().getCause().getMessage().split("\nORA")[0]); //catch custom exception from the DB

            throw new LpControlActivityNotFoundException(filterBean.getUin());
        }

        return LpControlActivityDTOFactory.convert(vwRptLpControlActivities);
    }

}
