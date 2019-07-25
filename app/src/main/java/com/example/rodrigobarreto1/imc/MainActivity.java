package com.example.rodrigobarreto1.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

    //Exibe o menu_principal na barra superior
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.itemSobre){
            //Ação ao clicar sobre o item menu
            Intent intent = new Intent(this, SobreActivity.class);
            startActivity(intent);

        }else if(id == R.id.itemConfig){
            //Ação ao clicar configurações
            Toast toast = Toast
                    .makeText(getApplicationContext()
                            , "Configurações"
                            , Toast.LENGTH_LONG);
            toast.show();
        }
        return super.onOptionsItemSelected(item);
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
