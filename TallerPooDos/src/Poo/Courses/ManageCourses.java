package Poo.Courses;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageCourses {

    private ArrayList<Courses> mangaCourses;

    public ManageCourses() {
        this.mangaCourses = new ArrayList<>();
    }

    // methos

    // to add a course at array list mangacourses
    public void addCourses(Courses course){
        this.mangaCourses.add(course);
    }

    // to find a course by id and return the object course
    public Courses findCurseById(Integer idCourse){
        for(Courses courses: mangaCourses){
            if(idCourse.equals(courses.getId())){
                return courses;
            }
        }
        return null;
    }

    // by register a student
    public void registerAStudent(Students student, Integer idCourse){
        Courses courses = findCurseById(idCourse);
        if(courses != null){

            courses.getStudenstBycourse().add(student);
            System.out.println("inscrito con exito");

        }else {
            System.out.println("no encontrado");
        }
    }

    // to list student by course for id
    public void listStudentByCourse(Integer idCourse){
        Courses courses = findCurseById(idCourse);
        if(courses != null){
            for (Students students : courses.getStudenstBycourse()){
                System.out.println("name Students: " + students.getName()
                + " email:" + students.getEmail() + " id :" + students.getId());
            }
        }else {
            System.out.println("no encontrado");
        }
    }

    // to list all courses
    public void listCourses (){
        for (Courses courses : mangaCourses){
            System.out.println("name :" + courses.getNameCourse()
            + " id Course: " + courses.getId());
        }
    }


}



class main{
    public static void main(String[] args) {
        ManageCourses manageCourses = new ManageCourses();
        Scanner dataEntry = new Scanner(System.in);
        int option = 0;
        String menu = """
                options menu
                1. add courses 
                2. List courses
                3. Register student
                4. List Studen by courses
                5. exit
                """;
        while(option != 5){
            System.out.println(menu);
            option = dataEntry.nextInt();

            switch (option){
                case 1:
                    dataEntry.nextLine();
                    System.out.println("ingrese nombre del curso");
                    String nameCourse = dataEntry.nextLine();
                    Courses newCourse = new Courses(nameCourse);
                    manageCourses.addCourses(newCourse);
                    break;

                case 2:
                    manageCourses.listCourses();
                    break;
                case 3:

                    System.out.println("ingrese el id del curso");
                    Integer idCourse = dataEntry.nextInt();

                    dataEntry.nextLine();
                    System.out.println("ingrese nombre  estudiantes");
                    String nameStudent  = dataEntry.nextLine();

                    System.out.println("ingrese email");
                    String emailStudent = dataEntry.nextLine();

                    Students student = new Students(nameStudent, emailStudent);
                    manageCourses.registerAStudent(student,idCourse);
                    break;

                case 4:
                    System.out.println("ingrese el id del curso");
                    Integer idCoursse = dataEntry.nextInt();
                    manageCourses.listStudentByCourse(idCoursse);
                    break;

                case 5:
                    System.out.println("saliendo del sistema");
                    break;
            }
        }

    }
}
