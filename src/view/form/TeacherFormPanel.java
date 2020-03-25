package view.form;

import com.github.lgooddatepicker.components.DatePicker;
import view.event.TeacherFormEvent;
import view.listener.TeacherFormListener;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.EventListenerList;

public class TeacherFormPanel extends JPanel {
    private JLabel nameLabel, birthDateLabel;
    private JTextField nameField;
    private DatePicker birthDatePicker;
    private JButton submitButton, cancelButton;
    private EventListenerList eventListenerList;

    public TeacherFormPanel() {
        nameLabel = new JLabel("Name:");
        birthDateLabel = new JLabel("Birthdate:");
        nameField = new JTextField(15);
        birthDatePicker = new DatePicker();
        submitButton = new JButton("Submit");
        cancelButton = new JButton("Cancel");
        eventListenerList = new EventListenerList();
        setSize(new Dimension(400, 500));
        layoutComponents();
        submitButton.addActionListener(e -> fireTeacherFormEvent(new TeacherFormEvent(this, nameField.getText(), birthDatePicker.getDate())));
    }

    public void addTeacherFormListener(TeacherFormListener listener) {
        eventListenerList.add(TeacherFormListener.class, listener);
    }

    public void removeTeacherFormListener(TeacherFormListener listener) {
        eventListenerList.remove(TeacherFormListener.class, listener);
    }

    public void fireTeacherFormEvent(TeacherFormEvent event) {
        Object[] listeners = eventListenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == TeacherFormListener.class) {
                ((TeacherFormListener) listeners[i + 1]).teacherFormEventOccurred(event);
                removeTeacherFormListener((TeacherFormListener) listeners[i + 1]);
            }
        }
    }

    private void layoutComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        gc.weightx = 1;
        gc.weighty = 1;

        // Row 1
        gc.gridy = 0;

        gc.gridx = 0;
        add(nameLabel, gc);

        gc.gridx++;
        add(nameField, gc);

        // Row 2
        gc.gridy++;

        gc.gridx = 0;
        add(birthDateLabel, gc);

        gc.gridx++;
        add(birthDatePicker, gc);

        // Row 3
        gc.gridy++;

        gc.gridx = 0;
        add(submitButton, gc);

        gc.gridx++;
        add(cancelButton, gc);
    }
}

