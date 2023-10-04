package com.example.gestorefectivo.Vistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.gestorefectivo.Entidades.DepartamentoItem;
import com.example.gestorefectivo.Entidades.RegistroItem;
import com.example.gestorefectivo.R;
import com.example.gestorefectivo.VistaModelo.Adapters.RegistroAdapter;

import java.util.List;

public class RegistroActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RegistroAdapter registroAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        //Obtener referencias del toolbar
        ImageView icono_atras = findViewById(R.id.icono_atras);
        ImageButton mostrarDepartamentos = findViewById(R.id.mostrarDep);

        mostrarDepartamentos.setVisibility(View.INVISIBLE);
        // Obtener el objeto Departamento del Intent
        DepartamentoItem departamento = (DepartamentoItem) getIntent().getSerializableExtra("departamento");

        // Obtener la list de registros del departamento
        List<RegistroItem> registros = departamento.getRegistros();

        // Inicializar RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Crear el adaptador y configurarlo en el RecyclerView
        registroAdapter = new RegistroAdapter(registros);
        recyclerView.setAdapter(registroAdapter);

        //Evento para finalizar actividad y volver atrás a la actividad de departamentos
        icono_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}