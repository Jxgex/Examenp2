package com.example.examen_p2.Clases;

import java.io.Serializable;

public class Cuadros implements Serializable {
    private int Imagen_Cuadro;
    private int Imagen_Cuadro_Grande;
    private String Nombre_Cuadro;
    private String Autor_Cuadro;
    private String Descripcion_Cuadro;
    private String Fecha;

    public Cuadros(int imagen_Cuadro, int imagen_Cuadro_Grande, String nombre_Cuadro, String autor_Cuadro, String descripcion_Cuadro, String fecha) {
        Imagen_Cuadro = imagen_Cuadro;
        Imagen_Cuadro_Grande = imagen_Cuadro_Grande;
        Nombre_Cuadro = nombre_Cuadro;
        Autor_Cuadro = autor_Cuadro;
        Descripcion_Cuadro = descripcion_Cuadro;
        Fecha = fecha;
    }

    public int getImagen_Cuadro() {
        return Imagen_Cuadro;
    }

    public void setImagen_Cuadro(int imagen_Cuadro) {
        Imagen_Cuadro = imagen_Cuadro;
    }

    public int getImagen_Cuadro_Grande() {
        return Imagen_Cuadro_Grande;
    }

    public void setImagen_Cuadro_Grande(int imagen_Cuadro_Grande) {
        Imagen_Cuadro_Grande = imagen_Cuadro_Grande;
    }

    public String getNombre_Cuadro() {
        return Nombre_Cuadro;
    }

    public void setNombre_Cuadro(String nombre_Cuadro) {
        Nombre_Cuadro = nombre_Cuadro;
    }

    public String getAutor_Cuadro() {
        return Autor_Cuadro;
    }

    public void setAutor_Cuadro(String autor_Cuadro) {
        Autor_Cuadro = autor_Cuadro;
    }

    public String getDescripcion_Cuadro() {
        return Descripcion_Cuadro;
    }

    public void setDescripcion_Cuadro(String descripcion_Cuadro) {
        Descripcion_Cuadro = descripcion_Cuadro;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }
}
