package com.example.yopido;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnEntar;
        Button btnRegistro;
        Button btnPedirYa;
        btnEntar = (Button) findViewById(R.id.btnEntrar);
        btnEntar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(R.id.MainActivityLayaut), R.string.msg_Aun_NO_TOLAIIIIIIIII,
                        Snackbar.LENGTH_SHORT)
                        .show();
            }
        }));
        btnRegistro = (Button) findViewById(R.id.btnRegistro);
        btnRegistro.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(R.id.MainActivityLayaut), R.string.msg_Aun_NO_TOLAIIIIIIIII,
                        Snackbar.LENGTH_SHORT)
                        .show();
            }
        }));
        btnPedirYa = (Button) findViewById(R.id.btnPideYa);
        btnPedirYa.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(R.id.MainActivityLayaut), R.string.msg_Aun_NO_TOLAIIIIIIIII,
                        Snackbar.LENGTH_SHORT)
                        .show();
            }
        }));
    }
}