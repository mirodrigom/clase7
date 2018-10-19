package com.example.alumno.clase7;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Segunda Activity");
        //Pone la flecha de back:
        ab.setDisplayHomeAsUpEnabled(true);

        Intent infoActivity = getIntent();
        int valorN = infoActivity.getExtras().getInt("valorN");
        String valorS = infoActivity.getExtras().getString("valorS");

        TextView txtUno = (TextView) findViewById(R.id.txtUno);
        TextView txtDos = (TextView) findViewById(R.id.txtDos);
        txtUno.setText(String.valueOf(valorN));
        txtDos.setText(valorS);
        Log.wtf("ValorN: ", String.valueOf(valorN));
        Log.wtf("ValorS: ", valorS);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if( id == android.R.id.home)
        {
            finish();
        }else{
            Intent llamarActivity = new Intent(Intent.ACTION_CALL, Uri.parse("tel:47732423"));
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},0);
            }else{
                super.startActivity(llamarActivity);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
