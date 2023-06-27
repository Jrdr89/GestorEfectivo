package com.example.gestorefectivo.Entidades;

import java.io.Serializable;
import java.util.List;

public class Proyecto implements Serializable {
    String nombre;
    String codigo;
    List<Departamento> departamentos;
    Double efectivoEntregado;
    Double liquidacion;


    //Constructores

    public Proyecto() {
    }

    public Proyecto(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public Proyecto(String nombre, String codigo, List<Departamento> departamentos, Double efectivoEntregado, Double liquidacion) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.departamentos = departamentos;
        this.efectivoEntregado = efectivoEntregado;
        this.liquidacion = liquidacion;
    }


    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public Double getEfectivoEntregado() {
        return efectivoEntregado;
    }

    public void setEfectivoEntregado(Double efectivoEntregado) {
        this.efectivoEntregado = efectivoEntregado;
    }

    public Double getLiquidacion() {
        return liquidacion;
    }

    public void setLiquidacion(Double liquidacion) {
        this.liquidacion = liquidacion;
    }
}
