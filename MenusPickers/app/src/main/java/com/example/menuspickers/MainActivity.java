package com.example.menuspickers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    int c_date, c_month,c_year, c_hour,c_minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case  R.id.share:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case  R.id.dial:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            
            case R.id.Gallery:
                 Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
             break;


        }
        return super.onOptionsItemSelected(item);
    }

    public void alertDialog(View view) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Alert");
        dialog.setMessage("Do you want to exit?");
        dialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        dialog.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        dialog.setCancelable(false);
        dialog.show();
    }


    public void datePicker(View view) {

        Calendar c = Calendar.getInstance();
        c_year = c.get(Calendar.YEAR);
        c_month = c.get(Calendar.MONTH);
        c_date = c.get(Calendar.DATE);

        DatePickerDialog pickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Toast.makeText(MainActivity.this, i2+"-"+(i1+1)+"-"+i, Toast.LENGTH_SHORT).show();

            }
        },c_year,c_month,c_date);

        pickerDialog.show();
    }

    public void timePicker(View view) {

        Calendar c = Calendar.getInstance();
        c_hour = c.get(Calendar.HOUR_OF_DAY);
        c_minute= c.get(Calendar.MINUTE);

        TimePickerDialog timeDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                Toast.makeText(MainActivity.this, i+":"+i1, Toast.LENGTH_SHORT).show();

            }
        },c_hour,c_minute,true);
        timeDialog.show();
    }
}


