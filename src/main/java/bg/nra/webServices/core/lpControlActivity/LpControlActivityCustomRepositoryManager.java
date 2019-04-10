package bg.nra.webServices.core.lpControlActivity;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * Custom DAO to call a function from DB
 *
 * @author Nikolay Simitchiyski
 */
@Repository
public class LpControlActivityCustomRepositoryManager implements LpControlActivityCustomRepository {
    private final static String QUERY = "SELECT * FROM TABLE(PACKAGE_NAME.FUNCTION_NAME(P_CA_UIN => :UIN";
    private final static String SPECIAL_SIGN_FOR_PARAMETERS = " => ";
    private final static String UIN_PARAM = ":UIN";
    private final static String UIN = "UIN";
    private final static String PIN_PARAM = ":PIN";
    private final static String PIN = "PIN";
    private final static String P_PIN_PARAM = "P_LP_PIN";
    private final static String PIN_TYPE_PARAM = ":PIN_TYPE";
    private final static String PIN_TYPE = "PIN_TYPE";
    private final static String P_PIN_TYPE_PARAM = "P_LP_PIN_TYPE_CODE";

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<List<LpControlActivity>> findAllBy(@NotEmpty @Valid final LpControlActivityFilterBean filterBean) {
        Query query = entityManager.createNativeQuery(generateSQLForFindAllByFilterBean(filterBean), LpControlActivity.class);

        if (filterBean.getPin() != null && filterBean.getPin().isPresent())
            query.setParameter(PIN, filterBean.getPin().get());

        if (filterBean.getType() != null && filterBean.getType().isPresent())
            query.setParameter(PIN_TYPE, filterBean.getType().get().getPinTypeCode());

        return Optional.of((List<LpControlActivity>) query.getResultList());
    }

    private String generateSQLForFindAllByFilterBean(@NotNull final LpControlActivityFilterBean filterBean) {
        String query = QUERY.replaceAll(UIN_PARAM, "'" + filterBean.getUin() + "'");
        StringBuilder stringBuilder = new StringBuilder(query);
        if (filterBean.getPin() != null && filterBean.getPin().isPresent())
            stringBuilder.append(", " + P_PIN_PARAM + SPECIAL_SIGN_FOR_PARAMETERS + PIN_PARAM);

        if (filterBean.getType() != null && filterBean.getType().isPresent())
            stringBuilder.append(", " + P_PIN_TYPE_PARAM + SPECIAL_SIGN_FOR_PARAMETERS + PIN_TYPE_PARAM);

        stringBuilder.append("))");

        return stringBuilder.toString();
    }
}
