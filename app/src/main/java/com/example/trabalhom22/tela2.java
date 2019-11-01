package com.example.trabalhom22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
    }

    public void adicionarAbastecimento(View v){
        Intent intencao = new Intent( this, tela3.class );
        startActivityForResult(intencao, 1);
        Log.i("Deu merda","Fudeo");
    }
}
