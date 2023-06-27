package com.example.gestorefectivo.VistaModelo.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestorefectivo.Entidades.Registro;
import com.example.gestorefectivo.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RegistroAdapter extends RecyclerView.Adapter<RegistroAdapter.RegistroViewHolder> {
    private List<Registro> registros;

    public RegistroAdapter(List<Registro> registros) {
        this.registros = registros;
    }

    @NonNull
    @Override
    public RegistroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_registro, parent, false);
        return new RegistroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RegistroViewHolder holder, int position) {
        Registro registro = registros.get(position);

/*        holder.imageView.setImageResource(R.drawable.imagenUrl);*/
        holder.tvTipoDoc.setText(registro.getTipoDoc());
        holder.tvRazonSocial.setText(registro.getRazonSocial());
        holder.tvFecha.setText(formatDate(registro.getFecha()));
        holder.tvTotalRegistro.setText(String.format(Locale.getDefault(), "%.2f €", registro.getTotalRegistro()));
    }

    @Override
    public int getItemCount() {
        return registros.size();
    }

    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy", Locale.getDefault());
        return sdf.format(date);
    }

    public static class RegistroViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView tvTipoDoc;
        private TextView tvRazonSocial;
        private TextView tvFecha;
        private TextView tvTotalRegistro;

        public RegistroViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tvTipoDoc = itemView.findViewById(R.id.tvTipoDoc);
            tvRazonSocial = itemView.findViewById(R.id.tvRazonSocial);
            tvFecha = itemView.findViewById(R.id.tvFecha);
            tvTotalRegistro = itemView.findViewById(R.id.tvTotalRegistro);
        }
    }
}
