package ManagementCourses.Model;

import ManagementCourses.DataBase.ICrud;
import ManagementCourses.Entity.Courses;
import ManagementCourses.Entity.Students;
import ManagementCourses.conecction.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class CourseModel implements ICrud {

    @Override
    public List<Courses> listCourses() {
        //. Inicializar la lista donde se guardaran los registros que devuelve la BD
        List <Courses> courses  = new ArrayList<>();
            //preparar la sentencia sql
            PreparedStatement ps;
            ResultSet rs;
        Connection conection = Conexion.getConexion();
        //Escribir la sentencia SQL

        String sql = "SELECT * FROM Courses ORDER BY Courses.id ASC;";

        try{
            // preparando la sentencia del metodo SQL
//            Utilizar PrepareStatement
            ps = conection.prepareStatement(sql);

            // almacenamos el resultado
//            Ejecutar el Query o él prepare
            rs = ps.executeQuery();

            //iterar los resultado usando while
              while(rs.next()){  // metodo next para saber si tenemos registros a iterar
// creamos un objeto para establecer que valor vamos a recuperar

                  Courses objectCourse = new Courses();
                  //solicitar valores

                  objectCourse.setId(rs.getInt("id"));
                  objectCourse.setNameCourse(rs.getString("name"));

                  // Obtén el ID del estudiante desde la base de datos
                  int studentId = rs.getInt("student_id"); // Reemplaza "student_id" con el nombre de la columna en tu base de datos

                  // Crea un objeto Student y establece su ID
                  Students student = new Students();
                  student.setId(studentId);

                  // Asigna el objeto Student al objeto Course
                  objectCourse.setIdStudent(student);
                  courses.add(objectCourse);
              }
        }catch (Exception e){
            System.out.println("Error al listar clientes " + e.getMessage());
        }
        finally {

            try {
                // Cerramos la conexión
                conection.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion" + e.getMessage());

            }
        }
        return courses ;
    }

    @Override
    public boolean buscarCourseById(Courses course) {
        // recibimos un objeto de tipo cliente
        // recibimos un id que vamos a buscar
        // declarar variables a usar
        PreparedStatement ps;
        ResultSet resul;
        Connection connection = Conexion.getConexion();
        String sql  = "SELECT * FROM Courses WHERE id = ?";
        try{

            // preparar sentencia sql
            ps = connection.prepareStatement(sql);
            // pasamos parametro de tipo entero a la query
            // indice uno indica que ocupa primera posicion en la sentencia preparada
            ps.setInt(1,course.getId());
            // recibimos el resultado
            resul = ps.executeQuery(); // llamamos execute query

            // pregutar si se enontro un registro con el metodo next()

            if(resul.next()){
                // pormedio de result, pedimos la info o recuperamos los datos
                course.setId(resul.getInt("id"));
                course.setNameCourse(resul.getString("name"));
                return true;
            }


        }catch (Exception e){
            System.out.println("Error al recuperar al cliente id: " + e.getMessage());
        }
        // cerramos la conexion y usamos otro try catch ya que al cerrar la conexion
        // puede haber otro posible error en tiempo de ejecucion
        finally {
            try{
                connection.close();            }
            catch (Exception e){
                System.out.println("error al cerrar conexion");
            }

        }

        return false;
    }

    @Override
    public boolean addCourse(Courses course) {
        // definimos variable de tipo preparestament
        PreparedStatement ps;
        Connection connection = Conexion.getConexion();
        String sql  = "INSERT INTO Courses(name) VALUES ( ? )"; // ? parametros posicionales // se respeta la posicion en que se ponen
        // por example tiene indice 1
       // se debe respetar el orden en que se ponen
        // try catch puede generar excepcion al agregar cliente


        try{
            // con el objeto conecction llamamos el preparestament y le pasamos el sql
           ps =  connection.prepareStatement(sql); // asignamos ese objeto que nos recupera a la variable preparestatement
           // completamos los parametro posicionales
            ps.setString(1,course.getNameCourse()); // proporcionamos el indice

            // recuperamos el valor llamando getnamecourse
            // ejecutamos nuestra sentencia de tipo preparestemanet

            ps.execute();
           return  true; // si agrega devolvemos verdadero
        }catch (Exception e){
            System.out.println("error al agregar curso" + e.getMessage());

        }
        finally {
            try{
                //cerrra conexion
                connection.close();

            }catch (Exception e){
                System.out.println("error al cerrar conexion" + e.getMessage());
            }
        }

        return false; // si no funcuona o llegamos al final del metodo devuelve false
    }

    @Override
    public boolean modificiarCurso(Courses course) {

        // indicar id del archivo que quermos modificiar
        // debe ser uno existente

        PreparedStatement ps;
        Connection connection = Conexion.getConexion();
        // query
        String sql = "UPDATE Courses SET name=? WHERE id=?";
        // procesamos la posible excepcion

        try{
            // llamamos prepareestament
            // preparando nuestra sentencia squl
            ps = connection.prepareStatement(sql);
            // sustituimos parametros posicionales
            ps.setString(1,course.getNameCourse()); // lo recuperamos del objeto de tipo cliente
            // parametro de id
            ps.setInt(2,course.getId());
            // luego de preparar nuestro objeto ejecutamos la sentendcia
            ps.execute();
        // regresamos valor de verdadero
            return true;
        }catch (Exception e){
            System.out.println("error al actualizar" + e.getMessage());
        }
        // llamamos finally para cerra la conexion

        finally {
            try {
                connection.close();
            }catch (Exception e){
                System.out.println("error al cerrar la conexion" + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean deleteCourse(Courses course) {
        PreparedStatement ps;
        Connection connection = Conexion.getConexion();
        String sentenciaSql = "DELETE FROM Courses WHERE id=?";

        // try catsh para el posibl error
        try{
            // preparestatement para preparar nuestra sentencia
            ps = connection.prepareStatement(sentenciaSql);
            // con esa variable terminamos de configurar nuestra sentencia
            ps.setInt(1,course.getId());
            // ejecutamos
            ps.execute();
            // retornamos true
            return true;

        }catch (Exception e){
            System.out.println("no se pudo borrar" + e.getMessage());
        }
        finally {
            try{
                connection.close();
            }catch (Exception e){
                System.out.println("no se pudo cerrar la cconexion " + e.getMessage());
            }
        }
        return false;
    }

//    public static void main(String[] args) {
//        //listar clientes
//        System.out.println("-------Listar Clientes -----------");
//        ICrud courseModel = new CourseModel();
//
//
//
//        // buscar curso por ud
////        Courses courses1 = new Courses(6);
////
////        //usamos el objeto de courseMOdel y llamamos metodo buscarcoursoby id
////        boolean encontrado = courseModel.buscarCourseById(courses1);
////        // preguntamos si se ha encontrado el registro
////        // imprimimos el objeto de cliente
////
////        if(encontrado){
////            System.out.println("Curso encontrado : " + courses1);
////        } else { // imprimimos id del cliente que no se encontró
////            System.out.println("no se encontro curso con id :" + courses1.getId());
////        }
//
//        // agregar un lciente
//        // creamos objeto tipo curso, llenamos el parametro a agregar en la base de datos
////        Courses course = new Courses("Fisica");
////        // variable tipo boolean para guardar el valor que rentorna nuestro metodo add, le pasamos
////        // el objeto tipo curso creado
////        boolean agregado = courseModel.addCourse(course);
////        if(agregado){
////            System.out.println(" curso agregaso" + course);
////        } else {
////            System.out.println("no agregado" + course.getId());
////        }
//
//        //modificar cliente
////     Courses course2 = new Courses("Biologia", 1);
////        boolean modificado = courseModel.modificiarCurso(course2);
////        if(modificado){
////            System.out.println("curso modificado: " + course2);
////        }else {
////            System.out.println("no se modifico " + course2);
////        }
//        Courses course = new Courses(10);
//        boolean eliminado = courseModel.deleteCourse(course);
//        if(eliminado){
//            System.out.println("Curso eliminado " + course);
//        }else {
//            System.out.println("no eliminado" + course.getClass());
//        }
//
////         el metodo litcourses devuelve unalista, necesitamos guardarla, para luego poder iterarla
//        List<Courses> courses = courseModel.listCourses();
//        //usamos for each para recorrer la lista
//        courses.forEach(System.out::println); // metodo de referencia
//
//    }

}
