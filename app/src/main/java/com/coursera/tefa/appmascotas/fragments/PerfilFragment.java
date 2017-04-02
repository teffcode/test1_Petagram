package com.coursera.tefa.appmascotas.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coursera.tefa.appmascotas.R;
import com.coursera.tefa.appmascotas.adapter.FotoAdapter;
import com.coursera.tefa.appmascotas.pojo.Foto;

import java.util.ArrayList;


public class PerfilFragment extends android.support.v4.app.Fragment {

    private ArrayList<Foto> fotos;
    private RecyclerView listaFotos;
    public FotoAdapter adapter;

    public PerfilFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_perfil,container,false);

        listaFotos = (RecyclerView) v.findViewById(R.id.rvPerfil);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        listaFotos.setLayoutManager(gridLayoutManager);

        inicializarListaFotos();
        inicializarAdaptador();

        return v;
    }

    public void inicializarListaFotos(){

        fotos = new ArrayList<>();

        fotos.add(new Foto("En mi casa",R.drawable.gidget_1,10));
        fotos.add(new Foto("Planeando...",R.drawable.gidget_the_secret_life_of_pets_41,32));
        fotos.add(new Foto("I'm a princess",R.drawable.princess_gidget,84));
        fotos.add(new Foto("Amigos!",R.drawable.surprisedthumb_600x324_1_600x324,67));
        fotos.add(new Foto("At home :)",R.drawable.gidget_home,12));
        fotos.add(new Foto("Con Gary",R.drawable.tslop_ext_original,42));

    }


    public void inicializarAdaptador(){

        FotoAdapter adapter = new FotoAdapter(fotos, getActivity());
        listaFotos.setAdapter(adapter);

    }


}