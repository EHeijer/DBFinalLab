/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;


public interface EducationDaoInterface {

    void addCourseToEducation(int educationId, int courseId);

    Education addEducation(Education education);

    void addStudentToEducation(int educationId, int studentId);

    Education getEducationById(int id);

    //    public List<Education> getEducations() {
    //        EntityManager em = emf.createEntityManager();
    //        List<Education> educations = em.createQuery("SELECT e FROM Education AS e "
    //                + "LEFT JOIN FETCH e.students "
    //                + "LEFT JOIN FETCH e.courses", Education.class).getResultList();
    //        em.close();
    //        return educations;
    //    }
    List<Course> getEducationCourses(int educationId);

    List<Student> getEducationStudents(int educationId);
    //    public List<Course> getEducationCourseJPQL(int educationId) {
    //        EntityManager em = emf.createEntityManager();
    //        em.getTransaction().begin();
    //        List<Course> list = em.createQuery("SELECT e FROM Education AS e LEFT JOIN FETCH e.courses WHERE e.id = :id",Course.class).setParameter("id", educationId).getResultList();
    //        em.getTransaction().commit();
    //        em.close();
    //        return list;
    //    }

    List<Education> getEducations();

    void removeEducationById(int id);

    void updateEducationName(int id, String newName);
    
}
