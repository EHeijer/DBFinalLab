/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;


public interface TeacherDaoInterface {

    Teacher addTeacher(Teacher teacher);

    Teacher getTeacherById(int id);

    //    public List<Teacher> getTeachers() {
    //        EntityManager em = emf.createEntityManager();
    //        List<Teacher> teachers = em.createQuery("" +
    //                "SELECT t FROM Teacher AS t " +
    //                "LEFT JOIN FETCH t.courses", Teacher.class).getResultList();
    //        em.close();
    //        return teachers;
    //    }
    List<Course> getTeacherCourses(int teacherId);

    List<Teacher> getTeachers();

    void removeTeacherById(int id);

    void updateTeacherName(int id, String newName);
    
}
