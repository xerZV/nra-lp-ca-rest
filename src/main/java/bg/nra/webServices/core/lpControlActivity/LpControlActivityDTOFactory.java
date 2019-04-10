package bg.nra.webServices.core.lpControlActivity;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The {@code LpControlActivityDTOFactory} class contains two helper methods which convert {@link LpControlActivity} to {@link LpControlActivityDTO} or {@link List}<{@link LpControlActivity}> to {@link List}<{@link LpControlActivityDTO}> <br/>
 *
 * @author Nikolay Simitchiyski
 */
public final class LpControlActivityDTOFactory {

    /**
     * It converts {@link List}<{@link LpControlActivity}> to {@link List}<{@link LpControlActivityDTO}>
     *
     * @param lpControlActivities to be convert
     * @return {@code Optional.empty()} if the parameter {@code vwDeliveredDocs} is null or empty, else return {@code Optional<List<VwDeliveredDocsDTO>>}
     */
    public static Optional<List<LpControlActivityDTO>> convert(final Optional<List<LpControlActivity>> lpControlActivities) {
        if (lpControlActivities == null || !lpControlActivities.isPresent() || lpControlActivities.get().isEmpty())
            return Optional.empty();

        return Optional.of(lpControlActivities.get().stream().map(LpControlActivityDTOFactory::convert).collect(Collectors.toList()));
    }

    /**
     * It converts {@link LpControlActivity} to {@link LpControlActivityDTO}
     *
     * @param lpControlActivity to be convert
     * @return {@link LpControlActivityDTO}
     */
    public static LpControlActivityDTO convert(final LpControlActivity lpControlActivity) {
        LpControlActivityDTO lpControlActivityDTO = new LpControlActivityDTO();
        lpControlActivityDTO.setCaUin(lpControlActivity.getControlActivityUin());
        lpControlActivityDTO.setCaTypeName(lpControlActivity.getControlActivityTypeName());
        lpControlActivityDTO.setCaDescription(lpControlActivity.getControlActivityDescritiopn());
        lpControlActivityDTO.setCaStartDate(Date.from(lpControlActivity.getControlActivityStartDate().atZone(ZoneId.systemDefault()).toInstant()));
        lpControlActivityDTO.setDeadline(Date.from(lpControlActivity.getDeadlineDate().atZone(ZoneId.systemDefault()).toInstant()));
        lpControlActivityDTO.setCaScope(lpControlActivity.getControlActivityScope());
        lpControlActivityDTO.setCaTeam(lpControlActivity.getControlActivityTeam());
        lpControlActivityDTO.setLpPin(lpControlActivity.getControlActivityLiablePersonPin());
        lpControlActivityDTO.setLpName(lpControlActivity.getControlActivityLiablePersonName());

        return lpControlActivityDTO;
    }
}
