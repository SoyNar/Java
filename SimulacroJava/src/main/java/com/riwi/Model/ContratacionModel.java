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
import java.util.ArrayList;
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
        List<Contratacion> listaContratacion = new ArrayList<>();
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = " SELECT * FROM contratacion";

        try{
            ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                Contratacion contratacion = new Contratacion();
                contratacion.setId(resultSet.getInt("id"));
                contratacion.setCoderId(resultSet.getInt("coder_id"));
                contratacion.setVacanteId(resultSet.getInt("vacante_id"));
                listaContratacion.add(contratacion);
            }
        }catch (SQLException e){
            System.out.println(" erro read contratacion " + e.getMessage());
        }finally {
            try{
                Conexion.closedConnection();
            }catch (Exception e){
                System.out.println(" error closed to conexion");
            }
        }
        return listaContratacion;
    }



    @Override
    public void delete(Integer id) {
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = "DELETE FROM contratacion WHERE id = ?";

        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1,id);
            int resultSet = ps.executeUpdate();
            if(resultSet == 1){
                System.out.println("deelte");
            } else{
                System.out.println("no found empresa");
            }

        }catch (SQLException e){
            System.out.println(" error to delete contratacion" + e.getMessage());
        }
        finally {
            try {
                Conexion.closedConnection();
            } catch (Exception e) {
                System.out.println(" error to closed connection " + e.getMessage());
            }
        }

    }

    @Override
    public Contratacion update(Contratacion object) {

        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = "UPDATE contratacion SET coder_id, vacante_id  = ? WHERE id = ?";

        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1,object.getCoderId());
            ps.setInt(2,object.getVacanteId());
            int update = ps.executeUpdate();
            if(update ==1){
                System.out.println(" actualizado");

            }else{
                System.out.println("id no existe");
            }
        }catch (SQLException e){
            System.out.println("Error to update empresa" + e.getMessage());
        }finally {
            try{
                Conexion.closedConnection();
            }catch (Exception e){
                System.out.println("error to closed connection " + e.getMessage());
            }
        }

        return null;
    }
}
