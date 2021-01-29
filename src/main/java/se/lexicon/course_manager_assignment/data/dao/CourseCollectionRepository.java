package se.lexicon.course_manager_assignment.data.dao;


import se.lexicon.course_manager_assignment.data.sequencers.CourseSequencer;
import se.lexicon.course_manager_assignment.model.Course;
import se.lexicon.course_manager_assignment.model.Student;

import java.time.LocalDate;
import java.util.*;


public class CourseCollectionRepository implements CourseDao {

    private Collection<Course> courses;


    public CourseCollectionRepository(Collection<Course> courses) {
        this.courses = courses;
    }

    @Override
    public Course createCourse(String courseName, LocalDate startDate, int weekDuration) {
        if (courseName == null) {
            throw new IllegalArgumentException("not valid");
        }
        if (startDate == null) {
            throw new IllegalArgumentException("not valid");
        }
        if (weekDuration == 0) {
            throw new IllegalArgumentException("not valid");
        }

        Course course1 = new Course(CourseSequencer.nextCourseId(), courseName, startDate, weekDuration);
        courses.add(course1);

        return course1;
    }

    @Override
    public Course findById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    @Override
    public Collection<Course> findByNameContains(String name) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            String courseByName = course.getCourseName();
            if (courseByName.contains(name)) {
                result.add(course);
            }
        }
        return result;

    }


    @Override
    public Collection<Course> findByDateBefore(LocalDate end) {
        List<Course> result = new ArrayList<>();
        for (Course course: courses){
            if (course.getStartDate().isBefore(end)){
                return result;
            }
        }


        return null;
    }

    @Override
    public Collection<Course> findByDateAfter(LocalDate start) {
        List<Course> result = new ArrayList<>();
        for (Course course: courses) {
            if (course.getStartDate().isAfter(start)){
                return result;
            }

        }
        return null;
    }

    @Override
    public Collection<Course> findAll() {
        return new HashSet<>(courses);
    }

    @Override
    public Collection<Course> findByStudentId(int studentId) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            // first you should get students from the course object
            // assign it in the Collection
            // for each statement regarding to the students collection
            // check condition
            Collection<Student> students = course.getStudents();
            for (Student student : students) {
                if (student.getId() == studentId) {
                    result.add(course);
                }

            }

            return result;
        }
        return  null;
    }

    @Override
    public boolean removeCourse(Course course) {
        boolean isRemove = false;
        Iterator<Course> iterator = courses.iterator();
        while (iterator.hasNext()) {
            Course result = iterator.next();
            if (result.equals(course)) {
                iterator.remove();
                isRemove = true;
            }
        }
        return isRemove;
    }

    @Override
    public void clear() {
        this.courses = new HashSet<>();
    }
}
