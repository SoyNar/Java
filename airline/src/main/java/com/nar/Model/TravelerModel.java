package com.nar.Model;

import com.nar.Entity.Traveler;
import com.nar.Persistence.Conexion.Conexion;
import com.nar.Persistence.IModel.ITraveler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class TravelerModel implements ITraveler {
    @Override
    public Traveler create(Traveler object) {
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        ResultSet resultSet;
        String query = " INSERT INTO traveler"
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<Traveler> read() {
        return null;
    }

    @Override
    public boolean update(Traveler object) {
        return false;
    }
}
