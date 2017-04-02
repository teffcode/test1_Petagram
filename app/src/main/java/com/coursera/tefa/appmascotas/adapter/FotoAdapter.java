package com.coursera.tefa.appmascotas.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import android.support.v7.widget.RecyclerView;

import com.coursera.tefa.appmascotas.R;
import com.coursera.tefa.appmascotas.pojo.Foto;

import java.util.ArrayList;

/**
 * Created by user on 2/04/17.
 */

public class FotoAdapter extends RecyclerView.Adapter<FotoAdapter.FotoViewHolder>{

    ArrayList<Foto> fotos;
    Activity activity;
    //int clicks=0;

    public FotoAdapter(ArrayList<Foto> fotos, Activity activity){
        this.fotos = fotos;
        this.activity = activity;
    }

    @Override
    public FotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_fotos,parent,false);
        return new FotoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final FotoViewHolder contactoViewHolder, int position) {
        final Foto foto = fotos.get(position);
        contactoViewHolder.imgFoto1.setImageResource(foto.getFoto());
        contactoViewHolder.tvDescription1.setText(foto.getNombre());
        contactoViewHolder.tvLike1.setText(String.valueOf(foto.getLikes()));

        contactoViewHolder.btnLike1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clicks++;
                //Toast.makeText(activity, contacto.getNombre()+" ahora tiene "+clicks+" Likes",Toast.LENGTH_SHORT).show();
                foto.setLikes(foto.getLikes() + 1);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    public static class FotoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto1;
        private TextView tvDescription1;
        private TextView tvLike1;
        private ImageButton btnLike1;

        public FotoViewHolder(View itemView) {
            super(itemView);

            imgFoto1 = (ImageView) itemView.findViewById(R.id.imgFoto1);
            tvDescription1 = (TextView) itemView.findViewById(R.id.tvDescription1);
            btnLike1 = (ImageButton) itemView.findViewById(R.id.btnLike1);
            tvLike1 = (TextView) itemView.findViewById(R.id.tvLike1);

        }
    }

}