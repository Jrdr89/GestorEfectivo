package com.example.gestorefectivo.Vistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.gestorefectivo.Entidades.Departamento;
import com.example.gestorefectivo.Entidades.Proyecto;
import com.example.gestorefectivo.R;
import com.example.gestorefectivo.VistaModelo.Adapters.DepartamentoAdapter;

import java.util.List;

public class DepartamentoActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DepartamentoAdapter departamentoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departamento);
        //Obtener referencias del toolbar
        ImageView icono_atras = findViewById(R.id.icono_atras);
        ImageView ivAdd = findViewById(R.id.ivAdd);
        ImageButton mostrarDepartamentos = findViewById(R.id.mostrarDep);

        mostrarDepartamentos.setVisibility(View.INVISIBLE);

        // Obtener el objeto Proyecto del intent
        Proyecto proyecto = (Proyecto) getIntent().getSerializableExtra("proyecto");

        // Obtener la lista de departamentos del objeto Proyecto
        List<Departamento> departamentos = proyecto.getDepartamentos();

        // Configurar el RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Crear el adaptador y asignarlo al RecyclerView
        departamentoAdapter = new DepartamentoAdapter(departamentos,this);
        recyclerView.setAdapter(departamentoAdapter);


        //Evento click para retroceder de actividad
        icono_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DepartamentoActivity.this, ProyectoActivity.class);
                startActivity(intent);
            }
        });

        //Evento para acceder al formulario
        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DepartamentoActivity.this, FormularioActivity.class);
                startActivity(intent);
            }
        });
    }
}
