package bg.nra.webServices.core.lpControlActivity;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

/**
 * Custom DAO interface
 *
 * @author Nikolay Simitchiyski
 */
public interface LpControlActivityCustomRepository {
    /**
     * Calls function from DB with dynamic parameters
     *
     * @param filterBean bean with all the parameters
     * @return optional of list of lpControlActivity by {@code filterBean}
     */
    Optional<List<LpControlActivity>> findAllBy(@NotEmpty @Valid final LpControlActivityFilterBean filterBean);
}
