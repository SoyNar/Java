package com.riwi.Controller;

import com.riwi.Entitys.Coder;
import com.riwi.Model.CoderModel;
import com.riwi.Persistence.IModel.ICoder;

import java.util.List;

public class CoderController {
    ICoder iCoder = new CoderModel();
    public Coder create(Coder coder){
        return this.iCoder.cread(coder);

    }

    public void read (){
        List<Coder> listaCoder  = this.iCoder.read();
        listaCoder.forEach(System.out::println);
    }

    public void update (Coder coder){
        this.iCoder.update(coder);
    }

  public  void delete(int id){
        this.iCoder.delete(id);
  }



}
