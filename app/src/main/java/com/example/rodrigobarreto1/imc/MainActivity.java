package com.example.rodrigobarreto1.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Declaração dos objetos do tipo EditText
    EditText editTextAltura;
    EditText editTextPeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vinculação dos objetos JAVA com os elementos do Layout pelo ID
        editTextAltura = findViewById(R.id.etAltura);
        editTextPeso = findViewById(R.id.etPeso);
    }

    public void calcular(View view){
        Double altura = Double.parseDouble(editTextAltura.getText().toString());
        Double peso = Double.parseDouble(editTextPeso.getText().toString());

        Double resultado = peso/Math.pow(altura, 2);

        //Chama a ResultadoActivity
        Intent intent = new Intent(this, ResultadoActivity.class);
        intent.putExtra("RESULTADO", resultado.toString());
        startActivity(intent);

    }
}
