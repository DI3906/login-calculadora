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

        // Inicia la bandera en falso, indicando que las credenciales son incorrectas
        boolean credencialesCorrectas = false;

        // Recorre la matriz
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuarios usuarios = listaUsuarios.get(i);

            if (usuarios.getNombreUsuario().equals(nameUsuario) && usuarios.getContrasenia().equals(inputContraseniaAntigua)) {
                // Las credenciales son correctas
                credencialesCorrectas = true;

                // Cambia la contraseña
                usuarios.setContrasenia(inputContraseniaNueva);

                // Muestra un mensaje de éxito
                Toast.makeText(getApplicationContext(), "Contraseña cambiada exitosamente", Toast.LENGTH_SHORT).show();

                // Regresa al login
                Intent intent = new Intent(CambiarContrasenia.this, MainActivity.class);
                startActivity(intent);
                break; // Sal del bucle una vez que se encontraron las credenciales correctas
            }
        }

        // Si las credenciales no son correctas, muestra un mensaje de error
        if (!credencialesCorrectas) {
            Toast.makeText(getApplicationContext(), "La contraseña antigua es incorrecta, revisa nuevamente", Toast.LENGTH_SHORT).show();
        }
    }
}