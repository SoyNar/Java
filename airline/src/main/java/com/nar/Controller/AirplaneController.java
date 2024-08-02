package com.nar.Controller;

import com.nar.Entity.Airplane;
import com.nar.Model.AirplaneModel;
import com.nar.Persistence.IModel.IAirplaneModel;

import java.util.List;

public class AirplaneController  {

   IAirplaneModel iAirplaneModel = new AirplaneModel();
    public Airplane create(Airplane objecTAirPlane){
        return this.iAirplaneModel.create(objecTAirPlane);
    }

    public  void delete(Integer typeID ){
       this.iAirplaneModel.delete(typeID);
       }

  public void read(){
// metodo listar
      List<Airplane> airplanes = iAirplaneModel.read();
      airplanes.forEach(System.out::println);

  }

  public boolean update( Airplane object){
       return  this.iAirplaneModel.update(object);
  }

}
