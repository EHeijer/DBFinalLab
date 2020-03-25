package model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Education {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    
    @OneToMany
    private Set<Student> students;
    
    @ManyToMany(mappedBy = "educations")
    private Set<Course> courses;

    public Education() {
        this.students = new HashSet<>();
        this.courses = new HashSet<>();
    }
    
    public void addStudent(Student student){
        this.students.add(student);
        student.setEducation(this);
    }
    
    public void addCourse(Course course){
        this.courses.add(course);
        course.getEducations().add(this);
    }
    
    public void removeStudent(Student student){
        this.students.remove(student);
        student.setEducation(null);
    }
    
    public void removeCourse(Course course){
        this.courses.remove(course);
        course.getEducations().remove(this);
    }
    

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Education{" + "name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }
}
