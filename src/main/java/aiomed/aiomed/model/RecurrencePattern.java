package aiomed.aiomed.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Embeddable
public class RecurrencePattern {
    @ElementCollection
    private List<RecurrenceRule> rules;

    public RecurrencePattern() {
        this.rules = new ArrayList<>();
    }

    public void addRule(RecurrenceRule rule) {
        rules.add(rule);
    }

    public List<RecurrenceRule> getRules() {
        return rules;
    }

    @Embeddable
    @NoArgsConstructor
    public static class RecurrenceRule {
        private RecurrenceType type;
        private DayOfWeek dayOfWeek;
        private LocalTime time;


        public RecurrenceRule(RecurrenceType type, DayOfWeek dayOfWeek, LocalTime time) {
            this.type = type;
            this.dayOfWeek = dayOfWeek;
            this.time = time;
        }

        public RecurrenceType getType() {
            return type;
        }

        public DayOfWeek getDayOfWeek() {
            return dayOfWeek;
        }

        public LocalTime getTime() {
            return time;
        }
    }

    public enum RecurrenceType {
        DAILY,
        WEEKLY
    }
}
