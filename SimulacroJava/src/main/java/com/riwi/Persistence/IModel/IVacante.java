package com.riwi.Persistence.IModel;

import com.riwi.Entitys.Vacante;
import com.riwi.Persistence.Crud.ICread;
import com.riwi.Persistence.Crud.IDelate;
import com.riwi.Persistence.Crud.IRead;
import com.riwi.Persistence.Crud.IUpdate;

public interface IVacante extends
        ICread<Vacante>,
        IRead<Vacante>,
        IUpdate<Vacante>,
        IDelate<Integer> {
}
