package bg.nra.webServices.core.lpControlActivity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JpaRepo
 *
 * @author Nikolay Simitchiyski
 */
@Repository
public interface LpControlActivityRepository extends JpaRepository<LpControlActivity, Long> {
}
