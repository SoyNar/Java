package com.projects.Conecction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conexion {

    static Connection connection = null;

    // method static connection
public static Connection getConexion(){

    // name database
    String dataBase = "Libreria";
    // url name
    String url = "jdbc:mysql://localhost:3306/" + dataBase;

    // user name
    String user = "root";
    // pasword
    String password = "tuclave";

    // error mana"ngement
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        // drivermanager
        connection = DriverManager.getConnection(url,user,password);
        System.out.println("Successful connection!");
    } catch (Exception e){
        // error connect database
        System.out.println("error connecting to the database" + e.getMessage());
    }
    // return the conecction
    return  connection;
}
//method to close the database

    public static void closeConnection(){
     // error management
        try{
            if(connection != null) connection.close();
            System.out.println("conection finisehd");

        }catch (Exception e){
            System.out.println("error " + e.getMessage());
        }
    }

}
