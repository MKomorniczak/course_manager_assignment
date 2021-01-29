package se.lexicon.course_manager_assignment.data.service.converter;

import org.springframework.stereotype.Component;
import se.lexicon.course_manager_assignment.dto.views.CourseView;
import se.lexicon.course_manager_assignment.dto.views.StudentView;
import se.lexicon.course_manager_assignment.model.Course;
import se.lexicon.course_manager_assignment.model.Student;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ModelToDto implements Converters {
    @Override
    public StudentView studentToStudentView(Student student) {
        StudentView studentView1 = new StudentView(0, student.getName(), student.getEmail(), student.getAdress());


        return studentView1;
    }



    @Override
    public CourseView courseToCourseView(Course course) {
        CourseView courseView1 = new CourseView(0, course.getCourseName(), course.getStartDate(), 0, studentsToStudentViews(course.getStudents()));
        return courseView1;
    }

    @Override
    public List<CourseView> coursesToCourseViews(Collection<Course> courses) {
        List<CourseView> courseView = new ArrayList<>();
        for (Course course: courses){
            CourseView courseView1 = courseToCourseView(course);
            courseView.add(courseView1);
        }

        return courseView;
    }

    @Override
    public List<StudentView> studentsToStudentViews(Collection<Student> students) {
        List<StudentView> studentView = new ArrayList<>();

        for (Student student : students) {
            // the same 2 methods
            //StudentView studentView1 = new StudentView(0, student.getName(), student.getEmail(), student.getAdress());
            StudentView studentView1 = studentToStudentView(student);
            studentView.add(studentView1);


        }
        return studentView;
    }
}
