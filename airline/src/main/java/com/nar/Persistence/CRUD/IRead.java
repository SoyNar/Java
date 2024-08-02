package com.nar.Persistence.CRUD;

import java.util.List;

public interface IRead<Entity> {
    public List<Entity> read();
}
