package com.nar.Persistence.IModel;

import com.nar.Entity.Reservation;
import com.nar.Persistence.CRUD.ICread;
import com.nar.Persistence.CRUD.IDelete;
import com.nar.Persistence.CRUD.IRead;
import com.nar.Persistence.CRUD.IUpdate;

public interface IReservationModel extends
         ICread<Reservation>
        ,IDelete<Integer>
        , IUpdate<Reservation>
        , IRead<Reservation> {

}
