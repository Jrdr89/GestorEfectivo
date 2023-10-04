package com.example.gestorefectivo.Model

data class UsuarioModel(

    val id: Int,
    val nombreCompleto: String,
    val email: String,
    val contraseña: String,
    val categoria: String
)
