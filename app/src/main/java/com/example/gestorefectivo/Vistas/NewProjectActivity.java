package com.example.gestorefectivo.Vistas;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gestorefectivo.R;
import com.google.android.material.textfield.TextInputLayout;
import android.widget.EditText;
import android.widget.Button;

public class NewProjectActivity extends AppCompatActivity {

    private TextInputLayout tilNombreProyecto, tilCodigoProyecto, tilImporteEntregado;
    private EditText etNombreProyecto, etCodigoProyecto, etImporteEntregado;
    private Button btnAceptar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_project);

        tilNombreProyecto = findViewById(R.id.tilNombreProyecto);
        tilCodigoProyecto = findViewById(R.id.tilCodigoProyecto);
        tilImporteEntregado = findViewById(R.id.tilImporteEntregado);

        etNombreProyecto = findViewById(R.id.etNombreProyecto);
        etCodigoProyecto = findViewById(R.id.etCodigoProyecto);
        etImporteEntregado = findViewById(R.id.etImporteEntregado);

        btnAceptar = findViewById(R.id.btnAceptar);
        btnCancelar = findViewById(R.id.btnCancelar);
    }
}
