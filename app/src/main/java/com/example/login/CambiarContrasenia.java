package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;

//importar arrayList y List de J A V A
import java.util.ArrayList;
import  java.util.List;

public class CambiarContrasenia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_contrasenia);

        //Accediendo a la matriz
        List<Usuarios> listaUsuarios = AdminUser.getListaUsuarios();

        //obteniendo el usuario y su contraseña
        String nameUsuario = getIntent().getStringExtra("nameUser");
        String userPassword = getIntent().getStringExtra("password");

        TextView textViewUser =findViewById(R.id.txtSaludo);
        textViewUser.setText("Hola, " + nameUsuario);

    }
}