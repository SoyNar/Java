package com.project.registroEventos.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoFoundException extends  RuntimeException{
    public NoFoundException(String mensaje){
        super(mensaje);
    }
}
