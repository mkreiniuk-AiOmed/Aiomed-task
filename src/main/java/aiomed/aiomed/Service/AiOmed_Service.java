package aiomed.aiomed.Service;

import aiomed.aiomed.model.TreatmentAction;
import aiomed.aiomed.model.TreatmentPlan;
import aiomed.aiomed.model.TreatmentTask;
import aiomed.aiomed.repo.TreatmentPlanRepo;
import aiomed.aiomed.repo.TreatmentTaskRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AiOmed_Service implements IService{


   private final TreatmentPlanRepo planRepo;

   private final TreatmentTaskRepo taskRepo;

    public AiOmed_Service(TreatmentPlanRepo planRepo, TreatmentTaskRepo taskRepo) {
        this.planRepo = planRepo;
        this.taskRepo = taskRepo;
    }


    @Override
    @Transactional
    public boolean createTreatmentTask(Long id, TreatmentAction action, String patientId,TreatmentPlan plan, LocalDateTime startTime, TreatmentTask.TaskStatus status) {
        TreatmentTask newTask = new TreatmentTask(id,action, patientId,plan, startTime, status);
        return  taskRepo.save(newTask) != null;
    }

    @Override
    public TreatmentPlan getPlan(Long id) {
        return planRepo.findById(id).orElseThrow(() -> new RuntimeException("No such plan"));
    }

    @Override
    public TreatmentTask getTask(Long id) {
        return taskRepo.findById(id).orElseThrow(() -> new RuntimeException("No such task"));
    }
}
