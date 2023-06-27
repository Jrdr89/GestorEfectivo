package com.example.gestorefectivo.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.gestorefectivo.R;

public class FormularioActivity extends AppCompatActivity {

    private LinearLayout linearLayoutDepartamentos, linearLayoutDatos;
    private ImageButton mostrarDepartamentos;
    private RadioGroup rgDepartamentos,rdTipoDoc;
    private TextView tvDepartamentoSeleccionado;

    private boolean isDepartamentosVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        //Obtener referencias RadioGroups
        rgDepartamentos = findViewById(R.id.radioGroupDepartamentos);
        rdTipoDoc = findViewById(R.id.radioGroupTipoDocumento);

        //Obtener referencias a los textViews
        tvDepartamentoSeleccionado= findViewById(R.id.textViewDepartamentoSeleccionado);

        //Obtener referencias Layout
        linearLayoutDepartamentos = findViewById(R.id.linearLayoutDepartamentos);
        linearLayoutDatos = findViewById(R.id.layoutSeccion3);
        mostrarDepartamentos = findViewById(R.id.mostrarDep);

        mostrarDepartamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleDepartamentos();
            }
        });

        rgDepartamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton radioButton = (RadioButton) view;
                if (radioButton.isChecked()) {
                    String departamentoSeleccionado = "";
                    switch (rgDepartamentos.getChildCount()) {
                        case 1:
                            departamentoSeleccionado =  departamentoSeleccionado = getString(R.string.Departamento1);;
                            break;
                    }
                    tvDepartamentoSeleccionado.setText(departamentoSeleccionado);
                }
            }
        });
    }


    private void toggleDepartamentos() {
        Animation slideAnimation;

        if (isDepartamentosVisible) {
            // Ocultar sección de departamentos
            slideAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
            linearLayoutDepartamentos.setVisibility(View.GONE);
            linearLayoutDatos.setVisibility(View.VISIBLE);
            isDepartamentosVisible = false;
        } else {
            // Mostrar sección de departamentos
            slideAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
            linearLayoutDepartamentos.setVisibility(View.VISIBLE);
            linearLayoutDatos.setVisibility(View.GONE);
            isDepartamentosVisible = true;
        }

        linearLayoutDepartamentos.startAnimation(slideAnimation);
    }


}
