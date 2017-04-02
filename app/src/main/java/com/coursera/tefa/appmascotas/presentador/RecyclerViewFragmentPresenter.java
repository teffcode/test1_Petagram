package com.coursera.tefa.appmascotas.presentador;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coursera.tefa.appmascotas.adapter.ContactoAdapter;
import com.coursera.tefa.appmascotas.db.ContructorContactos;
import com.coursera.tefa.appmascotas.fragments.IRecyclerViewFragmentView;
import com.coursera.tefa.appmascotas.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by user on 2/04/17.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ContructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactosBaseDatos();

    }

    @Override
    public void generarLinearLayoutVertical() {

    }

    @Override
    public ContactoAdapter crearAdapter(ArrayList<Contacto> contactos) {
        return null;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdapter adapter) {

    }

    @Override
    public void obtenerContactosBaseDatos() {
        constructorContactos = new ContructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdapter(contactos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
