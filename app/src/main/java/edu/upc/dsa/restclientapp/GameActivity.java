package edu.upc.dsa.restclientapp;

import static java.lang.Integer.parseInt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;

import edu.upc.dsa.restclientapp.models.Juego;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameActivity extends AppCompatActivity {

    TextInputEditText namegameTxt;
    TextInputEditText descriptionTxt;
    TextInputEditText numnivelesTxt;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT1 = "namejuego";
    public static final String TEXT2 = "descripcio";
    public static final String TEXT3 = "numniveles";

    Api APIservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        namegameTxt = findViewById(R.id.namegameTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        numnivelesTxt = findViewById(R.id.numnivelesTxt);

    }
    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT1, namegameTxt.getText().toString());
        editor.putString(TEXT2, descriptionTxt.getText().toString());
        editor.putString(TEXT3, numnivelesTxt.getText().toString());

        editor.apply();
   }

    public void createGame(View view) throws IOException {
        namegameTxt = findViewById(R.id.namegameTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        numnivelesTxt = findViewById(R.id.numnivelesTxt);

        APIservice = RetrofitClient.getInstance().getMyApi();

        Juego game = new Juego(namegameTxt.getText().toString(), descriptionTxt.getText().toString(), parseInt(numnivelesTxt.getText().toString()));
        Call<Juego> call = APIservice.createJuego(game);

        call.enqueue(new Callback<Juego>() {
            @Override
            public void onResponse(Call<Juego> call, Response<Juego> response) {
                switch (response.code()){
                    case 201:
                        saveData();
                        Toast.makeText(GameActivity.this,"Correctly created", Toast.LENGTH_SHORT).show();
                        break;

                    case 409:
                        Toast.makeText(GameActivity.this,"Already exists!", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onFailure(Call<Juego> call, Throwable t) {
                Snackbar snakyfail = Snackbar.make(view, "NETWORK FAILURE", 3000);
                snakyfail.show();
            }
        });
    }


    public void returnFunction(View view){
        Intent intentRegister = new Intent(GameActivity.this, MainActivity.class);
        GameActivity.this.startActivity(intentRegister);
    }

}