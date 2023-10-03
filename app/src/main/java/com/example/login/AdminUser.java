package com.example.login;

import java.util.ArrayList;
import java.util.List;

public class AdminUser {
    private static List<Usuarios> listaUsuarios = new ArrayList<>();

    static {
        //Agregar usuarios
        listaUsuarios.add(new Usuarios("user00","000"));
        listaUsuarios.add(new Usuarios("user01","001"));
        listaUsuarios.add(new Usuarios("user02","002"));
        listaUsuarios.add(new Usuarios("user03","003"));
        listaUsuarios.add(new Usuarios("user04","004"));
        listaUsuarios.add(new Usuarios("user05","005"));
        listaUsuarios.add(new Usuarios("user06","006"));
        listaUsuarios.add(new Usuarios("user07","007"));
        listaUsuarios.add(new Usuarios("user08","008"));
        listaUsuarios.add(new Usuarios("user09","009"));
    }

    public static List<Usuarios> getListaUsuarios() {
        return listaUsuarios;
    }

    public static void agregarUsuario(Usuarios usuario) {
        listaUsuarios.add(usuario);
    }
}




