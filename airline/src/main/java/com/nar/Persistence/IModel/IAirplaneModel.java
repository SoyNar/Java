package com.nar.Persistence.IModel;

import com.nar.Entity.Airplane;
import com.nar.Persistence.CRUD.ICread;
import com.nar.Persistence.CRUD.IDelete;
import com.nar.Persistence.CRUD.IRead;
import com.nar.Persistence.CRUD.IUpdate;

public interface IAirplaneModel extends
        ICread<Airplane>,
        IDelete<Integer>,
        IRead<Airplane>
        ,IUpdate<Airplane> {
}
