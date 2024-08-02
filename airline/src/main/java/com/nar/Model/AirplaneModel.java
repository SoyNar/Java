package com.nar.Model;

import com.mysql.cj.protocol.Resultset;
import com.nar.Entity.Airplane;
import com.nar.Persistence.Conexion.Conexion;
import com.nar.Persistence.IModel.IAirplaneModel;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplaneModel implements IAirplaneModel {

    @Override
    public Airplane create(Airplane object) {

        PreparedStatement ps;
        Connection connection = Conexion.getConnection();

        String query = "INSERT INTO airplane(model,length) VALUES (?, ?)";
        try{
            ps = connection.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, object.getModel());
            ps.setInt(2,object.getLenght());

            int fullLines = ps.executeUpdate();
            if(fullLines == 1){
               ResultSet resultset = ps.getGeneratedKeys();
               if(resultset.next()){
                   object.setId(resultset.getInt(1));
                   System.out.println("airplane guardado");
                   return object;
               }
              ps.close();
            }
        }catch (SQLException e){
            System.out.println(" error " + e.getMessage());
        } finally {
            try{
                Conexion.closeConnection();
            }catch (Exception e){
                System.out.println("error to close the connection" + e.getMessage());
            }
        }

        return null;
    }

    @Override
    public void delete(Integer typeID) {

        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = "DELETE FROM airplane WHERE id = ?";

        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1,typeID);
            int delete = ps.executeUpdate();
            if(delete == 1){
                System.out.println("airplane deteled");

            }else {
                System.out.println("no exist");
            }
        }catch (SQLException e){
            System.out.println("Error to delete airplane" + e.getMessage());
        }finally {
            try{
                Conexion.closeConnection();
            }catch (Exception e){
                System.out.println(" error closing connection");
            }
        }

    }

    @Override
    public List<Airplane> read() {
        List <Airplane> airplanes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet resultSet;
        Connection connection = Conexion.getConnection();
        String query = " SELECT * FROM airplane";

        try{
            ps = connection.prepareStatement(query);
            ps.executeQuery();
            resultSet =  ps.getResultSet();
            while(resultSet.next()){
                Airplane airplane = new Airplane();
               airplane.setId(resultSet.getInt("id"));
               airplane.setModel(resultSet.getString("model"));
               airplane.setLenght(resultSet.getInt("length"));
               airplanes.add(airplane);
            }

        }catch (SQLException e){
            System.out.println("error to list airplane" + e.getMessage());
        }
        finally {
            try{
                Conexion.closeConnection();
            }catch (Exception e){
                System.out.println("error closed to connection" + e.getMessage());
            }
        }

        return airplanes;
    }

    @Override
    public boolean update(Airplane object) {

        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        ResultSet resultSet;
        String query = "UPDATE airplane SET model = ?, length = ? WHERE id = ?";
        try{
            ps = connection.prepareStatement(query);
            ps.setString(1, object.getModel());
            ps.setInt(2,object.getLenght());
            ps.setInt(3, object.getId());
            resultSet = ps.getResultSet();
            int insert = ps.executeUpdate();
            if(insert == 1){
                System.out.println(" update airplane");
               return true;
            }

        }catch (SQLException e){
            System.out.println(" no update" + e.getMessage());
        }
        finally {
            try{
                Conexion.closeConnection();
            }catch (Exception e){
                System.out.println("closing connection " +e.getMessage());
            }
        }
        return false;
    }

    public  boolean isIdFind(Integer id){
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        ResultSet resultSet;
        String query = "SELECT * FROM airplane_flights WHERE id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,id);
            resultSet = ps.executeQuery();
            System.out.println("Found");
            return resultSet.next();
        }catch (SQLException e){
            System.out.println("no found id" + e.getMessage());
        }finally{
            try{
                Conexion.closeConnection();
            }catch (Exception e){
                System.out.println(" error close connection " + e.getMessage());
            }
        }

        return false;
    }
}
