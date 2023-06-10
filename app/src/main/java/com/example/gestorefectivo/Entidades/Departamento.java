package com.example.gestorefectivo.Entidades;

import java.util.List;

public class Departamento {

    String nombre;
    List<Registro> registros;

    //Constructores

    public Departamento() {
    }

    public Departamento(String nombre, List<Registro> registros) {
        this.nombre = nombre;
        this.registros = registros;
    }

    //Getters y Setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }
}
