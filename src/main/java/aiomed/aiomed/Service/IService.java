package aiomed.aiomed.Service;

import aiomed.aiomed.model.TreatmentAction;
import aiomed.aiomed.model.TreatmentPlan;
import aiomed.aiomed.model.TreatmentTask;

import java.time.LocalDateTime;

public interface IService {

boolean  createTreatmentTask (Long id, TreatmentAction action, String patientId,TreatmentPlan plan, LocalDateTime startTime, TreatmentTask.TaskStatus status);
TreatmentPlan getPlan(Long id);
TreatmentTask getTask (Long id);

}
