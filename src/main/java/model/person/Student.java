package model.person;

import model.course.Course;

import java.util.List;

public class Student extends Person{

    private List<Course> courseList;

    public Student(String name, List<Course> courseList) {
        super(name);
        this.courseList = courseList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void addCourseList(Course course) {
        this.courseList.add(course);
    }

}
