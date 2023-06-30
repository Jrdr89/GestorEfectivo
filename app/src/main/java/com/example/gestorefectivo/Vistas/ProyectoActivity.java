package com.example.gestorefectivo.Vistas;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestorefectivo.Entidades.GeneradorDatos;
import com.example.gestorefectivo.Entidades.Proyecto;
import com.example.gestorefectivo.R;
import com.example.gestorefectivo.VistaModelo.Adapters.ProyectoAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProyectoActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProyectoAdapter proyectoAdapter;
    private List<Proyecto> proyectos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyecto);
        //Obtener referencias del toolbar
        ImageView icono_atras = findViewById(R.id.icono_atras);
        ImageView ivAdd = findViewById(R.id.ivAdd);
        ImageView icono_menu = findViewById(R.id.icono_menu);
        TextView titulo = findViewById(R.id.titulo);
        titulo.setText("Proyectos Activos");

        ImageButton mostrarDepartamentos = findViewById(R.id.mostrarDep);

        mostrarDepartamentos.setVisibility(View.INVISIBLE);

        // Inicializar la lista de proyectos (actualmente vacía)
        proyectos = new ArrayList<>();

        proyectos =  GeneradorDatos.generarProyectos();

        // Obtener la referencia del RecyclerView en el layout
        recyclerView = findViewById(R.id.recyclerView);

        // Establecer el LinearLayoutManager para el RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Crear el adaptador y asignarlo al RecyclerView
        proyectoAdapter = new ProyectoAdapter(proyectos, this);
        recyclerView.setAdapter(proyectoAdapter);
    }
}
