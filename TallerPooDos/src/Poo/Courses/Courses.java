package Poo.Courses;

import java.util.ArrayList;

public class Courses {

    private static int idCourses;
    private int id;
    private String nameCourse;
    private ArrayList<Students> StudenstBycourse;

    // constructor

    public Courses(String nameCourse) {
        this.id = ++idCourses;
        this.nameCourse = nameCourse;
        StudenstBycourse =  new ArrayList<>();
    }

    // getter and setter


    public int getId() {
        return id;
    }


    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public ArrayList<Students> getStudenstBycourse() {
        return StudenstBycourse;
    }

    public void setStudenstBycourse(ArrayList<Students> studenstBycourse) {
        StudenstBycourse = studenstBycourse;
    }
}
