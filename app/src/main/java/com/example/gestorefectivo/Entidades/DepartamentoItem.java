package com.example.gestorefectivo.Entidades;

import java.io.Serializable;
import java.util.List;

public class DepartamentoItem implements Serializable {

    String nombre;
    List<RegistroItem> registros;

    //Constructores

    public DepartamentoItem() {
    }

    public DepartamentoItem(String nombre, List<RegistroItem> registros) {
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

    public List<RegistroItem> getRegistros() {
        return registros;
    }

    public void setRegistros(List<RegistroItem> registros) {
        this.registros = registros;
    }

    public double getSumatorioRegistros() {
        double sumatorio = 0;
        for (RegistroItem registro : registros) {
            sumatorio += registro.getTotalRegistro();
        }
        return sumatorio;
    }
}
