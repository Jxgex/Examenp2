package com.example.examen_p2.Clases;

import java.io.Serializable;

public class Usuario implements Serializable {
    String Nombre;
    String Apellido_Paterno;
    String Apellido_Materno;
    String Numero_Telefono;
    char Sexo;
    int Edad;
    public Usuario(){}
    public Usuario(String nombre, String apellido_Paterno, String apellido_Materno, String numero_Telefono, char sexo, int edad) {
        Nombre = nombre;
        Apellido_Paterno = apellido_Paterno;
        Apellido_Materno = apellido_Materno;
        Numero_Telefono = numero_Telefono;
        Sexo = sexo;
        Edad = edad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido_Paterno() {
        return Apellido_Paterno;
    }

    public void setApellido_Paterno(String apellido_Paterno) {
        Apellido_Paterno = apellido_Paterno;
    }

    public String getApellido_Materno() {
        return Apellido_Materno;
    }

    public void setApellido_Materno(String apellido_Materno) {
        Apellido_Materno = apellido_Materno;
    }

    public String getNumero_Telefono() {
        return Numero_Telefono;
    }

    public void setNumero_Telefono(String numero_Telefono) {
        Numero_Telefono = numero_Telefono;
    }

    public char getSexo() {
        return Sexo;
    }

    public void setSexo(char sexo) {
        Sexo = sexo;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }
}
