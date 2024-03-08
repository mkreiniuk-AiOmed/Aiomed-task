package aiomed.aiomed.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@EqualsAndHashCode(of="id")
@ToString
public class TreatmentPlan {
    @Id
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


}
