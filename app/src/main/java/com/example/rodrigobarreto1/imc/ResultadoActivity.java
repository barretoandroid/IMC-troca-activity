package com.example.rodrigobarreto1.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    TextView textViewResultado;
    ImageView imageViewResultado;
    Double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        textViewResultado = findViewById(R.id.tvResultado);
        imageViewResultado = findViewById(R.id.ivResultado);

        Intent intent = getIntent();
        String mensagem = intent.getStringExtra("RESULTADO");
        resultado = Double.parseDouble(mensagem);
        compara();
    }

    public void compara(){
        if (resultado>=25.0){
            //Gordinho
            textViewResultado.setText("Acima do peso");
            imageViewResultado.setImageResource(R.drawable.img1);
        }
        else if(resultado<18.5){
            //Magrinho
            textViewResultado.setText("Abaixo do peso teste");
            imageViewResultado.setImageResource(R.drawable.img2);
        }
        else{
            //Médio
            textViewResultado.setText("Peso ideal");
            imageViewResultado.setImageResource(R.drawable.img3);
        }
    }
}
