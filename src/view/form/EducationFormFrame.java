package view.form;

import view.event.EducationFormEvent;
import view.listener.EducationFormListener;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;

public class EducationFormFrame extends JFrame {
    EducationFormPanel educationFormPanel;
    EventListenerList eventListenerList;

    public EducationFormFrame() {
        super("Education form");
        eventListenerList = new EventListenerList();
        educationFormPanel = new EducationFormPanel();
        educationFormPanel.addEducationFormListener(e -> {
            fireEducationFormEvent(e);
            this.dispose();
        });
        setLayout(new BorderLayout());
        setSize(new Dimension(400, 500));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(educationFormPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void addEducationFormListener(EducationFormListener listener) {
        eventListenerList.add(EducationFormListener.class, listener);
    }

    public void removeEducationFormListener(EducationFormListener listener) {
        eventListenerList.remove(EducationFormListener.class, listener);
    }

    public void fireEducationFormEvent(EducationFormEvent event) {
        Object[] listeners = eventListenerList.getListenerList();
        for (int i = listeners.length-2; i >= 0; i -= 2) {
            if (listeners[i] == EducationFormListener.class) {
                ((EducationFormListener)listeners[i+1]).educationFormEventOccurred(event);
                removeEducationFormListener((EducationFormListener)listeners[i+1]);
            }
        }
    }
}