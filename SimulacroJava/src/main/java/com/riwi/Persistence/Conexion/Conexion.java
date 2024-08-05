package com.riwi.Persistence.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

public class Conexion {

    static Connection connection = null;

    public static Connection getConnection(){
        String nameDatabase = "contrataciones";
        String url = "jdbc:mysql://localhost:3306/contrataciones";
        String user = "root";
        String password = "Rlwl2023.";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
         connection = DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            System.out.println("Error to conect " + e.getMessage());
        }
         return  connection;
    }

    public static void closedConnection (){
        if(connection!= null){
           try{
               connection.close();
           }catch (SQLException e){
               System.out.println(" error to closed conexion " +e.getMessage());
           }
        }
    }
}





