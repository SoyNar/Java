package com.riwi.Model;

import com.mysql.cj.SimpleQuery;
import com.riwi.Entitys.Contratacion;
import com.riwi.Entitys.Vacante;
import com.riwi.Persistence.Conexion.Conexion;
import com.riwi.Persistence.IModel.IContratacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ContratacionModel implements IContratacion {
    @Override
    public Contratacion cread(Contratacion object) {
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = " INSERT INTO contratacion (coder_id,vacante_id) VALUES (?, ?)";
        try{
            ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1,object.getCoderId());
            ps.setInt(2,object.getVacanteId());

            int insert = ps.executeUpdate();
            if(insert > 0){
                ResultSet resultSet = ps.getGeneratedKeys();
                if(resultSet.next()){
                    object.setId(resultSet.getInt(1));
                }
            }

        }catch (SQLException e){
            System.out.println(" error to create contratacion " + e.getMessage());
        } finally {
            try{
                Conexion.closedConnection();

            }catch (Exception e){
                System.out.println(" error to close conexion" + e.getMessage());
            }
        }
        return null;
    }



    @Override
    public List<Contratacion> read() {
        return null;
    }



    @Override
    public void delete(Integer id) {

    }

    @Override
    public Contratacion update(Contratacion object) {
        return null;
    }
}
