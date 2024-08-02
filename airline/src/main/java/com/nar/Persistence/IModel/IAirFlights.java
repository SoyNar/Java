package com.nar.Persistence.IModel;

import com.nar.Entity.AirFlights;
import com.nar.Entity.Airplane;
import com.nar.Persistence.CRUD.ICread;
import com.nar.Persistence.CRUD.IDelete;
import com.nar.Persistence.CRUD.IRead;
import com.nar.Persistence.CRUD.IUpdate;

public interface IAirFlights extends ICread<AirFlights>,
        IRead<AirFlights>,
        IUpdate<AirFlights>,
        IDelete<Integer> {

}
