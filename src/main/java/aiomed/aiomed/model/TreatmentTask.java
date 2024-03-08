package aiomed.aiomed.model;

import aiomed.aiomed.repo.TreatmentPlanRepo;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@EqualsAndHashCode(of = "id")
@ToString
public class TreatmentTask {
    @Id
    private Long id;
    private TreatmentAction action;
    private String patientId;
    private LocalDateTime startTime;
    private TaskStatus status;
    @ManyToOne(fetch = FetchType.EAGER)
    private TreatmentPlan plan;

    public TreatmentTask(Long id, TreatmentAction action, String patientId, TreatmentPlan plan, LocalDateTime startTime, TaskStatus status) {
        this.id = id; //Task id
        this.action = action;
        this.patientId = patientId;
        this.plan = plan;
        this.startTime = startTime;
        this.status = status;
    }

    public TreatmentPlan getPlan() {
        return plan;
    }

    public void setPlan(TreatmentPlan plan) {
        this.plan = plan;
    }

    public TreatmentTask() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TreatmentAction getAction() {
        return action;
    }

    public void setAction(TreatmentAction action) {
        this.action = action;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }



    public enum TaskStatus {
        ACTIVE,
        COMPLETED
    }
}
