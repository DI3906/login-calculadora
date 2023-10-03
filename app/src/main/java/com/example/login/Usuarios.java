package com.example.login;

import java.util.ArrayList;
import java.util.List;

public class Usuarios {
    private String nombreUsuario;
    private String contrasenia;

    public Usuarios(String nombreUsuario, String contrasenia) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    //obtener contraseña
    public String getContrasenia() {
        return contrasenia;
    }

    //editar contraseña
    public void setContrasenia(String contrasenia){
        this.contrasenia = contrasenia;
    }
}
