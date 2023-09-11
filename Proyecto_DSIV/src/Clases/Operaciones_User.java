package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;

public class Operaciones_User {
    private Statement stmt;
    private ResultSet recordset;
    private int opcion, consulta;
    private String generoC, autorC, tituloC;
    Libros objLib = new Libros();

    public void busquedaOpc(int opc, String g, String a, String t) {
        this.opcion = opc;
        this.generoC = g;
        this.autorC = a;
        this.tituloC = t;
    }

    public void setConsulta(int consulta) {
        this.consulta = consulta;
    }

    public LinkedList<Libros> busquedaCatalogo(Conexion objC) throws Exception{
        Connection cnn = null;
        String cadSQL;
        boolean registro_G = false;
        boolean registro_A = false;
        boolean registro_T = false;
        try {
            cnn = objC.establecer_Conexion();
            LinkedList<Libros> librosB = new LinkedList<>();
            stmt =cnn.createStatement();

            if (consulta ==1){
                cadSQL = "SELECT* FROM Libros";
                recordset = stmt.executeQuery(cadSQL);
                while (recordset.next()){
                    Libros objL = new Libros();
                    objL.setTitulo(recordset.getString("titulo"));
                    objL.setAutor(recordset.getString("autor"));
                    objL.setGenero(recordset.getString("genero"));
                    objL.setEditorial(recordset.getString("editorial"));
                    objL.getDisponibilidad(); //revisar para verificacion
                    objL.setISBN(recordset.getString("ISBN"));
                    librosB.add(objL);
                }
            }else {
                if (opcion ==1){
                    cadSQL = "SELECT* FROM Libros WHERE genero='" +generoC+ "'";
                    recordset = stmt.executeQuery(cadSQL);
                    registro_G = recordset.next();
                }else if(opcion ==2){
                    cadSQL = "SELECT* FROM Libros WHERE autor='" +autorC+ "'";
                    recordset = stmt.executeQuery(cadSQL);
                    registro_A = recordset.next();
                }else {
                    cadSQL = "SELECT* FROM Libros WHERE titulo='" +tituloC+ "'";
                    recordset = stmt.executeQuery(cadSQL);
                    registro_T = recordset.next();
                }

                if (registro_G){
                    do {
                        objLib.setGenero(recordset.getString("genero"));
                        objLib.setTitulo(recordset.getString("titulo"));
                        objLib.setAutor(recordset.getString("autor"));
                        objLib.setEditorial(recordset.getString("editorial"));
                        objLib.setFechaPublicacion(LocalDate.parse(recordset.getString("fechaPubiacion")));
                        objLib.setISBN(recordset.getString("ISBN"));
                        librosB.add(objLib);
                    }while (recordset.next());
                }else if(registro_A){
                    do {
                        objLib.setAutor(recordset.getString("autor"));
                        objLib.setTitulo(recordset.getString("titulo"));
                        objLib.setGenero(recordset.getString("genero"));
                        objLib.setEditorial(recordset.getString("editorial"));
                        objLib.setFechaPublicacion(LocalDate.parse(recordset.getString("fechaPubiacion")));
                        objLib.setISBN(recordset.getString("ISBN"));
                        librosB.add(objLib);
                    }while (recordset.next());
                }else if (registro_T){
                    do {
                        objLib.setTitulo(recordset.getString("titulo"));
                        objLib.setAutor(recordset.getString("autor"));
                        objLib.setGenero(recordset.getString("genero"));
                        objLib.setEditorial(recordset.getString("editorial"));
                        objLib.setFechaPublicacion(LocalDate.parse(recordset.getString("fechaPubiacion")));
                        objLib.setISBN(recordset.getString("ISBN"));
                        librosB.add(objLib);
                    }while (recordset.next());
                }else {
                    cnn.close();
                    throw new Exception("No se ha podido encontrar la busqueda realizada");
                }
                cnn.close();
            }
            return librosB;
        } catch (SQLException e){
            cnn.close();
            throw new Exception("Error en la busqueda");
        }
    }
    public boolean verificarIDUsuario(String ID, Conexion objC) throws Exception{
        Connection cnn= objC.establecer_Conexion();
        stmt = cnn.createStatement();
        String cadSQL;
        try {
            cadSQL ="SELECT* FROM Usuarios WHERE id_usuario = " +ID+ "'";
            recordset = stmt.executeQuery(cadSQL);
            boolean registroU = recordset.next();
            cnn.close();
            return registroU;
        }catch (SQLException e){
            cnn.close();
            throw new Exception("Usted ya se encuentra registrado ");
        }
    }
    public void registroUsuario(Usuarios objU, Conexion objC) throws Exception{
        Connection cnn = objC.establecer_Conexion();
        stmt = cnn.createStatement();
        String cadSQL;
        String cadSQL2;
        String cadSQL3;
        Correo_Usuarios objCE = new Correo_Usuarios();
        Telefonos_Usuarios objTU = new Telefonos_Usuarios();

        try {
            cadSQL ="INSERT INTO Usuarios (id_usuario, nombre, apellido, dirrecion) VALUES ('" +objU.getId_Usuario()
                    + "','" +objU.getNombre() + "','" +objU.getApellido() + "','" +objU.getDirreccion() +"')";
            cadSQL2 ="INSERT INTO Correo_Usuarios (id_correo, correoElectronico) VALUES ('" + objCE.getId_Correo()
                    + "','" +objCE.getCorreoElectronicoU() +"')";
            cadSQL3 ="INSERT INTO Telefonos_Usuarios VALUES (id_telefono, telefonoU) ('" +objTU.getId_Telefono()
                    + "','" +objTU.getTelefonoU() +"')";
            stmt.executeUpdate(cadSQL);
            stmt.executeUpdate(cadSQL2);
            stmt.executeUpdate(cadSQL3);
            cnn.close();
        } catch (SQLException e){
            cnn.close();
            throw new Exception("No se ha podido realizar el registro");
        }
    }
}
