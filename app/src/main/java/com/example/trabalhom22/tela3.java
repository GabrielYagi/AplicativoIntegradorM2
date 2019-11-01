package com.example.trabalhom22;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.material.textfield.TextInputEditText;

public class tela3 extends AppCompatActivity {

    ImageView imageViewFoto;
    private TextInputEditText etQuilo;
    private TextInputEditText etLitros;
    private TextInputEditText etData;
    private TextInputEditText etPosto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);



        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},0);
        }

        imageViewFoto = (ImageView) findViewById(R.id.imageView);
        findViewById(R.id.Btncamera).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tirarFoto();
            }

        });


        etQuilo = findViewById(R.id.idQuilo);
        etLitros = findViewById(R.id.idLitro);
        etData = findViewById(R.id.idData);
        etPosto = findViewById(R.id.idPosto);

    }

    public void tirarFoto(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imagem = (Bitmap) extras.get("data");
            imageViewFoto.setImageBitmap(imagem);

        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    public void onClickBtnSalvar(View view){

            float Km = Float.parseFloat(etQuilo.getText().toString());
            float litros = Float.parseFloat(etLitros.getText().toString());
            String Data = etData.getText().toString();
            String Posto = etPosto.getText().toString();
            Float autonomia = Km / litros;

        Intent intentSalvar = new Intent(getApplicationContext(), MainActivity.class);

        Bundle parametros = new Bundle();

        parametros.putFloat("chave_km",Km);
        parametros.putFloat("chave_litros",litros);
        parametros.putString("chave_data",Data);
        parametros.putString("chave_posto",Posto);
        parametros.putFloat("chave_auto",autonomia);

        intentSalvar.putExtras(parametros);
        startActivity(intentSalvar);

    }




}
