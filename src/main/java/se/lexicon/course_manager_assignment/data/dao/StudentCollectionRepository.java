package se.lexicon.course_manager_assignment.data.dao;


import se.lexicon.course_manager_assignment.data.sequencers.StudentSequencer;
import se.lexicon.course_manager_assignment.model.Student;

import java.util.*;


public class StudentCollectionRepository implements StudentDao {

    private Collection<Student> students;

    public StudentCollectionRepository(Collection<Student> students) {
        this.students = students;
    }

    @Override
    public Student createStudent(String name, String email, String adress) {
        //  should set method parameters in student constuctor
        // you need to write validation or condition for checking the input parameter
        if (name == null) {
            throw new IllegalArgumentException("name is not valid");
        }
        if (email == null) {
            throw new IllegalArgumentException("email not valid");
        }
        if (adress == null) {
            throw new IllegalArgumentException("adress is not valid");
        }
        Student student1 = new Student(StudentSequencer.nextStudentId(), name, email, adress);

        students.add(student1);

        return student1;
    }


    @Override
    public Student findByEmailIgnoreCase(String email) {
        for (Student student : students) {
            if (student.getEmail().equalsIgnoreCase(email)) {
                return student;
            }

        }
        return null;
    }


    @Override
    public Collection<Student> findByNameContains(String name) {
        List<Student> result = new ArrayList<>();
        // for each
        for (Student student : students) {
            // get element
            String byName = student.getName();
            // check founded element with input param
            if (byName.contains(name)) {
                result.add(student);
            }
        }

        return result;
    }

    @Override
    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }

        }
        return null;
    }

    @Override
    public Collection<Student> findAll() {
        return new HashSet<>(students);
    }

    @Override
    public boolean removeStudent(Student student) {
        boolean isRemove = false;
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student result = iterator.next();
            if (result.equals(student)) {
                iterator.remove();
                isRemove = true;
            }
        }
        return isRemove;
    }

    @Override
    public void clear() {
        this.students = new HashSet<>();
    }
}
