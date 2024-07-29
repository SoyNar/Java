package ManagementCourses.Entity;

import java.util.Objects;

public class Students {
    private int id;
    private static  int idStudents;
    private String name;
    private String email;

    //constructor

    public Students(){}

    // constructor que recibe solo el id
    // sirve para eliminar
    public  Students(int id){
        this.id = id;

    }

    // para insercion de objetos
    public  Students(String name, String email){
        this.name = name;
        this.email = email;
        this.id = ++idStudents;

    }

    // getters and setters


    public void setId(int id) {
        this.id = id;
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

    // metodo equal y hascode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return id == students.id && Objects.equals(name, students.name) && Objects.equals(email, students.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }



    // metodo tostring


    @Override
    public String toString() {
        return "id :" + id;
    }
}
