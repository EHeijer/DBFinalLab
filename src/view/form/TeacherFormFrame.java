package view.form;

import view.event.TeacherFormEvent;
import view.listener.TeacherFormListener;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.EventListenerList;

public class TeacherFormFrame extends JFrame {
    TeacherFormPanel teacherFormPanel;
    EventListenerList eventListenerList;

    public TeacherFormFrame() {
        super("Teacher form");
        eventListenerList = new EventListenerList();
        teacherFormPanel = new TeacherFormPanel();
        teacherFormPanel.addTeacherFormListener(e -> {
            fireTeacherFormEvent(e);
            this.dispose();
        });
        setLayout(new BorderLayout());
        setSize(new Dimension(400, 500));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(teacherFormPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void addTeacherFormListener(TeacherFormListener listener) {
        eventListenerList.add(TeacherFormListener.class, listener);
    }

    public void removeTeacherFormListener(TeacherFormListener listener) {
        eventListenerList.remove(TeacherFormListener.class,listener);
    }

    public void fireTeacherFormEvent(TeacherFormEvent event) {
        Object[] listeners = eventListenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == TeacherFormListener.class) {
                ((TeacherFormListener) listeners[i + 1]).teacherFormEventOccurred(event);
                removeTeacherFormListener((TeacherFormListener)listeners[i+1]);
            }
        }
    }
}
