/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;


public interface CourseDaoInterface {

    Course addCourse(Course course);

    void addTeacherToCourse(int courseId, int teacherId);

    List<Education> getCourseEducations(int courseId);

    List<Teacher> getCourseTeachers(int courseId);

    List<Course> getCourses();

    void removeCourseById(int id);

    void updateCourseName(int id, String newName);
    
}
