package view.listener;

import view.event.TeacherFormEvent;

import java.util.EventListener;

public interface TeacherFormListener extends EventListener {
    void teacherFormEventOccurred(TeacherFormEvent event);
}