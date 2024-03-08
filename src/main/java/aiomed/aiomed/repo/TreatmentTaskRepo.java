package aiomed.aiomed.repo;

import aiomed.aiomed.model.TreatmentTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentTaskRepo extends JpaRepository <TreatmentTask, Long> {

}
