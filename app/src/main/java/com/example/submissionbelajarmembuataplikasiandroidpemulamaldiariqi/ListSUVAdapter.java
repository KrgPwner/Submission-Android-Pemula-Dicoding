package com.example.submissionbelajarmembuataplikasiandroidpemulamaldiariqi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListSUVAdapter extends RecyclerView.Adapter<ListSUVAdapter.ListViewHolder> {
    private ArrayList<SUV> listsuv;
    private OnItemClickCallback onItemClickCallback;

    public ListSUVAdapter(ArrayList<SUV> list) {
        this.listsuv = list;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.daftar_suv, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        SUV suv = listsuv.get(position);
        Glide.with(holder.itemView.getContext()).load(suv.getFoto()).apply(new RequestOptions().override(55, 55)).into(holder.Foto);
        holder.Nama.setText(suv.getNama());
        holder.Info.setText(suv.getInfo());

        final Context mContext = holder.itemView.getContext();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(mContext, DetailSUVActivity.class);
                detail.putExtra(DetailSUVActivity.EXTRA_NAMA, listsuv.get(holder.getAdapterPosition()).getNama());
                detail.putExtra(DetailSUVActivity.EXTRA_INFO, listsuv.get(holder.getAdapterPosition()).getInfo());
                detail.putExtra(DetailSUVActivity.EXTRA_FOTO, listsuv.get(holder.getAdapterPosition()).getFoto());
                mContext.startActivity(detail);
            }
        });
    }

    public interface OnItemClickCallback {
        void onItemClicked(SUV data);
    }

    @Override
    public int getItemCount() {
        return listsuv.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView Foto;
        TextView Nama, Info;
        ListViewHolder(View itemView) {
            super(itemView);
            Foto = itemView.findViewById(R.id.tv_foto_suv);
            Nama = itemView.findViewById(R.id.tv_nama_suv);
            Info = itemView.findViewById(R.id.tv_info_suv);
        }
    }
}
