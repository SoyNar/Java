package com.nar.Controller;

import com.nar.Entity.Reservation;
import com.nar.Model.ReservationModel;
import com.nar.Persistence.IModel.IReservationModel;

public class ReservationController {
    IReservationModel iReservationModel = new ReservationModel();
    public Reservation create(Reservation reservation){
        return this.iReservationModel.create(reservation);
    }
}
