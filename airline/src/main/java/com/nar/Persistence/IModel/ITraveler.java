package com.nar.Persistence.IModel;

import com.nar.Entity.Traveler;
import com.nar.Persistence.CRUD.ICread;
import com.nar.Persistence.CRUD.IDelete;
import com.nar.Persistence.CRUD.IRead;
import com.nar.Persistence.CRUD.IUpdate;

import javax.swing.table.TableRowSorter;

public interface ITraveler extends ICread<Traveler>,
        IUpdate<Traveler>, IDelete<Integer>, IRead<Traveler> {

}
