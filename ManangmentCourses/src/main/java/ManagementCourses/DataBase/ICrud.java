package ManagementCourses.DataBase;

import ManagementCourses.Entity.Courses;
import ManagementCourses.Entity.Students;

import java.util.List;

public interface ICrud {

    // listar cursos
    List<Courses> listCourses();
    // buscar curso por id

    boolean buscarCourseById(Courses course);
    boolean addCourse(Courses course);
    boolean modificiarCurso(Courses course);
    boolean deleteCourse (Courses course);

}
