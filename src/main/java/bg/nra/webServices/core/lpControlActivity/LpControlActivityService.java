package bg.nra.webServices.core.lpControlActivity;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * Business layer interface
 *
 * @author Nikolay Simitchiyski
 */
public interface LpControlActivityService {
    Optional<List<LpControlActivityDTO>> finAlldBy(@NotNull final LpControlActivityFilterBean filterBean);
}
