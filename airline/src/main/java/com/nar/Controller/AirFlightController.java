package com.nar.Controller;

import com.nar.Entity.AirFlights;
import com.nar.Model.AirFlightModel;
import com.nar.Persistence.IModel.IAirFlights;

import java.util.ArrayList;
import java.util.List;

public class AirFlightController {
    IAirFlights iAirFlights = new AirFlightModel();
    public void  create(AirFlights airFlights){
        this.iAirFlights.create(airFlights);

    }

    public void read(){
        List<AirFlights> listAriflight = iAirFlights.read();
        listAriflight.forEach(System.out::println);
    }

    public void  update(AirFlights airFlight){
        iAirFlights.update(airFlight);
    }

    public void delete( Integer id){
        iAirFlights.delete(id);
    }
}
