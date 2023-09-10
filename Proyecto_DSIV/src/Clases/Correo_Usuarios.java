package Clases;

public class Correo_Usuarios extends Usuarios{
    private String Id_Correo;
    private String correoElectronicoU;

    public String getId_Correo() {
        return Id_Correo;
    }

    public void setId_Correo(String id_Correo) {
        Id_Correo = id_Correo;
    }

    public String getCorreoElectronicoU() {
        return correoElectronicoU;
    }

    public void setCorreoElectronicoU(String correoElectronicoU) {
        this.correoElectronicoU = correoElectronicoU;
    }
}
