package se.lexicon.course_manager_assignment.model;

import se.lexicon.course_manager_assignment.data.sequencers.StudentSequencer;

import java.util.Objects;

// ctrl + alt + L
public class Student {
    private int id;
    private String name;
    private String email;
    private String adress;

    public Student() {
    }

    // overloaded costructor


    public Student(int id, String name, String email, String adress) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.adress = adress;
    }

    public Student(String name, String email, String adress) {
        this.name = name;
        this.email = email;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name) && Objects.equals(email, student.email) && Objects.equals(adress, student.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, adress);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
