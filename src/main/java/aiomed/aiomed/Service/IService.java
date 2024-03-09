package aiomed.aiomed.Service;


import aiomed.aiomed.model.TreatmentPlan;
import aiomed.aiomed.model.TreatmentTask;


import java.util.List;

public interface IService {

boolean  createTreatmentTask (TreatmentPlan plan);
TreatmentPlan getPlan(Long id);
TreatmentTask getTask (Long id);

TreatmentTask completeTask (Long id);

boolean shouldCreateTreatmentTask(TreatmentPlan plan);
List<TreatmentPlan> getAllPlans();
void checker();


}
