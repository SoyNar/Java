package com.riwi.Model;

import com.riwi.Entitys.Coder;
import com.riwi.Persistence.Conexion.Conexion;
import com.riwi.Persistence.IModel.ICoder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoderModel implements ICoder {
    @Override
    public Coder cread(Coder object) {
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = " INSERT INTO coder (name_coder, apellido,tecnologia,clan,cohorte,documento) VALUES (?, ?, ? , ?, ?, ?)";
        try{
            ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,object.getName());
            ps.setString(2, object.getLastname());
            ps.setString(3,object.getTecnology());
            ps.setString(4,object.getClan());
            ps.setString(5,object.getCohorte());
            ps.setString(6,object.getIdDocument());

            int insert = ps.executeUpdate();
            if(insert == 1){
                ResultSet resultSet = ps.getGeneratedKeys();
                if(resultSet.next()){
                 object.setId(resultSet.getInt(1));
                    System.out.println("create ");
                }
            }
        }catch (SQLException e){
            System.out.println("error create coder " + e.getMessage());
        }
        return object;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<Coder> read() {
        List<Coder> listaCoders = new ArrayList<>();
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = " SELECT * FROM coder";

        try{
            ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                Coder coderNuevo =  new Coder();
                coderNuevo.setId(resultSet.getInt("id"));
                coderNuevo.setName(resultSet.getString("name_coder"));
                coderNuevo.setLastname(resultSet.getString("apellido"));
                coderNuevo.setClan(resultSet.getString("clan"));
                coderNuevo.setCohorte(resultSet.getString("cohorte"));
                coderNuevo.setTecnology(resultSet.getString("tecnologia"));
                coderNuevo.setTecnology(resultSet.getString("documento"));
                listaCoders.add(coderNuevo);
            }
        }catch (SQLException e){
            System.out.println(" error to read coder " + e.getMessage());
        }
        return listaCoders;
    }

    @Override
    public Coder update(Coder object) {

        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = " UPDATE coder SET name_coder = ? , apellido = ? , clan = ? WHERE id = ?";

        try{
            ps = connection.prepareStatement(query);
            ps.setString(1,object.getName());
            ps.setString(2, object.getLastname());
            ps.setString(3,object.getClan());
            int update = ps.executeUpdate();

            if(update == 1 ){
                System.out.println("actualizado");
                return  object;
            } else{
                System.out.println(" id no encontrado");
            }
        }catch (SQLException e){
            System.out.println(" error to update coder " + e.getMessage());
        } finally {
            try{
                Conexion.closedConnection();
            }catch (Exception e){
                System.out.println( " error to closed connection " + e.getMessage());
            }
        }
        return null;
    }
}
