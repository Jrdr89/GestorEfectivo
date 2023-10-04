package com.example.gestorefectivo.Model

data class DepartamentoModel(
    val id: Int,
    val nombre: String,
    val idProyecto: Int // Esto representa la clave foránea a proyectos
)
