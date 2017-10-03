package com.example.hola;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AdiosActivity extends AppCompatActivity {
    private TextView saludo;
    public static final String DATO = "nombre";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adios);
        saludo = (TextView) findViewById(R.id.txv);
        Intent intent = getIntent();
        saludo.setText(intent.getExtras().getString(DATO));
    }
}
