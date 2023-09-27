package br.senai.sp.jandira.s_book.service

import br.senai.sp.jandira.s_book.model.AnunciosFavoritosBaseResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface ViaCepService {

    @GET("{cep}/json")
    fun getLocal(@Path("cep") id: Int): Call<AnunciosFavoritosBaseResponse>
}