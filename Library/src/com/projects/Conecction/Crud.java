package com.projects.Conecction;

import java.util.ArrayList;
import java.util.List;

public interface Crud {
    //methodsOfUse

    List<Object> list();
    boolean insert(Object object);
    boolean findByid(Object object);
    boolean delete(Object object);
    boolean edit(Object object);
}
