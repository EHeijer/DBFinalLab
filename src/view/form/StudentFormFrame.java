package view.form;

import view.event.StudentFormEvent;
import view.listener.StudentFormListener;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.event.EventListenerList;

public class StudentFormFrame extends JFrame{
    StudentFormPanel studentFormPanel;
    EventListenerList eventListenerList;

    public StudentFormFrame() {
        super("Student form");
        eventListenerList = new EventListenerList();
        studentFormPanel = new StudentFormPanel();
        studentFormPanel.addStudentFormListener(e -> {
            fireStudentFormEvent(e);
            this.dispose();
        });
        setLayout(new BorderLayout());
        setSize(new Dimension(400, 500));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(studentFormPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void addStudentFormListener(StudentFormListener listener) {
        eventListenerList.add(StudentFormListener.class, listener);
    }

    public void removeStudentFormListener(StudentFormListener listener) {
        eventListenerList.remove(StudentFormListener.class,listener);
    }

    public void fireStudentFormEvent(StudentFormEvent event) {
        Object[] listeners = eventListenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == StudentFormListener.class) {
                ((StudentFormListener) listeners[i + 1]).studentFormEventOccurred(event);
                removeStudentFormListener((StudentFormListener) listeners[i+1]);
            }
        }
    }
}
