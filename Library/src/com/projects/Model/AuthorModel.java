package com.projects.Model;

import com.projects.Conecction.Conexion;
import com.projects.Conecction.Crud;
import com.projects.Entity.Authors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorModel  implements Crud {


    @Override
    public List<Object> list() {
        List<Authors> authors = new ArrayList<>();
        PreparedStatement ps;
        ResultSet resultSet;
        Connection connection = Conexion.getConexion();
        String sql = "SELECT * FROM autor  ORDER By autor.id ASC";


        try{
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while(resultSet.next()){
                Authors authors1 = new Authors();
               authors1.setId(resultSet.getInt("id"));
               authors1.setName(resultSet.getString("name"));
               authors1.setNationality(resultSet.getString("nacionalidad"));
               authors.add(authors1);
            }
        }catch (SQLException e){
            System.out.println("error to list authors "+ e.getMessage());
        }
        Conexion.closeConnection();

        return null;
    }

    @Override
    public boolean insert(Object object) {
        PreparedStatement ps;
        Connection connection = Conexion.getConexion();
        String sql = "INSER INTO autor (name,nacionalidad) VALUES (?,?)";
        //caste the object class
        Authors objectAuthor = (Authors)object;
        try{
            ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1,objectAuthor.getName());
            ps.setString(2,objectAuthor.getNationality());

            int filasAfectadas = ps.executeUpdate();

            // recuperar id o clave primaria
            if(filasAfectadas == 1){
                ResultSet result = ps.getGeneratedKeys();
                if(result.next()){
                    objectAuthor.setId(result.getInt(1));
                    System.out.println("autor guardado");
                    return true;
                }
            }else {
                System.out.println("Error al insertar autor");
            }

        }catch (SQLException e){
            System.out.println("error to insert author" + e.getMessage());
        }
        finally {
            try{connection.close();
            }catch (Exception e){
                System.out.println(" error to close database" + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean findByid(Object object) {
        return false;
    }

    @Override
    public boolean delete(Object object) {
        Authors authorB = (Authors) object;
        PreparedStatement ps;
        Connection connection = Conexion.getConexion();
        String query = "DElELTE FROM autor WHERE id = ?";

        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1, authorB.getId());

            int delete = ps.executeUpdate();
            if(delete ==1){
                System.out.println("objeto borrado");
                return true;
            }
        }catch (SQLException e){
            System.out.println(" objet no delete");
        }
        return false;
    }

    @Override
    public boolean edit(Object object) {
        PreparedStatement ps;
        Authors authorBook = (Authors) object;
        ResultSet resultSet;
        Connection connection = Conexion.getConexion();
        String query = "UPDATE autor set name = ?, nacionalidad = ? WHERE id = ?";
        try{
          ps = connection.prepareStatement(query);
          ps.setString(1,authorBook.getName());
          ps.setString(2, authorBook.getNationality());
          ps.setInt(3,authorBook.getId());
          int update = ps.executeUpdate();
          if(update > 0){
              System.out.println("autor actualizado");
          }
          return  true;
        }catch (Exception e){
            System.out.println("error to update author" + e.getMessage());
        }
        Conexion.closeConnection();
        return false;
    }
}
