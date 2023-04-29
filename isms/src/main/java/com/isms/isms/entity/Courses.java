package com.isms.isms.entity;


import jakarta.persistence.*;

@Entity
@Table(name="courses")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="course_id")
    private int id;

    @Column(name="course_name")
    private String courseName;

    @Column(name="course_desc")
    private String courseDesc;

    @Column(name="location")
    private String location;


    public Courses (){}

    public Courses(String courseName, String courseDesc, String location) {
        this.courseName = courseName;
        this.courseDesc = courseDesc;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", courseDesc='" + courseDesc + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
