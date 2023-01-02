package edu.upc.dsa.restclientapp;

import com.google.ar.core.Track;

import java.util.List;

import edu.upc.dsa.restclientapp.models.Juego;
import edu.upc.dsa.restclientapp.models.Partida;
import edu.upc.dsa.restclientapp.models.VOPlayerGameCredencials;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Api {
    @POST("games/create")
    Call<Juego> createJuego(@Body Juego game);

    @PUT("player/startpartida")
    Call<Partida> iniciarPartida(@Body VOPlayerGameCredencials credencials);

    @PUT("player/{id}/endpartida")
    Call<Track> endPartida(@Path("id") String id);

    @GET("player/{id}/partidas")
    Call<List<Partida>> getPartidasPlayer(@Path("id") String id);
}
