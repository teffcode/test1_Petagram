package com.coursera.tefa.appmascotas.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coursera.tefa.appmascotas.R;
import com.coursera.tefa.appmascotas.adapter.ContactoAdapter;
import com.coursera.tefa.appmascotas.pojo.Contacto;
import com.coursera.tefa.appmascotas.presentador.IRecyclerViewFragmentPresenter;
import com.coursera.tefa.appmascotas.presentador.RecyclerViewFragmentPresenter;
import java.util.ArrayList;

public class RecyclerViewFragment extends android.support.v4.app.Fragment implements IRecyclerViewFragmentView{

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    private IRecyclerViewFragmentPresenter presenter;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recycler_view,container,false);

        listaContactos = (RecyclerView) v.findViewById(R.id.rvContactos);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        //inicializarListaContactos();

        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);
    }

    @Override
    public ContactoAdapter crearAdapter(ArrayList<Contacto> contactos) {

        ContactoAdapter adapter = new ContactoAdapter(contactos, getActivity());
        return adapter;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdapter adapter) {
        listaContactos.setAdapter(adapter);

    }
}