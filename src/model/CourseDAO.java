package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CourseDAO implements CourseDaoInterface {
   private EntityManagerFactory emf;

    public CourseDAO() {
        emf = Persistence.createEntityManagerFactory("DBFinalLabPU");
    }

    @Override
    public Course addCourse(Course course) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
        em.close();
        return course;
    }

    @Override
    public void removeCourseById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Course course = em.find(Course.class, id);
        for (Education education : course.getEducations()) {
            education.getCourses().remove(course);
        }
        course.getEducations().clear();
        for (Teacher teacher : course.getTeachers()) {
            teacher.getCourses().remove(course);
        }
        course.getTeachers().clear();
        em.remove(course);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void addTeacherToCourse(int courseId, int teacherId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Course course = em.find(Course.class, courseId);
        Teacher teacher = em.find(Teacher.class, teacherId);
        course.addTeacher(teacher);
        em.persist(course);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateCourseName(int id,String newName) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Course course = em.find(Course.class, id);
        course.setName(newName);
        em.persist(course);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Course> getCourses() {
        EntityManager em = emf.createEntityManager();
        List<Course> courses = em.createQuery("SELECT c FROM Course AS c ", Course.class).getResultList();
        em.close();
        return courses;
    }

    @Override
    public List<Teacher> getCourseTeachers(int courseId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Course course = em.find(Course.class, courseId);
        List<Teacher> list = new ArrayList<>(course.getTeachers());
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Education> getCourseEducations(int courseId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Course course = em.find(Course.class, courseId);
        List<Education> list = new ArrayList<>(course.getEducations());
        em.getTransaction().commit();
        em.close();
        return list;
    }
}