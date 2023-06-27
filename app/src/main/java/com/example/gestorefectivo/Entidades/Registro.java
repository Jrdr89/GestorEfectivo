package com.example.gestorefectivo.Entidades;

import java.io.Serializable;
import java.util.Date;

public class Registro implements Serializable {

        private String razonSocial;
        private String tipoDoc;
        private double baseImponible;
        private double porcentajeIva;
        private double quotaIVA;
        private double porcentajeRetencion;
        private double quotaRetencion;
        private String imagenUrl; // Aquí almacenaremos la URL de la imagen en FirebaseDatabase
        private Date fecha;
        private double totalRegistro;

        // Constructor

    public Registro() {
    }

    public Registro(String razonSocial, String tipoDoc, double baseImponible, double porcentajeIva, double quotaIVA, double porcentajeRetencion,
                    double quotaRetencion, String imagenUrl, Date fecha, double totalRegistro) {
        this.razonSocial = razonSocial;
        this.tipoDoc = tipoDoc;
        this.baseImponible = baseImponible;
        this.porcentajeIva = porcentajeIva;
        this.quotaIVA = quotaIVA;
        this.porcentajeRetencion = porcentajeRetencion;
        this.quotaRetencion = quotaRetencion;
        this.imagenUrl = imagenUrl;
        this.fecha = fecha;
        this.totalRegistro = totalRegistro;
    }
    // Getters y setters

        public String getRazonSocial() {
            return razonSocial;
        }

        public void setRazonSocial(String razonSocial) {
            this.razonSocial = razonSocial;
        }

        public String getTipoDoc() {
            return tipoDoc;
        }

        public void setTipoDoc(String tipoDoc) {
            this.tipoDoc = tipoDoc;
        }

        public double getBaseImponible() {
            return baseImponible;
        }

        public void setBaseImponible(double baseImponible) {
            this.baseImponible = baseImponible;
        }

        public double getPorcentajeIva() {
            return porcentajeIva;
        }

        public void setPorcentajeIva(double porcentajeIva) {
            this.porcentajeIva = porcentajeIva;
        }

        public double getQuotaIVA() {
            return quotaIVA;
        }

        public void setQuotaIVA(double quotaIVA) {
            this.quotaIVA = quotaIVA;
        }

        public double getPorcentajeRetencion() {
            return porcentajeRetencion;
        }

        public void setPorcentajeRetencion(double porcentajeRetencion) {
            this.porcentajeRetencion = porcentajeRetencion;
        }

        public double getQuotaRetencion() {
            return quotaRetencion;
        }

        public void setQuotaRetencion(double quotaRetencion) {
            this.quotaRetencion = quotaRetencion;
        }

        public String getImagenUrl() {
            return imagenUrl;
        }

        public void setImagenUrl(String imagenUrl) {
            this.imagenUrl = imagenUrl;
        }

        public Date getFecha() {
            return fecha;
        }

        public void setFecha(Date fecha) {
            this.fecha = fecha;
        }

        public double getTotalRegistro() {
            return totalRegistro;
        }

        public void setTotalRegistro(double totalRegistro) {
            this.totalRegistro = totalRegistro;
        }
    }
