package com.nar.Controller;

import com.nar.Entity.Traveler;
import com.nar.Model.TravelerModel;
import com.nar.Persistence.IModel.ITraveler;

import javax.swing.*;
import java.util.List;

public class TravelerController {
    ITraveler iTraveler = new TravelerModel();
    public Traveler create (Traveler traveler){
         return this.iTraveler.create(traveler);
    }

    public void read(){
        List<Traveler> lisTraverler = iTraveler.read();
         lisTraverler.forEach(System.out::println);
    }
    public  void update(Traveler traveler){
        if(this.iTraveler.update(traveler)){
            JOptionPane.showMessageDialog(null, "update");
        } else {
            JOptionPane.showMessageDialog(null,"no update");
        }
    }
}
