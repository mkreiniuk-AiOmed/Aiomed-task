package aiomed.aiomed.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;


import java.time.LocalDateTime;

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

    @Embedded
    private RecurrencePattern pattern;

    public TreatmentPlan(Long id, String patientId, TreatmentAction action, LocalDateTime startTime, LocalDateTime endTime,RecurrencePattern  pattern) {
        this.id = id;
        this.patientId = patientId;
        this.action = action;
        this.startTime = startTime;
        this.endTime = endTime;
        this.pattern =  pattern;
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
    public RecurrencePattern getPattern() {
        return pattern;
    }

    public void setPattern(RecurrencePattern pattern) {
        this.pattern = pattern;
    }




}
