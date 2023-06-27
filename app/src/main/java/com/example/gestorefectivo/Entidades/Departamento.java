package com.example.gestorefectivo.Entidades;

import java.io.Serializable;
import java.util.List;

public class Departamento implements Serializable {

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

    public double getSumatorioRegistros() {
        double sumatorio = 0;
        for (Registro registro : registros) {
            sumatorio += registro.getTotalRegistro();
        }
        return sumatorio;
    }
}
