package com.example.gestorefectivo.Entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class GeneradorDatos {

    private static final String[] DEPARTAMENTOS = {
            "Maquillaje y Peluquería",
            "Vestuario",
            "Departamento de Arte",
            "Departamento de Cámara, Maquinista y Luz",
            "Sonido",
            "Home Economist y Especialista de Producto",
            "Animales de escena",
            "Técnicos de Vehículo",
            "Cámara-Car y Vehículo con brazo articulado",
            "Técnicos de Efectos Especiales"
    };

    public static List<Proyecto> generarProyectos() {
        List<Proyecto> proyectos = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            Proyecto proyecto = new Proyecto();
            proyecto.setNombre("Proyecto " + i);
            proyecto.setCodigo("COD" + i);
            proyecto.setDepartamentos(generarDepartamentos());
            proyecto.setEfectivoEntregado(generarNumeroAleatorio(1000, 10000));
            proyecto.setLiquidacion(generarNumeroAleatorio(100, 1000));

            proyectos.add(proyecto);
        }

        return proyectos;
    }

    private static List<Departamento> generarDepartamentos() {
        List<Departamento> departamentos = new ArrayList<>();

        for (String nombre : DEPARTAMENTOS) {
            Departamento departamento = new Departamento();
            departamento.setNombre(nombre);
            departamento.setRegistros(generarRegistros(10));

            departamentos.add(departamento);
        }

        return departamentos;
    }

    private static List<Registro> generarRegistros(int cantidad) {
        List<Registro> registros = new ArrayList<>();

        for (int i = 1; i <= cantidad; i++) {
            Registro registro = new Registro();
            registro.setRazonSocial("Razón Social " + i);
            registro.setTipoDoc("Tipo de Documento " + i);
            registro.setBaseImponible(generarNumeroAleatorio(100, 1000));
            registro.setPorcentajeIva(generarNumeroAleatorio(0.05, 0.2));
            registro.setQuotaIVA(generarNumeroAleatorio(10, 100));
            registro.setPorcentajeRetencion(generarNumeroAleatorio(0.1, 0.3));
            registro.setQuotaRetencion(generarNumeroAleatorio(5, 50));
            registro.setImagenUrl("URL de la imagen " + i);
            registro.setFecha(new Date());
            registro.setTotalRegistro(generarNumeroAleatorio(100, 1000));

            registros.add(registro);
        }

        return registros;
    }

    private static double generarNumeroAleatorio(double min, double max) {
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }

    private static double generarNumeroAleatorio(int min, int max) {
        Random random = new Random();
        return min + random.nextInt(max - min + 1);
    }
}
