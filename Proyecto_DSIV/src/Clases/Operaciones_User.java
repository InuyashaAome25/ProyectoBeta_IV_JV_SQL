package Clases;

import java.sql.ResultSet;
import java.sql.Statement;

public class Operaciones_User {
    private Statement stmt;
    private ResultSet recordset;
    private int opcion, consulta;
    private String generoC, autorC, tituloC;

    public void busquedaOpc(int opc, String g, String a, String t) {
        this.opcion = opc;
        this.generoC = g;
        this.autorC = a;
        this.tituloC = t;
    }

}
