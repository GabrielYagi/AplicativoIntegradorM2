package com.example.trabalhom22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView texto = (TextView)findViewById(R.id.idAutonomia);


        Intent recebendoDados = getIntent();

        Bundle recebendoParametros = recebendoDados.getExtras();

        if(recebendoParametros != null){

            float km = recebendoParametros.getFloat("chave_km");
            float litros = recebendoParametros.getFloat("chave_litros");
            float autonomia = recebendoParametros.getFloat("chave_auto");

            String resul = String.valueOf(autonomia);


            texto.setText(resul);

        }

    }

    public void mostrarAbastecimentos(View v){
        Intent intencao = new Intent( this, tela2.class );
        startActivityForResult(intencao, 1);
    }
}
