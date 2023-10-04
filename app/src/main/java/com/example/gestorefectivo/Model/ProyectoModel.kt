package com.example.gestorefectivo.Model

data class ProyectoModel(
    val id: Int,
    val nombre: String,
    val codigo: String,
    val efectivoEntregado: Double,
    val liquidacion: Double
)
