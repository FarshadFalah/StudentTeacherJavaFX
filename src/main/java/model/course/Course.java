package model.course;

import model.person.Student;
import model.person.Teacher;

import java.util.List;
import java.util.Objects;

public class Course {
    private final String name;
    private Teacher teacher;
    private List<Student> studentsList;

    public Course(String name, Teacher teacher, List<Student> studentsList) {
        this.name = name;
        this.teacher = teacher;
        this.studentsList = studentsList;
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public void addStudent(Student student) {
        this.studentsList.add(student);
    }

    public void removeStudent(Student student) {
        if(studentsList.size()>1) {
            this.studentsList.remove(student);
        }
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return getName().equals(course.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
