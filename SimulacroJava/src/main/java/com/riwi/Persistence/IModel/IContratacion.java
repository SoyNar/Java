package com.riwi.Persistence.IModel;

import com.riwi.Entitys.Contratacion;
import com.riwi.Entitys.Vacante;
import com.riwi.Persistence.Crud.ICread;
import com.riwi.Persistence.Crud.IDelate;
import com.riwi.Persistence.Crud.IRead;
import com.riwi.Persistence.Crud.IUpdate;

public interface IContratacion extends
                    ICread<Contratacion>,
                     IRead<Contratacion>,
                     IDelate<Integer>,
                     IUpdate<Contratacion> {
}
