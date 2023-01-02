package edu.upc.dsa.restclientapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.ar.core.Track;

import java.io.IOException;
import java.util.List;

import edu.upc.dsa.restclientapp.models.Partida;
import edu.upc.dsa.restclientapp.models.VOPlayerGameCredencials;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerActivity extends AppCompatActivity {

    TextInputEditText namejuego;
    TextInputEditText username;
    TextInputEditText id;

    Api APIservice;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        namejuego = findViewById(R.id.descriptionTxt2);
        username = findViewById(R.id.numnivelesTxt2);
        id = findViewById(R.id.numnivelesTxt3);

    }


    public void startPartida(View view){
        namejuego = findViewById(R.id.descriptionTxt2);
        username = findViewById(R.id.numnivelesTxt2);

        APIservice = RetrofitClient.getInstance().getMyApi();

        VOPlayerGameCredencials credencials = new VOPlayerGameCredencials(namejuego.getText().toString(), username.getText().toString());
        Call<Partida> call = APIservice.iniciarPartida(credencials);

        call.enqueue(new Callback<Partida>() {
            @Override
            public void onResponse(Call<Partida> call, Response<Partida> response) {
                switch (response.code()) {
                    case 201:
                        Toast.makeText(PlayerActivity.this, "Partida started", Toast.LENGTH_SHORT).show();
                        break;

                    case 404:
                        Toast.makeText(PlayerActivity.this, "This game does not exists!", Toast.LENGTH_SHORT).show();
                        break;

                    case 400:
                        Toast.makeText(PlayerActivity.this, "This player is already playing!", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
            @Override
            public void onFailure(Call<Partida> call, Throwable t) {
                Snackbar snakyfail = Snackbar.make(view, "NETWORK FAILURE", 3000);
                snakyfail.show();
            }
        });

    }

    public void endPartida(View view){
        id = findViewById(R.id.numnivelesTxt3);

        APIservice = RetrofitClient.getInstance().getMyApi();

        Call<Track> call = APIservice.endPartida(id.getText().toString());

        call.enqueue(new Callback<Track>() {
            @Override
            public void onResponse(Call<Track> call, Response<Track> response) {
                switch (response.code()) {
                    case 200:
                        Toast.makeText(PlayerActivity.this, "Partida ended!", Toast.LENGTH_SHORT).show();
                        break;

                    case 404:
                        Toast.makeText(PlayerActivity.this, "This player does not exists!", Toast.LENGTH_SHORT).show();
                        break;

                    case 409:
                        Toast.makeText(PlayerActivity.this, "This player is not playing right now!", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
            @Override
            public void onFailure(Call<Track> call, Throwable t) {
                Snackbar snakyfail = Snackbar.make(view, "NETWORK FAILURE", 3000);
                snakyfail.show();
            }
        });

    }

    public void seePartidas (View view) throws IOException {
        id = findViewById(R.id.numnivelesTxt4);

        APIservice = RetrofitClient.getInstance().getMyApi();

        Call<List<Partida>> call = APIservice.getPartidasPlayer(id.getText().toString());

        List<Partida> partidas = call.execute().body();
        assert partidas != null;

        TableLayout tableLayout = findViewById(R.id.tableLayout);

        for (Partida partida : partidas) {
            View tableRow = LayoutInflater.from(this).inflate(R.layout.table_gadget_item, null, false);
            //View tableRow = findViewById(R.id.tableLayout);

            TextView namejuego = tableRow.findViewById(R.id.namejuego);
            TextView puntos = tableRow.findViewById(R.id.puntos);
            TextView nivelactual = tableRow.findViewById(R.id.nivelactual);

            namejuego.setText(partida.getNamejuego());
            puntos.setText(Integer.toString(partida.getPuntos()));
            nivelactual.setText(Integer.toString(partida.getNivelActual()));

            tableLayout.addView(tableRow);
        }

    }

    public void returnFunction(View view){
        Intent intentRegister = new Intent(PlayerActivity.this, MainActivity.class);
        PlayerActivity.this.startActivity(intentRegister);
    }

}