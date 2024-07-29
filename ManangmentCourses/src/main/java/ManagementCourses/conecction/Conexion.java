package ManagementCourses.conecction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static java.lang.Class.forName;

public class Conexion {
    public static Connection getConexion(){
        Connection conexion = null;
        // base de datos a la cual nos queremos conectar
        String baseDatos = "Courses";
        String url = "jdbc:mysql://localhost:3306/" + baseDatos;
        String user = "root";
        String password = "tuclave";
        String consulta = "insert into students (name,email) values ('arnoldo', 'arnoldo@example.co')";
        try{

            // cargar nombre de la clase para conectar a mysql

            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url,user,password);
            Statement sentencia = conexion.createStatement();
            sentencia.execute(consulta);
        } catch (Exception e){
            System.out.println("Error al conectarse a la base de datos" + e.getMessage());
        }
        return conexion;
    }

//    public static void main(String[] args) {
//        Connection conexion = Conexion.getConexion();
//        if(conexion != null){
//            System.out.println("Conexion exitosa" + conexion);
//        } else{
//            System.out.println("Error al conectarse");
//        }
//    }
}
