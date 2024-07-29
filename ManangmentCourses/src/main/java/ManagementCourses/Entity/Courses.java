package ManagementCourses.Entity;

import java.util.ArrayList;
import java.util.List;

public class Courses {
    private int id;
    private static int idCourses;
    private String nameCourse;
    private Students idStudent;

    // constructor vacio
    public Courses(){}

    // constructor valores iniciales
// para modificiar por id, y poner otro nombre
    public Courses(String name, int id){
        this.nameCourse = name;
        this.id = id;
    }
    public Courses  (int id){
        this.id = id;
    }
    public Courses(String nameCourse) {
        this.nameCourse = nameCourse;


    }


    // getter and setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public void setIdStudent(Students idStudent) {
        this.idStudent = idStudent;
    }

    public Students getIdStudent() {
        return idStudent;
    }

    @Override
    public String toString() {
        return "id:"  + id +
                "name: " + nameCourse;
    }
}
