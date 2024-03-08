package aiomed.aiomed.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class TreatmentTask {
    private Long id;
    private TreatmentAction action;
    private String patientId;
    private LocalDateTime startTime;
    private TaskStatus status;

    public TreatmentTask(Long id, TreatmentAction action, String patientId, LocalDateTime startTime, TaskStatus status) {
        this.id = id;
        this.action = action;
        this.patientId = patientId;
        this.startTime = startTime;
        this.status = status;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreatmentTask that = (TreatmentTask) o;
        return Objects.equals(id, that.id) && action == that.action && Objects.equals(startTime, that.startTime) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, action, startTime, status);
    }

    public enum TaskStatus {
        ACTIVE,
        COMPLETED
    }
}
