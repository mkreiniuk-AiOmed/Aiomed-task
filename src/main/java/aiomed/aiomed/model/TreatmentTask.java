package aiomed.aiomed.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;


@Entity
@EqualsAndHashCode(of = "id")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TreatmentAction action;
    private String patientId;
    private LocalDateTime startTime;
    private TaskStatus status;
    @ManyToOne(fetch = FetchType.EAGER)
    private TreatmentPlan plan;



    public TreatmentPlan getPlan() {
        return plan;
    }

    public void setPlan(TreatmentPlan plan) {
        this.plan = plan;
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
