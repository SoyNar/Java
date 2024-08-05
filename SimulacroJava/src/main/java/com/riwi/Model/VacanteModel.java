package com.riwi.Model;

import com.riwi.Entitys.Vacante;
import com.riwi.Persistence.Conexion.Conexion;
import com.riwi.Persistence.IModel.IVacante;
import com.riwi.Persistence.Until.Estado;

import java.security.spec.ECField;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacanteModel implements IVacante {
    @Override
    public Vacante cread(Vacante object) {
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = " INSERT INTO vacante (titulo,estado,salacio,descripcion,tecnologia,empresa_id) VALUES(?, ?, ?, ?, ?, ?)";

        try{
            ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,object.getTitulo());
            ps.setInt(2,object.getStatus().ordinal());
            ps.setDouble(3,object.getSalario());
            ps.setString(4,object.getDescripcion());
            ps.setString(5,object.getTecnologia());
            ps.setInt(6,object.getEmpresaID());

            int create = ps.executeUpdate();
            if(create == 1){
                ResultSet resultSet = ps.getGeneratedKeys();
                if(resultSet.next()){
                    System.out.println(" created");
                    object.setId(resultSet.getInt(1));
                }
            }

        }catch (SQLException e){
            System.out.println(" error to insert vacante" + e.getMessage());
        }finally {
            try {
                Conexion.closedConnection();
            }catch (Exception e){
                System.out.println(" error to closed conexion" + e.getMessage());
            }
        }

        return null;
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = "DELETE FROM vacante WHERE id = ? ";
        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1,id);
            int delete = ps.executeUpdate();
            if( delete > 0){
                System.out.println(" deleted");
            } else {
                System.out.println(" id no found");
            }
        }catch ( SQLException e){
            System.out.println(" erro to delete " + e.getMessage());
        }

    }

    @Override
    public List<Vacante> read() {

        List<Vacante> listVacante = new ArrayList<>();
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = "SELECT * FROM vacante";
        try{
            ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Vacante vacante = new Vacante();
                vacante.setId(resultSet.getInt("id"));
                vacante.setTitulo(resultSet.getString("titulo"));
                vacante.setDescripcion(resultSet.getString("descripcion"));
                vacante.setSalario(resultSet.getDouble("salario"));
                vacante.setTecnologia(resultSet.getString("tecnologia"));
                int status = resultSet.getInt("estado");
                Estado estado = Estado.values()[status];
                vacante.setStatus(estado);
                vacante.setEmpresaID(resultSet.getInt("empresa_id"));
                listVacante.add(vacante);
            }
        }catch (SQLException e){
            System.out.println(" error to read vacante " + e.getMessage());
        }finally {
            try{
                Conexion.closedConnection();

            }catch (Exception e){
                System.out.println(" error closed to conexion " + e.getMessage());
            }
        }
        return listVacante;
    }

    @Override
    public Vacante update(Vacante object) {
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query= "UPDATE vacante SET titulo = ?, descripcion = ?, salario = ?, tecnologia = ?, estado = ?, empresa_id = ? WHERE id = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,object.getTitulo());
            ps.setString(2,object.getDescripcion());
            ps.setDouble(3,object.getSalario());
            ps.setString(4,object.getTecnologia());
            ps.setString(5,object.getStatus().name());
            ps.setInt(6,object.getEmpresaID());
            ps.setInt(7,object.getId());

            int update = ps.executeUpdate();
            if(update > 0){
                System.out.println(" update ");
            }

        }catch (SQLException e){
            System.out.println("no  update " + e.getMessage());
        } finally {
            try{
                Conexion.closedConnection();
            }catch (Exception e){
                System.out.println(" error closed connection " + e.getMessage());
            }
        }
        return null;
    }
}
