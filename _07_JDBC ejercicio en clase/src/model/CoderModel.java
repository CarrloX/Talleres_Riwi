package model;

import database.CRUD;
import database.ConfigDB;
import entity.Coder;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoderModel implements CRUD {

    @Override
    public Object insert(Object object) {
        //1.abrir la connexion
        Connection objConnection = ConfigDB.openConnection();
        //2.castear el objeto
        Coder objCoder = (Coder) object;

        try{
            //3.crear el SQL
            String sql = "INSERT INTO coder(name,age,clan) VALUES(?,?,?);";
            //4.Prepara el statement
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            //5. Asignar los signos de interrogation

            objPrepare.setString(1,objCoder.getName());
            objPrepare.setInt(2,objCoder.getAge());
            objPrepare.setString(3,objCoder.getClan());

            //6. Ejecutamos el query
            objPrepare.execute();

            //7. Obtener el resultado
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()){
                objCoder.setId(objResult.getInt(1));
            }
            //8.cerramos el prepare statement
            objPrepare.close();
            JOptionPane.showMessageDialog(null,"Coder insertion was sucessful.");

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error adding Coder"+e.getMessage());
        }
        //9.cerramos la connexion
        ConfigDB.closedConnection();
        return objCoder;
    }

    @Override
    public boolean update(Object object) {
        //1.abrir la conexion
        Connection objConnection = ConfigDB.openConnection();
        //2.convertir el objeto
        Coder objCoder =(Coder)object;
        //3.varibale bandera para saber si se actualizo
        boolean isUpdated=false;

        try{
            //4. creamos la sentencia SQL

            String sql = "UPDATE coder SET name =?,age =?,clan=? where id=?;";

            //5.creamos o preparamos el statement

            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            //6. Dar valor a los?, parametros de query

            objPrepare.setString(1,objCoder.getName());
            objPrepare.setInt(2,objCoder.getAge());
            objPrepare.setString(3,objCoder.getClan());
            objPrepare.setInt(4,objCoder.getId());

            //7. Ejecutamos el query
            int rowAffected = objPrepare.executeUpdate();
            if (rowAffected > 0){
                isUpdated = true;
                JOptionPane.showMessageDialog(null,"the update was sucessful.");
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }finally {
            //8.cerrar la conexion
            ConfigDB.closedConnection();
        }

        return isUpdated;
    }

    @Override
    public boolean delete(Object object) {

        //1. Convertir el objeto a la entidad
        Coder objCoder = (Coder)object;

        //2. variable booleana para medir el estado de la eliminación
        boolean isDelete = false;

        //3. abrir la connexion
        Connection objConnection = ConfigDB.openConnection();

        try{
            //4.escribir la sentencia sql
            String sql = "DELETE FROM coder WHERE coder.id = ?;";

            //5.preparamos el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            //6.asignamos el valor al?
            objPrepare.setInt(1,objCoder.getId());

            //7.executeUpdate devuelve la cantidad de filas afectadas por la sentencia SQL ejecutada
            int totalAffectedRows = objPrepare.executeUpdate();

            if (totalAffectedRows>0){
                isDelete = true;
                JOptionPane.showMessageDialog(null,"The delete was sucessful");
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        //8.cerramos la connexion
            ConfigDB.closedConnection();

        return isDelete;
    }

    public ArrayList<Object> getByName(Object object){
        Coder objCoder = (Coder)object;
        Connection objConnection = ConfigDB.openConnection();
        ArrayList<Object> listaCoincidencias = new ArrayList<>();
        try{
            String sql = "SELECT * FROM coder where coder.name = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1,objCoder.getName());
            String totalAffectedRows = String.valueOf(objPrepare.executeUpdate());
            ResultSet objResult= objPrepare.executeQuery();

            while (objResult.next()){
                objCoder = new Coder();
                objCoder.setId(objResult.getInt("id"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setClan(objResult.getString("clan"));
                objCoder.setAge(objResult.getInt("age"));
                listaCoincidencias.add(objCoder);
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
            return null;
        }

        ConfigDB.closedConnection();

        return listaCoincidencias;
    }
    @Override
    public List<Object> findAll() {
        //1.abrir la connexion
        Connection objConnection = ConfigDB.openConnection();
        //2.inicializar la lista donde se guardaran los registros de la BD
        List<Object> listCoders = new ArrayList<>();

        try{
            //3. Escribir la secuencia SQL
            String sql = "SELECT * FROM coder ORDER BY coder.id ASC;";

            //4.utilizar prepareStatement
            PreparedStatement objPrepareStatement = objConnection.prepareStatement(sql);

            //5. Ejecutar el query o el prepare
            ResultSet objResult =(ResultSet) objPrepareStatement.executeQuery();

            //6. obtener los resultados
            while (objResult.next()){
                //creamos una instancia de coder
                Coder objCoder = new Coder();

                //llenamos nuestro objeto con lo que devuelve la BD (resultset)
                objCoder.setId(objResult.getInt("id"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setAge(objResult.getInt("age"));
                objCoder.setClan(objResult.getString("clan"));

                // Finalmente agregamos el coder a la lista
                listCoders.add(objCoder);
            }

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Data acquisition Error");
        }

        //7. Cerramos la conexión

        ConfigDB.closedConnection();

        return listCoders;
    }

    @Override
    public Object findById(int id) {
        //1. Abrir la conexión
        Connection objConnection = ConfigDB.openConnection();
        Coder objCoder = null;

        try{
            //2.sentencia SQL
            String sql = "SELECT * FROM coder WHERE id = ?;";
            //3.preparar el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            //4.damos el valor al ?
            objPrepare.setInt(1,id);
            //5. Ejecutamos el query
            ResultSet objResult = objPrepare.executeQuery();

            //6.Mientras haya un registro siguiente entonces
            while (objResult.next()){
                objCoder = new Coder();
                objCoder.setId(objResult.getInt("id"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setClan(objResult.getString("clan"));
                objCoder.setAge(objResult.getInt("age"));
            }


        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        //7.Cerramos la conexion

        ConfigDB.closedConnection();

        return objCoder;
    }
}
