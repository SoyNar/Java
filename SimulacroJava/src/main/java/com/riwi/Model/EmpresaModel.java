package com.riwi.Model;

import com.riwi.Entitys.Empresa;
import com.riwi.Persistence.Conexion.Conexion;
import com.riwi.Persistence.IModel.IEmpresa;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaModel implements IEmpresa {
    @Override
    public Empresa cread(Empresa object) {
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = " INSERT INTO  empresa (name_empresa,ubicacion) VALUES (?, ?)";
        try{
            ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,object.getName());
            ps.setString(2,object.getUbicacion());

            int insert = ps.executeUpdate();
            if(insert == 1){
                ResultSet resultSet = ps.getGeneratedKeys();
                if(resultSet.next()){
                    object.setId(resultSet.getInt(1));
                    JOptionPane.showMessageDialog(null,"inserted");
                    return object;
                }

            }
            ps.close();
        }catch (SQLException e){
            System.out.println(" error to create empresa " + e.getMessage());

        } finally {
            try{
                Conexion.closedConnection();
            }catch (Exception e){
                System.out.println(" error closed connection " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
      PreparedStatement ps;
      Connection connection = Conexion.getConnection();
      String query = "DELETE FROM empresa WHERE id = ?";

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
          System.out.println(" error to delete empresa" + e.getMessage());
      }
      finally {
          try{
              Conexion.closedConnection();
          }catch (Exception e){
              System.out.println(" error to closed connection " + e.getMessage());
          }
      }
    }

    @Override
    public List<Empresa> read() {
        List<Empresa> ListaEmpresas = new ArrayList<>();

        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = " SELECT * FROM empresa";

        try{
            ps  = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                Empresa empresa = new Empresa();
                empresa.setId(resultSet.getInt("id"));
                empresa.setName(resultSet.getString("name_empresa"));
                empresa.setUbicacion(resultSet.getString("ubicacion"));
                ListaEmpresas.add(empresa);
            }

        }catch (SQLException e){
            System.out.println(" errror to read empresa " + e.getMessage());
        }
        finally {
            try{
                Conexion.closedConnection();

            }catch (Exception e){
                System.out.println(" error closed connection " + e.getMessage());
            }
        }
        return ListaEmpresas;
    }

    @Override
    public Empresa update(Empresa object) {
      PreparedStatement ps;
      Connection connection = Conexion.getConnection();
      String query = "UPDATE empresa SET name_empresa  = ? WHERE id = ?";

      try{
          ps = connection.prepareStatement(query);
          ps.setString(1,object.getName());
          ps.setInt(2,object.getId());
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
