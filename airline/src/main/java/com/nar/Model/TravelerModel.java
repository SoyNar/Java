package com.nar.Model;

import com.nar.Entity.Traveler;
import com.nar.Persistence.Conexion.Conexion;
import com.nar.Persistence.IModel.ITraveler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TravelerModel implements ITraveler {
    @Override
    public Traveler create(Traveler object) {
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        ResultSet resultSet;
        String query = " INSERT INTO traveler (name, lastName, id_number) VALUES (?, ?, ?)";
        try{
            ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,object.getName());
            ps.setString(2,object.getLastName());
            ps.setInt(3,object.getIdNumber());

            int insert= ps.executeUpdate();
            if(insert == 1){
                resultSet = ps.getGeneratedKeys();

                if(resultSet.next()){
                    object.setId(resultSet.getInt(1));
                    System.out.println(" insert");
                    return object;
                }
                ps.close();
            }
        }catch (SQLException e){
            System.out.println(" error to create " + e.getMessage());
        } finally {
            try{
                Conexion.closeConnection();
            }catch (Exception e){
                System.out.println("error closithg database " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<Traveler> read() {
        List<Traveler> listTraveler = new ArrayList<>();
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = " SELECT * FROM traveler";

        try{
            ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                Traveler newTraveler = new Traveler();
                newTraveler.setId(resultSet.getInt("id"));
                newTraveler.setName(resultSet.getString("name"));
                newTraveler.setLastName(resultSet.getString("lastName"));
                newTraveler.setIdNumber(resultSet.getInt("id_number"));
                listTraveler.add(newTraveler);
            }
            ps.close();

        }catch (SQLException e){
            System.out.println(" error to read travlers" + e.getMessage());
        }
        finally {
            try{
                Conexion.closeConnection();
            }catch (Exception e){
                System.out.println(" error closed connection " +e.getMessage());
            }
        }
        return listTraveler;
    }

    @Override
    public boolean update(Traveler object) {
        boolean foundID = foundById(object.getId());


        boolean idFound = foundById(object.getId());
        return false;
    }

    public boolean foundById(int id){
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = " SELECT * FROM traveler WHERE id = ?";
        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
               return  true;
            } else{
                return  false;
            }

        }catch (SQLException e){
            System.out.println(" error no found id" + e.getMessage());
        } finally {
            {
                try{
                    Conexion.closeConnection();
                }catch (Exception e){
                    System.out.println(" error to closed connection" +e.getMessage());
                }

            }
        }
        return  false;
    }
}
