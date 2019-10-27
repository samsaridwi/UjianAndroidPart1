package com.juaracoding.ujianfundamentalandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class wanita extends AppCompatActivity {
    TextView nama, calender, pria, wanita, txtKb;

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    EditText beratBadan;
    Button next;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kelamin);
        txtKb = findViewById(R.id.txtKb);
        txtKb.setText("Apakah Anda Sudah mengikuti KB ?");

        radioGroup = findViewById(R.id.radioGroup);


        beratBadan = findViewById(R.id.txtBeratBadan);
        next = findViewById(R.id.next);

        nama = findViewById(R.id.ambilNama);
        calender = findViewById(R.id.ambilCalender);
        pria = findViewById(R.id.ambilPria);
        wanita = findViewById(R.id.ambilWanita);

        nama.setText(getIntent().getStringExtra("nama"));
        calender.setText(getIntent().getStringExtra("calender"));
        pria.setText(getIntent().getStringExtra("pria"));
        wanita.setText(getIntent().getStringExtra("wanita"));

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(selectedId);
                String nilaiBaru = beratBadan.getText().toString();

                int beratBadanIdeal = Integer.parseInt(nilaiBaru);
                int badan = 70;
                int badan2 = 60;
                long umur = new Date().getTime()-getIntent().getLongExtra("calender",0);
                umur = umur/1000/60/60/24/365;


                if (radioButton.getText().toString().equalsIgnoreCase("ya") && beratBadanIdeal <= badan || radioButton.getText().toString().equalsIgnoreCase("tidak") && beratBadanIdeal <= badan2) {
                    Intent intent = new Intent(wanita.this, hasiltidakideal.class);


                    intent.putExtra("nama", nama.getText().toString());
                    intent.putExtra("calender", calender.getText().toString());
                    intent.putExtra("beratBadan", beratBadan.getText().toString());
                    intent.putExtra("umur",umur);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(wanita.this, hasiltidakideal.class);

                    intent.putExtra("nama", nama.getText().toString());
                    intent.putExtra("calender", calender.getText().toString());
                    intent.putExtra("beratBadan", beratBadan.getText().toString());
                    intent.putExtra("umur",umur);
                    startActivity(intent);
                }
            }
        });


    }
}
