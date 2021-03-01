package com.example.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
                Intent i = new Intent();
                i.setAction(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_TEXT, "Hello There");
                i.setType("text/plain");
                startActivity(i);
                break;
            case  R.id.dial:
                Uri uri = Uri.parse("tel:1234567890");
                Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
                break;

            case R.id.Gallery:
                Intent intent1 =new Intent(Intent.ACTION_PICK);
                intent1.setType("image/+");
                startActivity(intent1);
                break;


        }

        return super.onOptionsItemSelected(item);
    }

    /*public void sending(MenuItem item) {

        Intent i = new Intent();
        i.setAction(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_TEXT, "Hello There");
        i.setType("text/plain");
        startActivity(i);
    }

    public void calling(MenuItem item) {

        Uri uri = Uri.parse("tel:1234567890");
        Intent i = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(i);
    }

    public void galleryopen(MenuItem item) {


        Intent i =new Intent(Intent.ACTION_PICK);
        i.setType("image/+");
        startActivity(i);
    }*/
}