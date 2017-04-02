package com.coursera.tefa.appmascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.coursera.tefa.appmascotas.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by user on 2/04/17.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstanteBaseDatos.DATABASE_NAME, null, ConstanteBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaContacto = "CREATE TABLE " + ConstanteBaseDatos.TABLE_CONTACTS + "(" +
                ConstanteBaseDatos.TABLE_CONTACTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstanteBaseDatos.TABLE_CONTACTS_NOMBRE + " TEXT, " +
                ConstanteBaseDatos.TABLE_CONTACTS_TELEFONO + " TEXT, " +
                ConstanteBaseDatos.TABLE_CONTACTS_EMAIL + " TEXT, " +
                ConstanteBaseDatos.TABLE_CONTACTS_FOTO + " INTEGER" +
                ")";
        String queryCrearTablaLikesContacto = "CREATE TABLE " + ConstanteBaseDatos.TABLE_LIKE_CONTACT + "(" +
                ConstanteBaseDatos.TABLE_LIKE_CONTACT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstanteBaseDatos.TABLE_LIKE_CONTACT_ID_CONTACTO + " INTEGER, " +
                ConstanteBaseDatos.TABLE_LIKE_CONTACT_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstanteBaseDatos.TABLE_LIKE_CONTACT_ID_CONTACTO + ") " +
                "REFERENCES " + ConstanteBaseDatos.TABLE_CONTACTS + "(" + ConstanteBaseDatos.TABLE_CONTACTS_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTablaLikesContacto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstanteBaseDatos.TABLE_CONTACTS);
        db.execSQL("DROP TABLE IF EXIST " + ConstanteBaseDatos.TABLE_LIKE_CONTACT);
        onCreate(db);
    }

    public ArrayList<Contacto> obtenerTodosLosContactos() {
        ArrayList<Contacto> contactos = new ArrayList<>();

        String query = "SELECT * FROM " + ConstanteBaseDatos.TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Contacto contactoActual = new Contacto();
            contactoActual.setId(registros.getInt(0));
            contactoActual.setNombre(registros.getString(1));
            contactoActual.setTelefono(registros.getString(2));
            contactoActual.setEmail(registros.getString(3));
            contactoActual.setFoto(registros.getInt(4));

            // para que muestre siempre los likes cuando yo cierro y abro la app
            String queryLikes = "SELECT COUNT("+ConstanteBaseDatos.TABLE_LIKE_CONTACT_NUMERO_LIKES+") as likes " +
                    " FROM " + ConstanteBaseDatos.TABLE_LIKE_CONTACT +
                    " WHERE " + ConstanteBaseDatos.TABLE_LIKE_CONTACT_ID_CONTACTO + "=" + contactoActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                contactoActual.setLikes(registrosLikes.getInt(0));
            }else {
                contactoActual.setLikes(0);
            }

            contactos.add(contactoActual);

        }

        db.close();

        return contactos;
    }

    public void insertarContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstanteBaseDatos.TABLE_CONTACTS,null, contentValues);
        db.close();
    }

    public void insertarLikeContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstanteBaseDatos.TABLE_LIKE_CONTACT, null, contentValues);
        db.close();
    }


    public int obtenerLikesContacto(Contacto contacto){
        int likes = 0;

        String query = "SELECT COUNT("+ConstanteBaseDatos.TABLE_LIKE_CONTACT_NUMERO_LIKES+")" +
                " FROM " + ConstanteBaseDatos.TABLE_LIKE_CONTACT +
                " WHERE " + ConstanteBaseDatos.TABLE_LIKE_CONTACT_ID_CONTACTO + "="+contacto.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }
}