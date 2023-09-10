package Clases;

import java.time.LocalDate;

public class Libros {
    private String id_Libro; //Revision tipo de dato
    private String titulo;
    private String autor;
    private String genero;
    private String ISBN;
    private String editorial;
    private LocalDate fechaPublicacion; //Revision tipo de dato
    private int disponibilidad;

    public String getId_Libro() {
        return id_Libro;
    }

    public void setId_Libro(String id_Libro) {
        this.id_Libro = id_Libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
