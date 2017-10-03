package com.example.hola;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HolaActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText texto, enlace;
    private Button saludar, navegar;
    private Intent intent;
    public  static final String DATO = "nombre";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hola);
        saludar = (Button) findViewById(R.id.btnSaludar);
        navegar = (Button) findViewById(R.id.btnNavegar);
        texto = (EditText) findViewById(R.id.etxNombre);
        enlace = (EditText) findViewById(R.id.etxNavegar);
        saludar.setOnClickListener(this);
        navegar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==saludar){
            intent = new Intent(this, AdiosActivity.class);
            intent.putExtra(DATO, texto.getText().toString());
            startActivity(intent);
        }
        if (view == navegar) {
            openWebPage(enlace.getText().toString());
        }
    }

    public void openWebPage(String url){
        Uri webpage = Uri.parse(url);
        intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "No hay un navegador instalado", Toast.LENGTH_SHORT).show();
        }

    }
}
