package view;

import model.Course;
import model.Education;
import model.Student;
import model.Teacher;
import view.event.*;
import view.form.*;
import view.listener.*;
import view.table.MyTablePanel;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {
    private JMenuBar jMenuBar;
    private JMenu registerMenu, listMenu;
    private JMenuItem registerEducationItem, registerCourseItem, registerTeacherItem, registerStudentItem, listItem1, listItem2, listItem3, listItem4;
    private EducationFormFrame educationFormFrame;
    private CourseFormFrame courseFormFrame;
    private TeacherFormFrame teacherFormFrame;
    private StudentFormFrame studentFormFrame;
    private MyTablePanel myTablePanel;
    private EventListenerList eventListenerList;

    public MainFrame(String title) {
        super(title);
        eventListenerList = new EventListenerList();
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(1400, 1000));
        myTablePanel = new MyTablePanel();
        add(myTablePanel, BorderLayout.CENTER);
        setVisible(true);
        setupJMenuBar();
        setupListeners();
    }

    private void setupJMenuBar() {
        jMenuBar = new JMenuBar();
        registerMenu = new JMenu("Register");
        listMenu = new JMenu("List");
        registerEducationItem = new JMenuItem("Education");
        registerCourseItem = new JMenuItem("Course");
        registerTeacherItem = new JMenuItem("Teacher");
        registerStudentItem = new JMenuItem("Student");
        listItem1 = new JMenuItem("Educations");
        listItem2 = new JMenuItem("Courses");
        listItem3 = new JMenuItem("Teachers");
        listItem4 = new JMenuItem("Students");
        registerMenu.add(registerEducationItem);
        registerMenu.add(registerCourseItem);
        registerMenu.add(registerTeacherItem);
        registerMenu.add(registerStudentItem);
        listMenu.add(listItem1);
        listMenu.add(listItem2);
        listMenu.add(listItem3);
        listMenu.add(listItem4);
        jMenuBar.add(registerMenu);
        jMenuBar.add(listMenu);
        setJMenuBar(jMenuBar);
    }

    private void setupListeners() {
        registerEducationItem.addActionListener(e -> {
            educationFormFrame = new EducationFormFrame();
            educationFormFrame.addEducationFormListener(this::fireEducationFormEvent);
            educationFormFrame = null;
        });
        registerCourseItem.addActionListener(e -> {
            courseFormFrame = new CourseFormFrame();
            courseFormFrame.addCourseFormListener(this::fireCourseFormEvent);
            courseFormFrame = null;
        });
        registerTeacherItem.addActionListener(e -> {
            teacherFormFrame = new TeacherFormFrame();
            teacherFormFrame.addTeacherFormListener(this::fireTeacherFormEvent);
            teacherFormFrame = null;
        });
        registerStudentItem.addActionListener(e -> {
            studentFormFrame = new StudentFormFrame();
            studentFormFrame.addStudentFormListener(this::fireStudentFormEvent);
            studentFormFrame = null;
        });
        myTablePanel.addUpdateEntityListener(this::fireUpdateEntityEvent);
        myTablePanel.addAssociateEntityListener(this::fireAssociateEntityEvent);
        myTablePanel.addShowAssociatedEntityListener(this::fireShowAssociatedEntityEvent);
        myTablePanel.addDeleteEntityListener(this::fireDeleteEntityEvent);
        listItem1.addActionListener(e -> {
            fireListEntityEvent(new ListEntityEvent(this,0));
            myTablePanel.setTableModel(0);
        });
        listItem2.addActionListener(e -> {
            fireListEntityEvent(new ListEntityEvent(this,1));
            myTablePanel.setTableModel(1);
        });
        listItem3.addActionListener(e -> {
            fireListEntityEvent(new ListEntityEvent(this,2));
            myTablePanel.setTableModel(2);
        });
        listItem4.addActionListener(e -> {
            fireListEntityEvent(new ListEntityEvent(this,3));
            myTablePanel.setTableModel(3);
        });
    }

    public void addEducationFormListener(EducationFormListener listener) {
        eventListenerList.add(EducationFormListener.class, listener);
    }

    public void addCourseFormListener(CourseFormListener listener) {
        eventListenerList.add(CourseFormListener.class, listener);
    }

    public void addTeacherFormListener(TeacherFormListener listener) {
        eventListenerList.add(TeacherFormListener.class, listener);
    }

    public void addStudentFormListener(StudentFormListener listener) {
        eventListenerList.add(StudentFormListener.class, listener);
    }

    public void addUpdateEntityListener(UpdateEntityListener listener) {
        eventListenerList.add(UpdateEntityListener.class, listener);
    }

    public void addAssociateEntityListener(AssociateEntityListener listener) {
        eventListenerList.add(AssociateEntityListener.class, listener);
    }

    public void addShowAssociatedEntityListener(ShowAssociatedEntityListener listener) {
        eventListenerList.add(ShowAssociatedEntityListener.class, listener);
    }

    public void addDeleteEntityListener(DeleteEntityListener listener) {
        eventListenerList.add(DeleteEntityListener.class, listener);
    }

    public void addListEntityListener(ListEntityListener listener) {
        eventListenerList.add(ListEntityListener.class, listener);
    }

    public void fireEducationFormEvent(EducationFormEvent event) {
        Object[] listeners = eventListenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == EducationFormListener.class) {
                ((EducationFormListener) listeners[i + 1]).educationFormEventOccurred(event);
            }
        }
    }

    private void fireCourseFormEvent(CourseFormEvent event) {
        Object[] listeners = eventListenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == CourseFormListener.class) {
                ((CourseFormListener) listeners[i + 1]).courseFormEventOccurred(event);
            }
        }
    }

    private void fireTeacherFormEvent(TeacherFormEvent event) {
        Object[] listeners = eventListenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == TeacherFormListener.class) {
                ((TeacherFormListener) listeners[i + 1]).teacherFormEventOccurred(event);
            }
        }
    }

    private void fireStudentFormEvent(StudentFormEvent event) {
        Object[] listeners = eventListenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == StudentFormListener.class) {
                ((StudentFormListener) listeners[i + 1]).studentFormEventOccurred(event);
            }
        }
    }

    public void fireUpdateEntityEvent(UpdateEntityEvent event) {
        Object[] listeners = eventListenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == UpdateEntityListener.class) {
                ((UpdateEntityListener) listeners[i + 1]).updateEntityEventOccurred(event);
            }
        }
    }

    public void fireAssociateEntityEvent(AssociateEntityEvent event) {
        Object[] listeners = eventListenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == AssociateEntityListener.class) {
                ((AssociateEntityListener) listeners[i + 1]).associateEntityEventOccurred(event);
            }
        }
    }

    public void fireShowAssociatedEntityEvent(ShowAssociatedEntityEvent event) {
        Object[] listeners = eventListenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == ShowAssociatedEntityListener.class) {
                ((ShowAssociatedEntityListener) listeners[i + 1]).showAssociatedEntityEventOccurred(event);
            }
        }
    }

    public void fireDeleteEntityEvent(DeleteEntityEvent event) {
        Object[] listeners = eventListenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == DeleteEntityListener.class) {
                ((DeleteEntityListener) listeners[i + 1]).deleteEntityEventOccurred(event);
            }
        }
    }

    public void fireListEntityEvent(ListEntityEvent event) {
        Object[] listeners = eventListenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == ListEntityListener.class) {
                ((ListEntityListener)listeners[i+1]).listEntityEventOccurred(event);
            }
        }
    }

    public void setEducationData(List<Education> educations) {
        myTablePanel.setEducationData(educations);
    }

    public void setCourseData(List<Course> courses) {
        myTablePanel.setCourseData(courses);
    }

    public void setTeacherData(List<Teacher> teachers) {
        myTablePanel.setTeacherData(teachers);
    }

    public void setStudentData(List<Student> students) {
        myTablePanel.setStudentData(students);
    }
}