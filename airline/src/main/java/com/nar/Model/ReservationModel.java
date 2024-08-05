package com.nar.Model;

import com.nar.Entity.Airplane;
import com.nar.Entity.Reservation;
import com.nar.Persistence.Conexion.Conexion;
import com.nar.Persistence.IModel.IReservationModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationModel implements IReservationModel {
    @Override
    public Reservation create(Reservation object) {
     Airplane airplane = new Airplane();


        boolean ocuppied = ocuppiedSeat(object.getSeatNumber(), object.getFlightId());


        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        ResultSet resultSet;

        if(ocuppied){
            System.out.println(" asiento ocupado");
            return null;
        }
        if(getNumberReservation(object.getId()) >= airplane.getLenght()){
            System.out.println("capacidad maxima");
            return null;
        }
        
        try{
            String query3 = "INSERT INTO reservation (seatNumber,flight_id,traveler_id) VALUES (?, ?, ?)";
            ps = connection.prepareStatement(query3,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1,object.getSeatNumber());
            ps.setInt(2,object.getFlightId());
            ps.setInt(3, object.getTravlerId());

            ps.executeUpdate();
            ResultSet resultSet1 = ps.getGeneratedKeys();
            if (resultSet1.next()) {
                object.setId(resultSet1.getInt(1));
            }

            ps.close();
            System.out.println("Resserva creada");

        }catch (SQLException e){
            System.out.println(" error no create" + e.getMessage());
        }
        finally {
            try{
                Conexion.closeConnection();
            }catch (Exception e){
                System.out.println( " error to closing connection" + e.getMessage());
            }
        }

        return object;
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = "DELETE FROM reservation WHERE id = ?";
        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1,id);
           int delete =  ps.executeUpdate();
           if(delete > 0){
               System.out.println("deleted");
           }else{
               System.out.println(" id no found");
           }

        }catch (SQLException e){
            System.out.println(" error delete reservation " + e.getMessage());
        }
        finally {
            try{
                Conexion.closeConnection();
            }catch (Exception e){
                System.out.println("erro closed conexion " + e.getMessage());
            }
        }

    }

    @Override
    public List<Reservation> read() {
        List<Reservation> listReservation = new ArrayList<>();
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = "SELECT * FROM reservation";
        try{
            ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Reservation reservation = new Reservation();
                reservation.setId(resultSet.getInt("id"));
                reservation.setSeatNumber(resultSet.getInt("seatNumber"));
                reservation.setFlightId(resultSet.getInt("flight_id"));
                reservation.setTravlerId(resultSet.getInt("traveler_id"));
                listReservation.add(reservation);
            }
        }catch (SQLException e){
            System.out.println(" error to red reservation " + e.getMessage());
        }

        return listReservation;
    }
// method update
    @Override
    public boolean update(Reservation object) {
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String  query = " UPDATE reservation SET seatNumber = ?,flight_id = ?, traveler_id = ? WHERE idi = ? ";
        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1,object.getSeatNumber());
            ps.setInt(2,object.getFlightId());
            ps.setInt(3,object.getTravlerId());
            ps.setInt(4, object.getId());

            int update = ps.executeUpdate();
            if(update > 0){
                System.out.println(" updated");
            }else {
                System.out.println(" id no found");
            }

        }catch (SQLException e){
            System.out.println(" error to update elemnt " + e.getMessage());
        }finally {
            try{
                Conexion.closeConnection();
            }catch (Exception e){
                System.out.println("error to closed conexion " + e.getMessage());
            }
        }
        return false;
    }


    // validation seat occupied
    public boolean ocuppiedSeat(int numberSeat, int numberFilgth) {

        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = "SELECT COUNT(*) FROM reservation WHERE seatNumber = ? AND flight_id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, numberSeat);
            ps.setInt(2,numberFilgth);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1)>0;
            }
        } catch (SQLException e) {
            System.out.println(" error to select element " + e.getMessage());
        }
                Conexion.closeConnection();
        return  false;
    }

    public int getNumberReservation(int id)  {
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();

        String query = "SELECT COUNT(*)  total FROM reservation WHERE flight_id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt("total");
            }

        }catch (SQLException e){
            System.out.println(" error connect db " + e.getMessage());
        }
        Conexion.closeConnection();

        return 0;
    }

}
