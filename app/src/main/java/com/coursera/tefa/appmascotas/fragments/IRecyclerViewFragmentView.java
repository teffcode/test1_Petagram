package com.coursera.tefa.appmascotas.fragments;

import com.coursera.tefa.appmascotas.adapter.ContactoAdapter;
import com.coursera.tefa.appmascotas.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by user on 2/04/17.
 */

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public ContactoAdapter crearAdapter(ArrayList<Contacto> contactos);

    public void inicializarAdaptadorRV(ContactoAdapter adapter);
}
