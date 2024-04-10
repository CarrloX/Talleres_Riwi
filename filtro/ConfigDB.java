package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    static Connection objConnection = null;

    public static Connection openConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1/simulacro";
            String user = "root";
            String password = "Rlwl2023.";

            objConnection = DriverManager.getConnection(url, user, password);

            String dbName = "simulacro";
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