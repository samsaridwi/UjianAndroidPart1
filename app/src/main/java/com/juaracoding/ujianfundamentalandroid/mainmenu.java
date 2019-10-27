package com.juaracoding.ujianfundamentalandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class mainmenu extends AppCompatActivity {

    EditText nama;
    CalendarView txtDate;
    Button next;

    private RadioGroup radioGroup;
    private RadioButton radioButtonNb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);

        nama = findViewById(R.id.txtNama);
        next = findViewById(R.id.btnNext);

        radioGroup = findViewById(R.id.RG);

        txtDate = findViewById(R.id.calendarView);
        txtDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int i, int i1, int i2) {
                Calendar c = Calendar.getInstance();
                c.set(i,i1,i2);
                Date d = c.getTime();
                txtDate.setDate(c.getTimeInMillis());
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButtonNb = findViewById(selectedId);

                if (radioButtonNb.getText().toString().equalsIgnoreCase("pria")){
                    Intent intent = new Intent(mainmenu.this,pria.class);
                    intent.putExtra("nama", nama.getText().toString());
                    intent.putExtra("calender", txtDate.getDate());
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(mainmenu.this, wanita.class);
                    intent.putExtra("nama", nama.getText().toString());
                    intent.putExtra("calender", txtDate.getDate());
                    startActivity(intent);
                }



            }
        });
    }
}
