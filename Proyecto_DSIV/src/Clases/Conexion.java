package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    protected String user;
    protected String password;
    protected Connection cnn;

    public Conexion(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Connection establecer_Conexion() throws Exception{
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-469NVCC0:1433;database=BIBLIOTECAGESTBD;" +
                    "user=" +user+ ";password=" +password+ ";encryt=false");
            return cnn;
        }catch (SQLException e){
            throw new Exception("\nError NO se pudo realizar la conexion");
        }catch (ClassNotFoundException e){
            throw new Exception("\nError programa" +e+ "\t->Error<- No se pudo realizar la carga del Driver puente jdbc-odbc");
        }
    }
}