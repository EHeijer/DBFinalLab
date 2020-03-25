package view.form;

import view.event.CourseFormEvent;
import view.listener.CourseFormListener;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.event.EventListenerList;

public class CourseFormFrame extends JFrame{
    CourseFormPanel courseFormPanel;
    EventListenerList eventListenerList;

    public CourseFormFrame() {
        super("Course form");
        eventListenerList = new EventListenerList();
        courseFormPanel = new CourseFormPanel();
        courseFormPanel.addCourseFormListener(e -> {
            fireCourseFormEvent(e);
            this.dispose();
        });
        setLayout(new BorderLayout());
        setSize(new Dimension(400, 500));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(courseFormPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void addCourseFormListener(CourseFormListener listener) {
        eventListenerList.add(CourseFormListener.class,listener);
    }

    public void removeCourseFormListener(CourseFormListener listener) {
        eventListenerList.remove(CourseFormListener.class, listener);
    }

    public void fireCourseFormEvent(CourseFormEvent event) {
        Object[] listeners = eventListenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == CourseFormListener.class) {
                ((CourseFormListener)listeners[i+1]).courseFormEventOccurred(event);
                removeCourseFormListener((CourseFormListener)listeners[i+1]);
            }
        }
    }
}
