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

    private EditText contraseniaAntigua, contraseniaNueva;
    private Button btnCambiarContrasenia;

    //obteniendo los datos del usuario(user && password)
    private String nameUsuario;
    private String userPassword;

    //Accediendo a la matriz
    List<Usuarios> listaUsuarios = AdminUser.getListaUsuarios();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_contrasenia);

        //obtener los datos del usuario
        Intent intent = getIntent();
        nameUsuario = intent.getStringExtra("nameUser");
        userPassword = intent.getStringExtra("password");

        TextView textViewUser =findViewById(R.id.txtSaludo);
        textViewUser.setText("Hola, " + nameUsuario);

        //Vincular los IDs de xml con variables
        contraseniaAntigua = findViewById(R.id.contraseniaAntigua);
        contraseniaNueva = findViewById(R.id.contraseniaNueva);
        btnCambiarContrasenia = findViewById(R.id.btnCambiarContrasenia);

    }

    public void onClick(View view){
        String inputContraseniaAntigua = contraseniaAntigua.getText().toString().trim();
        String inputContraseniaNueva = contraseniaNueva.getText().toString().trim();

        //verifica
        boolean credencialesCorrectas = false;

        //inicia el valor en -1, es decir, que no se encuentrar
        int usuarioIndice = -1;

        //recorre la matriz
        for (int i = 0; i < listaUsuarios.size(); i++ ){

            Usuarios usuarios = listaUsuarios.get(i);

            if (usuarios.getNombreUsuario().equals(nameUsuario) && usuarios.getContrasenia().equals(userPassword)){
                credencialesCorrectas = true;
                usuarioIndice = i;
                break;
            }
        }

        //una vez validado, cambia la contraseña y se regresa al login
        if (credencialesCorrectas && usuarioIndice != -1){
            //cambia la contraseña
            Usuarios contraseniaCambiada = listaUsuarios.get(usuarioIndice);
            contraseniaCambiada.setContrasenia(inputContraseniaNueva);

            //muestra un mensaje de exito
            Toast.makeText(getApplicationContext(), "Contraseña cambiada exitosamente", Toast.LENGTH_SHORT).show();

            //regresandolo al login
            Intent intent = new Intent(CambiarContrasenia.this, MainActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(getApplicationContext(), "La contraseña no coincide, revisa nuevamente", Toast.LENGTH_SHORT).show();
        }
    }
}