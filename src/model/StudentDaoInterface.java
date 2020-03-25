/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;


public interface StudentDaoInterface {

    Student addStudent(Student student);

    Student getStudentById(int id);

    List<Education> getStudentEducation(int studentId);

    List<Student> getStudents();

    void removeStudentById(int id);

    void updateStudentName(int id, String newName);
    
}
