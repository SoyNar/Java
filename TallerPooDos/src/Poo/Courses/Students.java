package Poo.Courses;

public class Students {

    private static  int idStudents;
    private int id;
    private String name;
    private String email;

    public Students( String name, String email) {
        this.id = ++idStudents;
        this.name = name;
        this.email = email;
    }

    // getters and setters

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
}
