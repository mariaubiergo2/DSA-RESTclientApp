package edu.upc.dsa.restclientapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

//import edu.upc.dsa.restclientapp.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

    }

    public void btnClicked(View view) throws IOException {
        if(view==button1){
            Intent intentRegister = new Intent(MainActivity.this, GameActivity.class);
            MainActivity.this.startActivity(intentRegister);
        }
        if(view==button2){
            Intent intentRegister = new Intent(MainActivity.this, PlayerActivity.class);
            MainActivity.this.startActivity(intentRegister);
        }
    }
}