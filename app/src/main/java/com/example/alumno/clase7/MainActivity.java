package com.example.alumno.clase7;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Titulo");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.itemUno) {
            Log.wtf("Item seleccionado", "itemUno");
        } else if (id == R.id.itemDos) {
            Log.wtf("Item seleccionado", "itemDos");

            Intent segundaActivity = new Intent(this,SegundaActivity.class);
            segundaActivity.putExtra("valorN",200);
            segundaActivity.putExtra("valorS","valor del put extra");

            super.startActivity(segundaActivity);
        }else if(id == android.R.id.home)
        {
            Log.wtf("Item seleccionado", "back");
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
