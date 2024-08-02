package com.nar.Model;

import com.nar.Entity.Reservation;
import com.nar.Persistence.Conexion.Conexion;
import com.nar.Persistence.IModel.IReservationModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReservationModel implements IReservationModel {
    @Override
    public Reservation create(Reservation object) {
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        ResultSet resultSet;
// validate passenger availability

        String query = "SELECT COUNT(*) FROM reservation WHERE traveler_id = ? AND flight_id = ?";
        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1,object.getTravlerId());
            ps.setInt(2, object.getFlightId());
            resultSet = ps.executeQuery();
            resultSet.next();
            int checkAvailability = resultSet.getInt(1);
            if(checkAvailability >0){
                System.out.println("passenger already has reservations ");
            }
            String query2 = "SELECT COUNT(*) FROM reservation WHERE flight_id = ? AND seatNumber = ? ";
            ps.setInt(1, object.getFlightId());
            ps.setInt(2,object.getSeatNumber());
            resultSet.next();
            int seatNoAvaliable = resultSet.getInt(1);
            if(seatNoAvaliable >0){
                System.out.println("seat already has reservation");
                return null;

            }

            String query3 = "INSERT INTO reservation (seatNumber,flight_id,traveler_id) VALUES (?, ?, ?)";
            ps = connection.prepareStatement(query3,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1,object.getFlightId());
            ps.setInt(2,object.getSeatNumber());
              ps.setInt(3, object.getTravlerId());

            ps.execute();


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
    public void delete(Integer integer) {

    }

    @Override
    public List<Reservation> read() {
        return null;
    }

    @Override
    public boolean update(Reservation object) {
        return false;
    }
}
