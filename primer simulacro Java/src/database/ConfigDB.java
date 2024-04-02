package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    static Connection objConnection = null;

    public static Connection openConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://bgwknmzpij1mn6vvlcsy-mysql.services.clever-cloud.com/bgwknmzpij1mn6vvlcsy";
            String user = "uyyd8ymwzuxbfezt";
            String password = "RQ3siTSmaTm2Zw9aIHnE";

            objConnection = DriverManager.getConnection(url, user, password);

            // Seleccionar la base de datos
            String dbName = "bgwknmzpij1mn6vvlcsy";
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
