package com.riwi.Persistence.IModel;

import com.riwi.Entitys.Coder;
import com.riwi.Persistence.Crud.ICread;
import com.riwi.Persistence.Crud.IDelate;
import com.riwi.Persistence.Crud.IRead;
import com.riwi.Persistence.Crud.IUpdate;

public interface ICoder extends
        ICread<Coder>,
        IDelate<Integer>,
        IRead<Coder>,
        IUpdate<Coder> {
}
