package se.lexicon.course_manager_assignment.model;

import java.time.LocalDate;
import java.util.*;

public class Course {
    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private Collection<Student> students = new HashSet<>();

    public Course() {
    }

    public Course(int id, String courseName, LocalDate startDate, int weekDuration) {
        this.id = id;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
    }

    public Course(String courseName, LocalDate startDate, int weekDuration) {
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
    }

    public Course(int nextCourseId, String java, int i) {
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    public boolean enrollStudent(Student student) {
        //a
        for (Student student1 : students) { // a,b,c,d
            if (student1.equals(student)) { //a == g
                return false;
            }

        }
        students.add(student);
        return true;
    }

    public boolean unenrollStudent(Student student) {
        boolean isUnenroll = false;
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student result = iterator.next();
            if (result.equals(student)) {
                iterator.remove();
                isUnenroll = true;

            }
        }
        return isUnenroll;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && weekDuration == course.weekDuration && Objects.equals(courseName, course.courseName) && Objects.equals(startDate, course.startDate) && Objects.equals(students, course.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, startDate, weekDuration, students);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", weekDuration=" + weekDuration +
                ", students=" + students +
                '}';
    }
}
