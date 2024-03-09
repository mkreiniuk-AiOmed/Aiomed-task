package aiomed.aiomed.Service;

import aiomed.aiomed.model.RecurrencePattern;
import aiomed.aiomed.model.TreatmentAction;
import aiomed.aiomed.model.TreatmentPlan;
import aiomed.aiomed.model.TreatmentTask;
import aiomed.aiomed.repo.TreatmentPlanRepo;
import aiomed.aiomed.repo.TreatmentTaskRepo;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
    @Scheduled
    public boolean createTreatmentTask(TreatmentPlan plan) {
        TreatmentTask task = new TreatmentTask();
        task.setAction(plan.getAction());
        task.setPatientId(plan.getPatientId());
        task.setStartTime(plan.getStartTime());
        task.setStatus(TreatmentTask.TaskStatus.ACTIVE);
        task.setPlan(plan);
        return  taskRepo.save(task) != null;
    }

    @Override
    public TreatmentPlan getPlan(Long id) {
        return planRepo.findById(id).orElseThrow(() -> new RuntimeException("No such plan"));
    }

    @Override
    public TreatmentTask getTask(Long id) {
        return taskRepo.findById(id).orElseThrow(() -> new RuntimeException("No such task"));
    }

    @Override
    public TreatmentTask completeTask(Long id) {
        TreatmentTask res = getTask(id);
        res.setStatus(TreatmentTask.TaskStatus.COMPLETED);

        return  taskRepo.save(res);

    }

    @Override
    public boolean shouldCreateTreatmentTask(TreatmentPlan plan) {
        LocalDate today = LocalDate.now();
        DayOfWeek currentDay = today.getDayOfWeek();

        for (RecurrencePattern.RecurrenceRule rule : plan.getPattern().getRules()) {
            if (rule.getType() == RecurrencePattern.RecurrenceType.DAILY) {
                return true;
            } else if (rule.getType() == RecurrencePattern.RecurrenceType.WEEKLY && rule.getDayOfWeek() == currentDay) {
                LocalTime now = LocalTime.now();
                LocalTime taskTime = rule.getTime();
                if (now.isAfter(taskTime)) {
                    return true;
                }
            }
        }

        return false;

    }

    @Override
    public List<TreatmentPlan> getAllPlans() {
        List<TreatmentPlan> plans = planRepo.findAllActiveTreatmentPlan();
        if (plans.isEmpty()) {
            throw new RuntimeException("No active treatment plans found");
        }
        return plans;
    }


    @Override
    public void checker() {

        getAllPlans().stream()
                .filter(this::shouldCreateTreatmentTask)
                .filter(this::shouldCreateTreatmentTask)
                .forEach(task -> {
                    if (!createTreatmentTask(task)) {
                        throw new RuntimeException("Task hasn't been created");
                    }
                });
    }


}
