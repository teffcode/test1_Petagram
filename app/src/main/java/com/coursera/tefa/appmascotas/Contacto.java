package com.coursera.tefa.appmascotas;

/**
 * Created by user on 2/04/17.
 */

public class Contacto {

    private String Nombre, Telefono, Email;
    private int id, Foto, Likes;

    public Contacto(String nombre, String telefono, String email, int foto, int likes) {
        Nombre = nombre;
        Telefono = telefono;
        Email = email;
        Foto = foto;
        Likes = likes;
    }

    public Contacto() {

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }

    public int getLikes() {
        return Likes;
    }

    public void setLikes(int likes) {
        Likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

