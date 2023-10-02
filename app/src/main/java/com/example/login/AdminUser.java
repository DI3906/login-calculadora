package com.example.login;

import java.util.ArrayList;
import java.util.List;

public class AdminUser {
    private static List<Usuarios> listaUsuarios = new ArrayList<>();

    static {
        //Agregar usuarios
        listaUsuarios.add(new Usuarios("user00","user00"));
        listaUsuarios.add(new Usuarios("user01","user01"));
        listaUsuarios.add(new Usuarios("user02","user02"));
        listaUsuarios.add(new Usuarios("user03","user03"));
        listaUsuarios.add(new Usuarios("user04","user04"));
        listaUsuarios.add(new Usuarios("user05","user05"));
        listaUsuarios.add(new Usuarios("user06","user06"));
        listaUsuarios.add(new Usuarios("user07","user07"));
        listaUsuarios.add(new Usuarios("user08","user08"));
        listaUsuarios.add(new Usuarios("user09","user09"));
    }

    public static List<Usuarios> getListaUsuarios() {
        return listaUsuarios;
    }

    public static void agregarUsuario(Usuarios usuario) {
        listaUsuarios.add(usuario);
    }
}




