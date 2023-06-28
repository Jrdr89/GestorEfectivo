package com.example.gestorefectivo.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gestorefectivo.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class FormularioActivity extends AppCompatActivity {

    private LinearLayout linearLayoutDepartamentos, linearLayoutDatos;
    private ImageButton mostrarDepartamentos;
    private RadioGroup rgDepartamentos,rgTipoDoc;
    private EditText editTextBaseImponible;
    private TextView tvDepartamentoSeleccionado,tvTipoSeleccionado, textViewTotal,textViewCuotaIva
            ,textViewCuotaret;

    private boolean isDepartamentosVisible = false;

    private Spinner spinnerPorcentajeRet,spinnerPorcentajeIva;
    private HashMap<String, Float> porcentajesRetencion = new HashMap<>();

    private HashMap<String, Float> porcentajesIva = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        //Obtener referencias del toolbar
        ImageView icono_atras = findViewById(R.id.icono_atras);
        ImageView ivAdd = findViewById(R.id.ivAdd);
        icono_atras.setVisibility(View.INVISIBLE);
        ivAdd.setVisibility(View.INVISIBLE);

        //Obtener referencias RadioGroups
        rgDepartamentos = findViewById(R.id.radioGroupDepartamentos);
        rgTipoDoc = findViewById(R.id.radioGroupTipoDocumento);

        //Obtener referencias a los textViews
        tvDepartamentoSeleccionado= findViewById(R.id.textViewDepartamentoSeleccionado);
        tvTipoSeleccionado = findViewById(R.id.textViewTipoDocumentoSeleccionado);

        //Obtener referencias Layout
        linearLayoutDepartamentos = findViewById(R.id.linearLayoutDepartamentos);
        linearLayoutDatos = findViewById(R.id.layoutSeccion3);
        mostrarDepartamentos = findViewById(R.id.mostrarDep);

        //Obtener referencias de los spinners
       spinnerPorcentajeRet = findViewById(R.id.spinnerPorcentajeRetencion);
       spinnerPorcentajeIva = findViewById(R.id.spinnerPorcentajeIVA);

        //Evento para llenar el hasmap de spinners
        llenarSpinners();

        //Creamos lista para poder pasarla al adaptador de los spinner
        ArrayList<String> porcentajesRetencionList = new ArrayList<>(porcentajesRetencion.keySet());
        Collections.sort(porcentajesRetencionList);
        ArrayAdapter<String> adapterRetencion = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, porcentajesRetencionList);
        adapterRetencion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        ArrayList<String>  porcentajesIvaList = new ArrayList<>(porcentajesIva.keySet());
        Collections.sort(porcentajesIvaList);
        ArrayAdapter<String> adapterIva = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, porcentajesIvaList);
        adapterIva.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerPorcentajeRet.setAdapter(adapterRetencion);
        spinnerPorcentajeIva.setAdapter(adapterIva);


        //Obtener refencia de los Text -Base Imponible -Cuota Iva - Cuota retencion
        editTextBaseImponible = findViewById(R.id.editTextBaseImponible);
        textViewTotal = findViewById(R.id.textViewTotal);
        textViewCuotaIva =findViewById(R.id.textViewCuotaIva);
        textViewCuotaret = findViewById(R.id.textViewCuotaRetencion);

        mostrarDepartamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleDepartamentos();
            }
        });

        rgDepartamentos.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String departamentoSeleccionado = "";
                View radioButton = rgDepartamentos.findViewById(i);
                int radioPulsado = rgDepartamentos.indexOfChild(radioButton);
                switch (radioPulsado) {
                    case 0:
                        departamentoSeleccionado = getString(R.string.Departamento1);
                        break;
                    case 1:
                        departamentoSeleccionado = getString(R.string.Departamento2);
                        break;
                    case 2:
                        departamentoSeleccionado = getString(R.string.Departamento3);
                        break;
                    case 3:
                        departamentoSeleccionado = getString(R.string.Departamento4);
                        break;
                    case 4:
                        departamentoSeleccionado = getString(R.string.Departamento5);
                        break;
                    case 5:
                        departamentoSeleccionado = getString(R.string.Departamento6);
                        break;
                    case 6:
                        departamentoSeleccionado = getString(R.string.Departamento7);
                        break;
                    case 7:
                        departamentoSeleccionado = getString(R.string.Departamento8);
                        break;
                    case 8:
                        departamentoSeleccionado = getString(R.string.Departamento9);
                        break;
                    case 9:
                        departamentoSeleccionado = getString(R.string.Departamento10);
                        break;
                }
                tvDepartamentoSeleccionado.setText(departamentoSeleccionado);
            }

        });

        rgTipoDoc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String tipodDocSeleccionado = "";
                View radioButton = rgTipoDoc.findViewById(i);
                int radioPulsado = rgTipoDoc.indexOfChild(radioButton);
                switch (radioPulsado){
                    case 0:
                    case 1:
                        tipodDocSeleccionado = ((RadioButton) radioButton).getText().toString();
                        break;
                }
                tvTipoSeleccionado.setText(tipodDocSeleccionado);
            }
        });

        // Agregar listener al EditText de Base Imponible
        editTextBaseImponible.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    // Realizar el cálculo al quitar el foco del EditText de Base Imponible
                    calcularTotal();
                }
            }
        });
        // Agregar listener al Spinner de Porcentaje de IVA
        spinnerPorcentajeIva.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                // Realizar el cálculo al cambiar la selección del Spinner de Porcentaje de IVA
                calcularTotal();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // No se necesita realizar ninguna acción si no se selecciona nada
            }
        });
    // Agregar listener al Spinner de Porcentaje de Retención
        spinnerPorcentajeRet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                // Realizar el cálculo al cambiar la selección del Spinner de Porcentaje de Retención
                calcularTotal();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // No se necesita realizar ninguna acción si no se selecciona nada
            }
        });

    }

    // Método para calcular el total
    private void calcularTotal() {
        // Obtener el valor ingresado en el EditText de Base Imponible
        String baseImponibleStr = editTextBaseImponible.getText().toString().replace(',', '.');
        // Verificar si el valor ingresado está vacío
        if (baseImponibleStr.isEmpty()) {
            // Mostrar un valor predeterminado o realizar alguna acción alternativa
            // Aquí puedes establecer el valor predeterminado a 0 o manejarlo de acuerdo a tus necesidades
            baseImponibleStr = "0";
        }
        double baseImponible =0.0;

            try{
                baseImponible = Double.parseDouble(baseImponibleStr);
            }catch (NumberFormatException n){
                editTextBaseImponible.setText("0,00");
            }


        // Obtener el valor seleccionado del Spinner de IVA
        float ivaValue = porcentajesIva.get(spinnerPorcentajeIva.getSelectedItem().toString());

        // Obtener el valor seleccionado del Spinner de Retención
        float retencionValue = porcentajesRetencion.get(spinnerPorcentajeRet.getSelectedItem().toString());

        // Calcular la cuota de IVA y Retención
        double cuotaIva = baseImponible * ivaValue;
        double cuotaRetencion = baseImponible * retencionValue;

        // Actualizar los TextView con los resultados
        textViewCuotaIva.setText(String.format("%.2f", cuotaIva));
        textViewCuotaret.setText(String.format("%.2f", cuotaRetencion));

        // Calcular el total
        double total = baseImponible + cuotaIva - cuotaRetencion;
        textViewTotal.setText(String.format("%.2f", total));
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

    private void llenarSpinners(){

        porcentajesRetencion.put("0%", 0f);
        porcentajesRetencion.put("1%", 0.01f);
        porcentajesRetencion.put("7%", 0.07f);
        porcentajesRetencion.put("15%", 0.15f);
        porcentajesRetencion.put("19%", 0.19f);

        porcentajesIva.put("0%",0f);
        porcentajesIva.put("4%",0.04f);
        porcentajesIva.put("10%",0.10f);
        porcentajesIva.put("21%",0.21f);

    }

}
