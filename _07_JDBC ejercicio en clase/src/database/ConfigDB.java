package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    //Variable que va a contener el estado de la conexion
    static Connection objConnection = null;

    //metodo para abrir la conexion entre java y la base de datos

    public static Connection openConnection(){
        try{
            //class forname permite obtener o implementar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creamos variables con nuestras credenciales de la base de datos
            String url = "jdbc:mysql://localhost:3306/_01_jdbc_meta";
            String user = "root";
            String password= "";

            //establecemos la conexion
            objConnection = (Connection) DriverManager.getConnection(url,user,password);
            System.out.println("Me conecte perfectamente!!");

        }catch (ClassNotFoundException e){
            System.out.println("Error >> Driver no instalado");
        }catch (SQLException e){
            System.out.println("Error >>No se puedo establecer una conexion con la BaseData");
        }
        return objConnection;
    }


    public static void closedConnection(){
        try {
            //si hay una conexion activa, la cerramos
            if(objConnection !=null) objConnection.close();

        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
