package com.coursera.tefa.appmascotas.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.coursera.tefa.appmascotas.R;
import com.coursera.tefa.appmascotas.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by user on 2/04/17.
 */

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>{

    ArrayList<Contacto> contactos;
    Activity activity;
    //int clicks=0;

    public ContactoAdapter(ArrayList<Contacto> contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;
    }

    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent,false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ContactoViewHolder contactoViewHolder, int position) {
        final Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombre.setText(contacto.getNombre());
        contactoViewHolder.tvTelefono.setText(contacto.getTelefono());
        contactoViewHolder.tvLike.setText(String.valueOf(contacto.getLikes())+" Likes");

        /*

        ESTO FUE LO QUE ME DIJO JAMES:

        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clicks++;
                //Toast.makeText(activity, contacto.getNombre()+" ahora tiene "+clicks+" Likes",Toast.LENGTH_SHORT).show();
                contacto.setLikes(contacto.getLikes() + 1);
                notifyDataSetChanged();

            }
        });*/

        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + contacto.getNombre(),
                        Toast.LENGTH_SHORT).show();

                /*

                ConstructorContactos constructorContactos = new ConstructorContactos(activity);
                constructorContactos.darLikeCotnacto(contacto);
                contactoViewHolder.tvLike.setText(constructorContactos.obtenerLikesContacto(contacto) + " " + activity.getString(R.string.likes));
ESTO ES DE LA BASE DE DATOS
*/
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvTelefono;
        private TextView tvLike;
        private ImageButton btnLike;

        public ContactoViewHolder(View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvTelefono = (TextView) itemView.findViewById(R.id.tvTelefono);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            tvLike = (TextView) itemView.findViewById(R.id.tvLike);

        }
    }

}