package com.nar.Controller;

import com.nar.Entity.Reservation;
import com.nar.Model.ReservationModel;
import com.nar.Persistence.IModel.IReservationModel;

import java.util.List;

public class ReservationController {
    IReservationModel iReservationModel = new ReservationModel();

    public Reservation create(Reservation reservation) {
        return this.iReservationModel.create(reservation);
    }

    public void read(Reservation reservation) {
        List<Reservation> listReservation = this.iReservationModel.read();
        listReservation.forEach(System.out::println);
    }

    public void delete(Integer id) {
        this.iReservationModel.delete(id);
    }

    public void update(Reservation reservation) {
        iReservationModel.update(reservation);
    }

    public void capacityReservation(Integer id) {
        ReservationModel reservationModel = new ReservationModel();
        System.out.println(reservationModel.getNumberReservation(id));
    }
}


