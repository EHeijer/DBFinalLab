package view.event;

import java.time.LocalDate;
import java.util.EventObject;

public class EducationFormEvent extends EventObject {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    public EducationFormEvent(Object source, String name, LocalDate startDate, LocalDate endDate) {
        super(source);
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
