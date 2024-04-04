package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    static Connection objConnection = null;

    public static Connection openConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://bf6lbprv5e6bstfdpqps-mysql.services.clever-cloud.com/bf6lbprv5e6bstfdpqps";
            String user = "uj8zw2z9iajjjkzp";
            String password = "AR4seR2v7SkvslQWGbu1";

            objConnection = DriverManager.getConnection(url, user, password);

            // Seleccionar la base de datos
            String dbName = "bf6lbprv5e6bstfdpqps";
            objConnection.setCatalog(dbName);

            System.out.println("Conexión exitosa!!");

        } catch (ClassNotFoundException e) {
            System.out.println("error: driver no encontrado");
        } catch (SQLException e) {
            System.out.println("error con la conexion a la base de datos");
        }
        return objConnection;
    }



    public static void closedConnection(){
        try {
            if(objConnection !=null) objConnection.close();

        }catch (SQLException e){
            System.out.println("error: "+e.getMessage());
        }
    }
}