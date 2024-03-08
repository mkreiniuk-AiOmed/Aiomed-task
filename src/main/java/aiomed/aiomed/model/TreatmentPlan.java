package aiomed.aiomed.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class TreatmentPlan {
    private Long id;
    private String patientId;
    private TreatmentAction action;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String recurrencePattern;

    public TreatmentPlan(Long id, String patientId, TreatmentAction action, LocalDateTime startTime, LocalDateTime endTime, String recurrencePattern) {
        this.id = id;
        this.patientId = patientId;
        this.action = action;
        this.startTime = startTime;
        this.endTime = endTime;
        this.recurrencePattern = recurrencePattern;
    }

    public TreatmentPlan() {
    }

    public Long getId() {
        return id;
    }

    public String getPatientId() {
        return patientId;
    }

    public TreatmentAction getAction() {
        return action;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getRecurrencePattern() {
        return recurrencePattern;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreatmentPlan that = (TreatmentPlan) o;
        return Objects.equals(id, that.id) && action == that.action && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(recurrencePattern, that.recurrencePattern);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, action, startTime, endTime, recurrencePattern);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setAction(TreatmentAction action) {
        this.action = action;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setRecurrencePattern(String recurrencePattern) {
        this.recurrencePattern = recurrencePattern;
    }

    @Override
    public String toString() {
        return "TreatmentPlan{" +
                "id=" + id +
                ", patientId='" + patientId + '\'' +
                ", action=" + action +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", recurrencePattern='" + recurrencePattern + '\'' +
                '}';
    }
}
