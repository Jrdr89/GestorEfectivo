package com.example.gestorefectivo.VistaModelo.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestorefectivo.Entidades.Departamento;
import com.example.gestorefectivo.Entidades.Proyecto;
import com.example.gestorefectivo.R;
import com.example.gestorefectivo.Vistas.DepartamentoActivity;
import com.example.gestorefectivo.Vistas.RegistroActivity;

import java.util.List;

public class DepartamentoAdapter extends RecyclerView.Adapter<DepartamentoAdapter.DepartamentoViewHolder> {

    private List<Departamento> departamentos;
    private Context context;

    public DepartamentoAdapter(List<Departamento> departamentos, Context context) {
        this.departamentos = departamentos;
        this.context = context;
    }

    @NonNull
    @Override
    public DepartamentoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_departamento, parent, false);
        return new DepartamentoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartamentoViewHolder holder, int position) {
        Departamento departamento = departamentos.get(position);

        holder.ivDepartamento.setImageResource(R.drawable.departamentos);
        holder.tvNombreDepartamento.setText(departamento.getNombre());
        holder.tvSumatorioRegistros.setText("Sumatorio: " + departamento.getSumatorioRegistros());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener el proyecto seleccionado
                Departamento departamentoSeleccionado = departamentos.get(position);

                // Crear el intent para ir a la DepartamentoActivity
                Intent intent = new Intent(context, RegistroActivity.class);
                intent.putExtra("departamento", departamentoSeleccionado);

                // Iniciar la DepartamentoActivity
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return departamentos.size();
    }

    static class DepartamentoViewHolder extends RecyclerView.ViewHolder {
        ImageView ivDepartamento;
        TextView tvNombreDepartamento;
        TextView tvTotalDepartamento;
        TextView tvSumatorioRegistros;

        DepartamentoViewHolder(@NonNull View itemView) {
            super(itemView);
            ivDepartamento = itemView.findViewById(R.id.ivDepartamento);
            tvNombreDepartamento = itemView.findViewById(R.id.tvNombreDepartamento);
            tvTotalDepartamento = itemView.findViewById(R.id.tvTotalDepartamento);
            tvSumatorioRegistros = itemView.findViewById(R.id.tvSumatorioRegistros);
        }
    }
}
