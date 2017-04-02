package com.coursera.tefa.appmascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.coursera.tefa.appmascotas.R;
import com.coursera.tefa.appmascotas.adapter.ContactoAdapter;
import com.coursera.tefa.appmascotas.pojo.Contacto;

import java.util.ArrayList;

public class Activity_Secundaria extends AppCompatActivity{

    ArrayList<Contacto> contactos5;
    private RecyclerView listaContactos5;
    public ContactoAdapter adapter5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__secundaria);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
//        miActionBar.setLogo(R.drawable.footprint);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaContactos5 = (RecyclerView) findViewById(R.id.rvContactos5);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos5.setLayoutManager(llm);

        inicializarListaContactos();
        inicializarAdaptador();

    }

    public void inicializarListaContactos(){

        contactos5 = new ArrayList<Contacto>();

        contactos5.add(new Contacto("Mel","333444","mel@gmail.com",R.drawable.mel1,0));
        contactos5.add(new Contacto("Snowball","444555","snowball@gmail.com",R.drawable.snowball,0));
        contactos5.add(new Contacto("Chloe","555666","chloe@gmail.com",R.drawable.chloe,0));
        contactos5.add(new Contacto("Sweetpea","666777","sweetpea@gmail.com",R.drawable.bird1,0));
        contactos5.add(new Contacto("Duke","777888","duke@gmail.com",R.drawable.duke1,0));
    }

    public void inicializarAdaptador(){

        adapter5 = new ContactoAdapter(contactos5, this);
        listaContactos5.setAdapter(adapter5);

    }

}