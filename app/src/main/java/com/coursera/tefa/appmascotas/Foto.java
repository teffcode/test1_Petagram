package com.coursera.tefa.appmascotas;

/**
 * Created by user on 2/04/17.
 */

public class Foto {
    private String Nombre;
    private int Foto, Likes;

    public Foto(String nombre, int foto, int likes) {
        Nombre = nombre;
        Foto = foto;
        Likes = likes;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
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
}
