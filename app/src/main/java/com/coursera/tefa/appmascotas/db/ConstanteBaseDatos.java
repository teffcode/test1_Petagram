package com.coursera.tefa.appmascotas.db;

/**
 * Created by user on 2/04/17.
 */

public class ConstanteBaseDatos {

    // con final NADIE puede alterar los datos
    public static final String DATABASE_NAME = "contactos";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_CONTACTS           = "contacto";
    public static final String TABLE_CONTACTS_ID        = "id";
    public static final String TABLE_CONTACTS_NOMBRE    = "nombre";
    public static final String TABLE_CONTACTS_TELEFONO  = "telefono";
    public static final String TABLE_CONTACTS_EMAIL     = "email";
    public static final String TABLE_CONTACTS_FOTO      = "foto";

    public static final String TABLE_LIKE_CONTACT               = "contacto_likes";
    public static final String TABLE_LIKE_CONTACT_ID            = "id";
    public static final String TABLE_LIKE_CONTACT_ID_CONTACTO   = "id_contacto";
    public static final String TABLE_LIKE_CONTACT_NUMERO_LIKES  = "numero_likes";
}
