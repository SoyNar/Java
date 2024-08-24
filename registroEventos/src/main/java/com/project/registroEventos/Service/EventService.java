package com.project.registroEventos.Service;

import com.project.registroEventos.Entity.Events;
import com.project.registroEventos.Repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventService implements IEventsService{

// dependencias
    @Autowired
    private IRepository repository;

    @Override
    public void delete(String id) {
        this.repository.deleteById(id);

    }
    @Override
    public List<Events> readALl() {
        return this.repository.findAll();
    }

    @Override
    public Events readById(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Events save(Events events) {
        return this.repository.save(events);
    }
}
