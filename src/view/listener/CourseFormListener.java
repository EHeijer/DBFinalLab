package view.listener;

import view.event.CourseFormEvent;

import java.util.EventListener;

public interface CourseFormListener extends EventListener {
    void courseFormEventOccurred(CourseFormEvent event);
}
