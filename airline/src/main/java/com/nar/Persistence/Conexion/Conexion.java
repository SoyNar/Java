package com.nar.Persistence.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexion {

    static  Connection connection = null;

    public static Connection getConnection (){
        String nameBD = "flights";
        String url = "jdbc:mysql://localhost:3306/" + nameBD;
        String user = "root";
        String password= "tuclave";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);

        }catch (Exception e){
            System.out.println(" error " + e.getMessage());
        }
  return  connection;
    }

    public static void closeConnection(){
        try{
            if(connection != null){
                connection.close();

            }
        }catch (SQLException e){
            System.out.println(" error conecting to the database " + e.getMessage());
        }
    }
}
