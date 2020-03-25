package controller;

import model.MyEntityManager;
import view.MainFrame;

public class Controller {
    MyEntityManager myEntityManager;
    MainFrame mainFrame;

    public Controller(MyEntityManager myEntityManager, MainFrame mainFrame) {
        this.myEntityManager = myEntityManager;
        this.mainFrame = mainFrame;
        initiateData();
        initiateController();
    }

    public void initiateData() {
        mainFrame.setEducationData(myEntityManager.getEducations());
        mainFrame.setCourseData(myEntityManager.getCourses());
        mainFrame.setTeacherData(myEntityManager.getTeachers());
        mainFrame.setStudentData(myEntityManager.getStudents());
    }

    public void initiateController() {
        mainFrame.addEducationFormListener(e -> {
            myEntityManager.createEducation(e.getName(), e.getStartDate(), e.getEndDate());
            mainFrame.setEducationData(myEntityManager.getEducations());
        });
        mainFrame.addCourseFormListener(e -> {
            myEntityManager.createCourse(e.getName(), e.getStartDate(), e.getEndDate());
            mainFrame.setCourseData(myEntityManager.getCourses());
        });
        mainFrame.addTeacherFormListener(e -> {
            myEntityManager.createTeacher(e.getName(), e.getBirthDate());
            mainFrame.setTeacherData(myEntityManager.getTeachers());
        });
        mainFrame.addStudentFormListener(e -> {
            myEntityManager.createStudent(e.getName(), e.getBirthDate());
            mainFrame.setStudentData(myEntityManager.getStudents());
        });
        mainFrame.addUpdateEntityListener(e -> {
            switch (e.getEntityType()) {
                case "EducationTableModel":
                    myEntityManager.updateEducationName(e.getId(), e.getNewName());
                    mainFrame.setEducationData(myEntityManager.getEducations());
                    break;
                case "CourseTableModel":
                    myEntityManager.updateCourseName(e.getId(), e.getNewName());
                    mainFrame.setCourseData(myEntityManager.getCourses());
                    break;
                case "TeacherTableModel":
                    myEntityManager.updateTeacherName(e.getId(), e.getNewName());
                    mainFrame.setTeacherData(myEntityManager.getTeachers());
                    break;
                case "StudentTableModel":
                    myEntityManager.updateStudentName(e.getId(), e.getNewName());
                    mainFrame.setStudentData(myEntityManager.getStudents());
                    break;
            }
        });

        mainFrame.addAssociateEntityListener(e -> {
            switch (e.getEntityType()) {
                case "EducationTableModel":
                    if (e.isCourse()) {
                        myEntityManager.addCourseToEducation(e.getCurrentId(), e.getOtherId());
                        mainFrame.setEducationData(myEntityManager.getEducations());
                    } else {
                        myEntityManager.addStudentToEducation(e.getCurrentId(), e.getOtherId());
                        mainFrame.setEducationData(myEntityManager.getEducations());
                    }
                    break;
                case "CourseTableModel":
                    myEntityManager.addTeacherToCourse(e.getCurrentId(), e.getOtherId());
                    mainFrame.setCourseData(myEntityManager.getCourses());
                    break;
                case "TeacherTableModel": // Dessa två cases ska inte användas
                    break;
                case "StudentTableModel":
                    break;
            }
        });

        mainFrame.addShowAssociatedEntityListener(e -> {
            switch (e.getEntityType()) {
                case "EducationTableModel":
                    if (e.getTargetEntityType().equals("showCourses")) {
                        mainFrame.setCourseData(myEntityManager.getEducationCourses(e.getId()));
                    } else if (e.getTargetEntityType().equals("showStudents")){
                        mainFrame.setStudentData(myEntityManager.getEducationStudents(e.getId()));
                    }
                    break;
                case "CourseTableModel":
                    if (e.getTargetEntityType().equals("showCourseTeachers")) {
                        mainFrame.setTeacherData(myEntityManager.getCourseTeachers(e.getId()));
                    } else if (e.getTargetEntityType().equals("showCourseEducations")) {
                        mainFrame.setEducationData(myEntityManager.getCourseEducations(e.getId()));
                    }
                    break;
                case "TeacherTableModel":
                    mainFrame.setCourseData(myEntityManager.getTeacherCourses(e.getId()));
                    break;
                case "StudentTableModel":
                    mainFrame.setEducationData(myEntityManager.getStudentEducation(e.getId()));
                    break;
            }
        });

        mainFrame.addDeleteEntityListener(e -> {
            switch (e.getEntityType()) {
                case "EducationTableModel":
                    myEntityManager.removeEducationById(e.getId());
                    mainFrame.setEducationData(myEntityManager.getEducations());
                    break;
                case "CourseTableModel":
                    myEntityManager.removeCourseById(e.getId());
                    mainFrame.setCourseData(myEntityManager.getCourses());
                    break;
                case "TeacherTableModel":
                    myEntityManager.removeTeacherById(e.getId());
                    mainFrame.setTeacherData(myEntityManager.getTeachers());
                    break;
                case "StudentTableModel":
                    myEntityManager.removeStudentById(e.getId());
                    mainFrame.setStudentData(myEntityManager.getStudents());
                    break;
            }
        });

        mainFrame.addListEntityListener(e -> {
            switch (e.getModelTypeIndex()) {
                case 0:
                    mainFrame.setEducationData(myEntityManager.getEducations());
                    break;
                case 1:
                    mainFrame.setCourseData(myEntityManager.getCourses());
                    break;
                case 2:
                    mainFrame.setTeacherData(myEntityManager.getTeachers());
                    break;
                case 3:
                    mainFrame.setStudentData(myEntityManager.getStudents());
                    break;
            }
        });
    }
}
