package com.riwi.Persistence.IModel;

import com.riwi.Entitys.Empresa;
import com.riwi.Persistence.Crud.ICread;
import com.riwi.Persistence.Crud.IDelate;
import com.riwi.Persistence.Crud.IRead;
import com.riwi.Persistence.Crud.IUpdate;

public interface IEmpresa extends ICread<Empresa>, IRead<Empresa>
, IUpdate<Empresa>, IDelate<Integer> {
}
