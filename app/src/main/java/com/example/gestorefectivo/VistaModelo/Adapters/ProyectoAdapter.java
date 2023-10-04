package com.example.gestorefectivo.VistaModelo.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestorefectivo.Entidades.ProyectoItem;
import com.example.gestorefectivo.R;
import com.example.gestorefectivo.Vistas.DepartamentoActivity;

import java.util.List;

public class ProyectoAdapter extends RecyclerView.Adapter<ProyectoAdapter.ProyectoViewHolder> {
    private List<ProyectoItem> proyectos;
    private Context context;

    public ProyectoAdapter(List<ProyectoItem> proyectos, Context context) {
        this.proyectos = proyectos;
        this.context = context;
    }

    @NonNull
    @Override
    public ProyectoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_proyecto, parent, false);
        return new ProyectoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProyectoViewHolder holder, int position) {
        ProyectoItem proyecto = proyectos.get(position);

        holder.tvNombre.setText(proyecto.getNombre());
        holder.tvCodigo.setText(proyecto.getCodigo());
        holder.tvEfectivoEntregado.setText(String.format("%.2f €", proyecto.getEfectivoEntregado()));
        holder.tvLiquidacion.setText(String.format("%.2f €", proyecto.getLiquidacion()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener el proyecto seleccionado
                ProyectoItem proyectoSeleccionado = proyectos.get(position);

                // Crear el intent para ir a la DepartamentoActivity
                Intent intent = new Intent(context, DepartamentoActivity.class);
                intent.putExtra("proyecto", proyectoSeleccionado);

                // Iniciar la DepartamentoActivity
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return proyectos.size();
    }

    public static class ProyectoViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNombre;
        private TextView tvCodigo;
        private TextView tvEfectivoEntregado;
        private TextView tvLiquidacion;

        public ProyectoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvCodigo = itemView.findViewById(R.id.tvCodigo);
            tvEfectivoEntregado = itemView.findViewById(R.id.tvEfectivoEntregado);
            tvLiquidacion = itemView.findViewById(R.id.tvLiquidacion);
        }
    }
}
