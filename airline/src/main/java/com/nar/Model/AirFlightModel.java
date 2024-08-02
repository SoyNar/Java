package com.nar.Model;

import com.nar.Entity.AirFlights;
import com.nar.Persistence.Conexion.Conexion;
import com.nar.Persistence.IModel.IAirFlights;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirFlightModel implements IAirFlights {
    @Override
    public AirFlights create(AirFlights object) {
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = "INSERT INTO airplane_flights (destination,date_flight,hour_flight,flights_id) VALUES (?, ?, ? ,?)";

        try{
            ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,object.getDestination());
            ps.setString(2,object.getDate());
            ps.setString(3,object.getTime());
            ps.setInt(4,object.getFlight_id());
            int fullAirflight = ps.executeUpdate();
            if(fullAirflight ==1){
                ResultSet resultSet = ps.getGeneratedKeys();
                if(resultSet.next()){
                    object.setId(resultSet.getInt(1));
                    System.out.println(" inserted");
                    return  object;
                }

            }

            ps.close();

        }catch (SQLException e){
            System.out.println(" error "+ e.getMessage());
        }
        finally {
            try{

            }catch (Exception e){
                System.out.println(" error to close database" + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public void delete(Integer id) {

        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = "DELETE  FROM airplane_flights WHERE id = ? ";

        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1,id);
            int delet = ps.executeUpdate();
            if(delet ==1){
                System.out.println(" deleted ");
            } else{
                System.out.println("id no exist");
            }
        }catch (SQLException e){
            System.out.println(" error " + e.getMessage());
        } finally {
            try{
                Conexion.closeConnection();
            }catch (Exception e){
                System.out.println(" error clothing conexion");
            }
        }


    }

    @Override
    public List<AirFlights> read() {
        List<AirFlights> airFlights = new ArrayList<>();
    Connection connection = Conexion.getConnection();
    PreparedStatement ps;
    ResultSet resultSet;
    String query = "SELECT * FROM  airplane_flights";
    try{
      ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
      resultSet = ps.executeQuery();
      while (resultSet.next()){
          AirFlights flights = new AirFlights();
          flights.setId(resultSet.getInt("id"));
          flights.setDestination(resultSet.getString("destination"));
          flights.setDate(resultSet.getString("date_flight"));
          flights.setTime(resultSet.getString("hour_flight"));
          flights.setFlight_id(resultSet.getInt("flights_id"));
          airFlights.add(flights);
      }

    }catch (SQLException e){
        System.out.println( "error to list " + e.getMessage());
    }
    finally {
        try{
            Conexion.closeConnection();
        }catch (Exception e){
            System.out.println("Error connection " + e.getMessage());
        }
    }
    return airFlights;
    }


    @Override
    // update date
    public boolean update(AirFlights object) {

        boolean foundID = isFoundid(object.getId());
        if (foundID){
            PreparedStatement ps;
            Connection connection = Conexion.getConnection();

            String query = "UPDATE airplane_flights SET  date_flight = ? WHERE id = ?";

            try {
                ps = connection.prepareStatement(query);
                ps.setString(1, object.getDate());
                ps.setInt(2, object.getId());

                int rowsUpdated = ps.executeUpdate();

                if (rowsUpdated == 1) {
                    System.out.println("Vuelo actualizado correctamente.");
                    return true;
                } else {
                    System.out.println("id no existe.");
                    return false;
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error al actualizar el vuelo: " + e.getMessage(), e);
            } finally {
                try {
                    Conexion.closeConnection();
                } catch (Exception e) {
                    System.err.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        } else{
            System.out.println("id no encontrado");
        }
        return false;
    }

   // found id

    public  boolean isFoundid(Integer id){
        PreparedStatement preparedStatement;
        Connection connection = Conexion.getConnection();
        ResultSet resultSet;
        String query = "SELECT * FROM airplane_flights where id = ?";
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            resultSet =  preparedStatement.executeQuery();
            return resultSet.next();
        }catch (SQLException e){
            System.out.println(" error no found " + e.getMessage());
        }
        finally {
            try{
                Conexion.closeConnection();
            }catch (Exception e){
                System.out.println("error closing the conenection" + e.getMessage());
            }
        }
        return false;
    }


}

