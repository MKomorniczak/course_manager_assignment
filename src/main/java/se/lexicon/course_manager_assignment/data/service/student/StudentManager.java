package se.lexicon.course_manager_assignment.data.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.course_manager_assignment.data.dao.CourseDao;
import se.lexicon.course_manager_assignment.data.dao.StudentDao;
import se.lexicon.course_manager_assignment.data.service.converter.Converters;
import se.lexicon.course_manager_assignment.dto.forms.CreateStudentForm;
import se.lexicon.course_manager_assignment.dto.forms.UpdateStudentForm;
import se.lexicon.course_manager_assignment.dto.views.StudentView;
import se.lexicon.course_manager_assignment.model.Student;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class StudentManager implements StudentService {

    private final StudentDao studentDao;
    private final CourseDao courseDao;
    private final Converters converters;

    @Autowired
    public StudentManager(StudentDao studentDao, CourseDao courseDao, Converters converters) {
        this.studentDao = studentDao;
        this.courseDao = courseDao;
        this.converters = converters;
    }

    @Override
    public StudentView create(CreateStudentForm form) {
        studentDao.createStudent(form.getName(), form.getEmail(), form.getAddress());
        return null;
    }

    @Override
    public StudentView update(UpdateStudentForm form) {
        //using a studentDao we need to invoke findById
        //get founded variable and then set form.variable
        //convert student to studentView
        Student student = studentDao.findById(form.getId());
        student.setName(form.getName());
        student.setEmail(form.getEmail());
        student.setAdress(form.getAddress());

        return null;
    }


    //todo: I am sure this one is wrong.
    @Override
    public StudentView findById(int id) {
  /*      for (Student student: studentDao.findAll()){
            if (studentDao.findAll().equals(id)){
                return ;
            }
        }*/
        return null;
    }

    @Override
    public StudentView searchByEmail(String email) {
        return null;
    }

    @Override
    public List<StudentView> searchByName(String name) {


        return null;
    }

    @Override
    public List<StudentView> findAll() {
    }

    @Override
    public boolean deleteStudent(int id) {
        return false;
    }
}
