package com.example.gestorefectivo.Model

data class RegistroModel(
    val id: Int,
    val razonSocial: String,
    val tipoDoc: String,
    val baseImponible: Double,
    val porcentajeIva: Double,
    val cuotaIva: Double,
    val porcentajeRetencion: Double,
    val cuotaRetencion: Double,
    val imagen64: String,
    val fecha: String,
    val totalRegistro: Double,
    val idDepartamento: Int, // Esto representa la clave foránea a departamentos
    val idProyecto: Int // Esto representa la clave foránea a proyectos
)
