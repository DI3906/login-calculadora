package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//importar arrayList y List de J A V A
import java.io.Serializable;
import java.util.ArrayList;
import  java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText user, password;
    private Button btnIngresar;
    // Usuario y contraseña
    //private static String usuario = "diego";
    //private static String contrasenia = "12345";

    // Obtener la lista de usuarios
    List<Usuarios> listaUsuarios = AdminUser.getListaUsuarios();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vinculación de variables con IDs de XML
        user = findViewById(R.id.usuario);
        password = findViewById(R.id.contrasenia);
        btnIngresar = findViewById(R.id.btnIngresar);

    }

    public void onClick(View view) {
        String inputUsuario = user.getText().toString().trim();
        String inputContrasenia = password.getText().toString().trim();

        //verifica
        boolean credencialesCorrectas = false;

        //recorre la matriz
        for (Usuarios usuarios : listaUsuarios){
            if (usuarios.getNombreUsuario().equals(inputUsuario) && usuarios.getContrasenia().equals(inputContrasenia)){
                credencialesCorrectas = true;
                break;
            }
        }

        //una vez validado se accede a la calcualdora
        if (credencialesCorrectas){
            Intent intent = new Intent(MainActivity.this, calculadora.class);
            intent.putExtra("nombreUsuario", inputUsuario);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }


        /*

        if (inputUsuario.equals(usuario) && inputContrasenia.equals(contrasenia)) {
            Intent intent = new Intent(MainActivity.this, calculadora.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }

        */
    }
}
