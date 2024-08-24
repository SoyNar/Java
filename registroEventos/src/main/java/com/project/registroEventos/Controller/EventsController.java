package com.project.registroEventos.Controller;

import com.project.registroEventos.Entity.Events;
import com.project.registroEventos.Exception.NoFoundException;
import com.project.registroEventos.Service.IEventsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.NotActiveException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//http://localhost8080/api_events/
@RequestMapping("api_events")
public class EventsController {
    // mensajes a consola//
    private static  final Logger logger =
            LoggerFactory.getLogger(EventsController.class);
    // inyeccion de dependencias capa de servicio
    @Autowired
    private IEventsService eventsService;
    // peticion para ver todos los empleados

    // http://localhost:8080/api_events/allEvents

    // este metodo devuelve una lista tipo eventos
    @GetMapping("/allEvents")
    public List<Events> findEvent (){
        List<Events> listEvent = eventsService.readALl();
        // tambien se puede usar var en vez de la lista de tipo evento

        // imprimimos a consola a nivel de info
        listEvent.forEach(event -> logger.info(event.toString()));
        // usamos una expresion lambda,
        // para iterar sobre la lita que recibimos e imprimirla en consola
        return listEvent;
    }


    // metodo agregar evento
    //http://localhost8080/api_events/save//

@PostMapping("/save")
    public Events saveEvent(@RequestBody Events events){
        logger.info("evento agregar" + events);
       return this.eventsService.save(events);
       // imprimir en consola

    }

    // metodo buscar evento por id

    // http://localhost:8080/api_events/events/159d1838-8406-40c0-a7b4-1eaf8931cc88
    @GetMapping("/events/{id}")
    public ResponseEntity<Events> findEventById(@PathVariable String id){
      Events event =   eventsService.readById(id);
      if(event == null)
          throw new NoFoundException("NO FOund id :" + id);
      return ResponseEntity.ok(event);

    }

    // actualizar con el metodo PUT
    @PutMapping("/events/{id}")
    public ResponseEntity<Events> updateEvent(@PathVariable String id,
                                              @RequestBody Events event){
           Events eventy = eventsService.readById(id);
           if(event == null)
               throw new NoFoundException("NO found ID: " + id);
           eventy.setDate(event.getDate());
           eventy.setName(event.getName());
           eventy.setDate(event.getDate());
           eventy.setLocation(event.getLocation());
           eventy.setLength(event.getLength());
           // guardamos objeto actualizado
        this.eventsService.save(event);
        // devolvemos objeto event envuelto en un objeto ripo responseEntity
        return ResponseEntity.ok(eventy);
    }

    //borrar un evento

    // http://localhost:8080/api_events/events/159d1838-8406-40c0-a7b4-1eaf8931cc88
    @DeleteMapping("/events/{id}")
    public ResponseEntity<Map<String,Boolean>>
    deleteEvent(@PathVariable String id){
        Events event = this.eventsService.readById(id);
        // validacion antes de eliminar
        if(event == null)
            throw new NoFoundException((" no found id: " + id));
        this.eventsService.delete(id);
        // respuesta generada tipo json
        //{delete: true}
        Map<String, Boolean> responde = new HashMap<>();
        responde.put("Deleted", Boolean.TRUE);
        return  ResponseEntity.ok(responde);
    }


}
