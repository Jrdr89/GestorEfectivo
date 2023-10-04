package com.example.gestorefectivo.Conexion;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @GET("db.php")
    Call<Void> checkConnection();

    @GET("usuarios.php")
    Call<Boolean> verificarCredenciales(
            @Query("username") String username,
            @Query("password") String password
    );


    @POST("proyectos.php")
    Call<String> insertarProyecto(
            @Query("nombre") String nombre,
            @Query("codigo") String codigo
    );



}