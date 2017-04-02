package com.coursera.tefa.appmascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.coursera.tefa.appmascotas.R;
import com.coursera.tefa.appmascotas.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by user on 2/04/17.
 */

public class ContructorContactos {
    private static final int LIKE = 1; // interactor

    private Context context;
    public ContructorContactos(Context context) {
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos(){
        ArrayList<Contacto> contactos = new ArrayList<Contacto>();

        // conexión a la base de datos
        BaseDatos db = new BaseDatos(context);
        insertarTresContactos(db);
        return  db.obtenerTodosLosContactos();
    }

    // métodos que nos ayude a insertar un par de contactos
    public void  insertarTresContactos(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_NOMBRE,"Snowball");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_TELEFONO,"111222");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_EMAIL,"snowball@gmail.com");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.snowball);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_NOMBRE,"Sweetpea");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_TELEFONO,"222333");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_EMAIL,"sweetpea@gmail.com");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_FOTO,R.drawable.bird1);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_NOMBRE,"Mel");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_TELEFONO,"333444");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_EMAIL,"mel@gmail.com");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_FOTO,R.drawable.mel1);

        db.insertarContacto(contentValues);
    }

    public void darLikeCotnacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_LIKE_CONTACT_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstanteBaseDatos.TABLE_LIKE_CONTACT_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);
    }

}
