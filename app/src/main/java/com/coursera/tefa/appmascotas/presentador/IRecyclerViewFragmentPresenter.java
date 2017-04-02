package com.coursera.tefa.appmascotas.presentador;

import com.coursera.tefa.appmascotas.adapter.ContactoAdapter;
import com.coursera.tefa.appmascotas.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by user on 2/04/17.
 */

public interface IRecyclerViewFragmentPresenter {

    public void generarLinearLayoutVertical();

    public ContactoAdapter crearAdapter(ArrayList<Contacto> contactos);

    public void inicializarAdaptadorRV(ContactoAdapter adapter);

    void obtenerContactosBaseDatos();

    void mostrarContactosRV();
}
