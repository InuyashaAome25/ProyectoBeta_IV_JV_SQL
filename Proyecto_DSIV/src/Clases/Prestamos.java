package Clases;

import java.time.LocalDate;

public class Prestamos {
    private String id_prestamos; //Revision tipo de dato
    private String id_Libros; //Revision tipo de dato
    private String id_Usuarios; //Revision tipo de dato
    private LocalDate fechaPrestamo; //Revision tipo de dato
    private LocalDate fechaDevolucion; //Revision tipo de dato

    public String getId_prestamos() {
        return id_prestamos;
    }

    public void setId_prestamos(String id_prestamos) {
        this.id_prestamos = id_prestamos;
    }

    public String getId_Libros() {
        return id_Libros;
    }

    public void setId_Libros(String id_Libros) {
        this.id_Libros = id_Libros;
    }

    public String getId_Usuarios() {
        return id_Usuarios;
    }

    public void setId_Usuarios(String id_Usuarios) {
        this.id_Usuarios = id_Usuarios;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
