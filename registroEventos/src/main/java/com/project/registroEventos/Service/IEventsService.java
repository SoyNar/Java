package com.project.registroEventos.Service;

import com.project.registroEventos.Service.CRUD.Delete;
import com.project.registroEventos.Service.CRUD.ReadAll;
import com.project.registroEventos.Service.CRUD.ReadById;
import com.project.registroEventos.Service.CRUD.Save;
import com.project.registroEventos.Entity.Events;
import org.springframework.stereotype.Service;

@Service
public interface IEventsService
        extends ReadAll<Events>,
        ReadById<Events,String>,
        Save<Events>,
        Delete<String> {

}
