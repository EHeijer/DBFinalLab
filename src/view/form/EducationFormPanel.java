package view.form;

import com.github.lgooddatepicker.components.DatePicker;
import view.event.EducationFormEvent;
import view.listener.EducationFormListener;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;

public class EducationFormPanel extends JPanel {
    private JLabel nameLabel, startDateLabel, endDateLabel;
    private JTextField nameField;
    private DatePicker startDatePicker, endDatePicker;
    private JButton submitButton, cancelButton;
    private EventListenerList eventListenerList;

    public EducationFormPanel() {
        nameLabel = new JLabel("Name:");
        startDateLabel = new JLabel("Start date:");
        endDateLabel = new JLabel("End date:");
        nameField = new JTextField(15);
        startDatePicker = new DatePicker();
        endDatePicker = new DatePicker();
        submitButton = new JButton("Submit");
        cancelButton = new JButton("Cancel");
        eventListenerList = new EventListenerList();
        setSize(new Dimension(400, 500));
        layoutComponents();
        submitButton.addActionListener(e -> fireEducationFormEvent(new EducationFormEvent(this,nameField.getText(),startDatePicker.getDate(),endDatePicker.getDate())));
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
        add(startDateLabel, gc);

        gc.gridx++;
        add(startDatePicker, gc);

        // Row 3
        gc.gridy++;

        gc.gridx = 0;
        add(endDateLabel, gc);

        gc.gridx++;
        add(endDatePicker, gc);

        // Row 4
        gc.gridy++;

        gc.gridx = 0;
        add(submitButton, gc);

        gc.gridx++;
        add(cancelButton, gc);
    }
}
