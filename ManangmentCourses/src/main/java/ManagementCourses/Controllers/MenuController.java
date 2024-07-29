package ManagementCourses.Controllers;

import ManagementCourses.DataBase.ICrud;
import ManagementCourses.Entity.Courses;
import ManagementCourses.Model.CourseModel;


import java.util.List;
import java.util.Scanner;

public class MenuController {

    public static void main(String[] args) {
        coursesApp();
    }

    public static void coursesApp(){
        boolean salir = false;
        Scanner entradaDatos = new Scanner(System.in);
        // creamos objeto de la clase coursesModel
        ICrud courseModel = new CourseModel();
        while(!salir){
            // la llamada al metodo puede arrojar un error
            try{
              int opcion = mostrarMenu(entradaDatos);
             salir = ejecutarOpciones(entradaDatos,opcion, courseModel); // metodo devuelve verdadero o falso
            }catch (Exception e){
                System.out.println("error al ejecutar opciones " + e.getMessage());
            }
            // impirmimos un salto de linea
            System.out.println();
        }

    }


    private static int  mostrarMenu(Scanner entradaDatos){
        System.out.println(" Menu 1. Listar 2. agregar curso 3. mdofifica curso 4. buscar curso por id 5. eliminar curso 6. salir");
        return entradaDatos.nextInt();

    }

    private static boolean ejecutarOpciones(Scanner entradaDatos, int opcion, ICrud courseModel){
    boolean salir = false;
      switch (opcion){
          case 1:
              System.out.println("--- Listado de Cursos ---");
              List<Courses> coursesList = courseModel.listCourses();
              coursesList.forEach(System.out::println);
          break;
          case 2:

              System.out.println("ingresa el nombre del curso");
              String nameCurso = entradaDatos.nextLine();
              Courses course = new Courses(nameCurso);
              entradaDatos.nextLine();
              boolean agregar = courseModel.addCourse(course);
              if(agregar){
                  System.out.println("agregado " + course);
              }else {
                  System.out.println("no se agrego: " + course.getId());
              }
              break;

          case 3:
              System.out.println("introduce el id del curso a buscar");
              int idCourse = entradaDatos.nextInt();
              Courses course2 = new Courses(idCourse);
              boolean encontrado = courseModel.buscarCourseById(course2);
              if(encontrado){
                  System.out.println("encontrado " + course2);
              } else{
                  System.out.println("no encontrado " + course2.getId());
              }
              break;

          case 4:
              System.out.println("Escribe el id del curso a eliminar");
              int idCorseD = entradaDatos.nextInt();
              Courses cursoNuevo = new Courses(idCorseD);
              boolean borrado = courseModel.deleteCourse(cursoNuevo);
              if(borrado){
                  System.out.println("Borrado " + cursoNuevo);
              }else {
                  System.out.println("No se borro" + cursoNuevo);
              }

              break;

          case 5:
              System.out.println("escribe el id del curso a editar");
              int idEditar = entradaDatos.nextInt();
              System.out.println("escriba el nuevo nombre del curso");
              String newName = entradaDatos.nextLine();
              entradaDatos.nextLine();
              Courses cursoEditar = new Courses(newName,idEditar);
              boolean editar = courseModel.modificiarCurso(cursoEditar);
              if(editar){
                  System.out.println("curso editado" + cursoEditar);
              }else {
                  System.out.println("no editado" + cursoEditar.getId());
              }


          default:
              break;

      }
      return salir;
    }


}


