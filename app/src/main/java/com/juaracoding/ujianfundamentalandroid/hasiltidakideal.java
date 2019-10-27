package com.juaracoding.ujianfundamentalandroid;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class hasiltidakideal extends AppCompatActivity {
    TextView nama, umur, beratBadan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output);

        nama = findViewById(R.id.txtNama2);
        umur = findViewById(R.id.txtUmur);
        beratBadan = findViewById(R.id.txtBeratBadan2);

        nama.setText("hai, "+getIntent().getStringExtra("nama"));
        umur.setText("umur anda adalah "+ getIntent().getLongExtra("umur",0));
        beratBadan.setText("Berat Badan Anda adalah tidak ideal");

    }
}
