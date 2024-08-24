package com.project.registroEventos.Service.CRUD;

public interface ReadById <Entity,TypeID>{
    public Entity readById(TypeID id);
}
