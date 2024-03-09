package aiomed.aiomed.repo;

import aiomed.aiomed.model.TreatmentPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TreatmentPlanRepo extends JpaRepository<TreatmentPlan, Long> {

    @Query("SELECT tp FROM TreatmentPlan tp WHERE tp.startTime < CURRENT_DATE AND tp.endTime > CURRENT_DATE")
    List<TreatmentPlan> findAllActiveTreatmentPlan();
}
