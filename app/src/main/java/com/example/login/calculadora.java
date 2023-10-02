package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.Toolbar;

public class calculadora extends AppCompatActivity {

    EditText num1, num2;
    TextView resultado;

    RadioButton radio_suma, radio_resta, radio_multiplicacion, radio_division;

    double numero1, numero2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);


        /*Vincular los controles para manipular la aplicacion*/
        num1 = (EditText) findViewById(R.id.txtNum1);
        num2 = (EditText) findViewById(R.id.txtNum2);

        radio_suma = (RadioButton) findViewById(R.id.radio_suma);
        radio_resta = (RadioButton) findViewById(R.id.radio_resta);
        radio_multiplicacion = (RadioButton) findViewById(R.id.radio_multiplicacion);
        radio_division = (RadioButton) findViewById(R.id.radio_division);

        resultado = (TextView) findViewById(R.id.txtResultado);

//        //recuperacion del nombre del usuario
//        String nombreUsuario = getIntent().getStringExtra("nombreUsuario");
//
//        //muestra un mensaje de bienvenida
//        TextView textViewUsuario = findViewById(R.id.txtBienvenida);
//        textViewUsuario.setText("Bienvenido, usuario: " + nombreUsuario);

    }

    //clases para los iconos de la actionBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.iconCambiarUsuario:
                Intent intent = new Intent(calculadora.this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.iconCambiarContrasenia:
                Intent intent2 = new Intent(calculadora.this, CambiarContrasenia.class);
                startActivity(intent2);
                return true;
                //Intent intent = new Intent(MainActivity.this, calculadora.class);
                //startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //metodos para realizar las operaciones
    private double sumar(double num1, double num2){
        return num1 + num2;
    }

    private double restar(double num1, double num2){
        return num1 - num2;
    }

    private double multiplicar(double num1, double num2){
        return num1 * num2;
    }

    private double dividir(double num1, double num2){
        return num1 / num2;
    }

    //vinculacion del metodo onClick del boton "Calcular" con el metodo validar
    public void onClick(View view){
        if (view.getId()==R.id.btnCalcular){
            validar();
        }
    }

    //metodo para enviar el resultado
    public void validar(){
        numero1= Double.parseDouble(num1.getText().toString());
        numero2= Double.parseDouble(num2.getText().toString());

        if (radio_suma.isChecked()){
            resultado.setText("El resultado de la suma es: " + sumar(numero1, numero2));
        } else if (radio_resta.isChecked()){
            resultado.setText("El resultado de la resta es: " + restar(numero1, numero2));
        } else if (radio_division.isChecked()){
            resultado.setText("El resultado de la división es: " + dividir(numero1, numero2));
        } else if (radio_multiplicacion.isChecked()){
            resultado.setText("El resultado de la multiplicación es: " + multiplicar(numero1, numero2));
        }
    }

}