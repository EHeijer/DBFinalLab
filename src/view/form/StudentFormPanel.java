package view.form;

import com.github.lgooddatepicker.components.DatePicker;
import view.event.StudentFormEvent;
import view.listener.StudentFormListener;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;

public class StudentFormPanel extends JPanel {

    private JLabel nameLabel, birthDateLabel;
    private JTextField nameField;
    private DatePicker birthDatePicker;
    private JButton submitButton, cancelButton;
    private EventListenerList eventListenerList;

    public StudentFormPanel() {
        nameLabel = new JLabel("Name:");
        birthDateLabel = new JLabel("Birth date:");
        nameField = new JTextField(15);
        birthDatePicker = new DatePicker();
        submitButton = new JButton("Submit");
        cancelButton = new JButton("Cancel");
        eventListenerList = new EventListenerList();
        setSize(new Dimension(400, 500));
        layoutComponents();
        submitButton.addActionListener(e -> fireStudentFormEvent(new StudentFormEvent(this, nameField.getText(), birthDatePicker.getDate())));
    }

    public void addStudentFormListener(StudentFormListener listener) {
        eventListenerList.add(StudentFormListener.class, listener);
    }

    public void removeStudentFormListener(StudentFormListener listener) {
        eventListenerList.remove(StudentFormListener.class, listener);
    }

    public void fireStudentFormEvent(StudentFormEvent event) {
        Object[] listeners = eventListenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == StudentFormListener.class) {
                ((StudentFormListener) listeners[i + 1]).studentFormEventOccurred(event);
                removeStudentFormListener((StudentFormListener) listeners[i + 1]);
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
