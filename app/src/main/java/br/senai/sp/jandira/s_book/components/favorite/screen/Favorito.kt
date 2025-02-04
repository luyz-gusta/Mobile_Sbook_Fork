package br.senai.sp.jandira.s_book.components.favorite.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.s_book.components.favorite.components.Card
import br.senai.sp.jandira.s_book.components.favorite.components.Header
import br.senai.sp.jandira.s_book.model.AnunciosFavoritosBaseResponse
import br.senai.sp.jandira.s_book.model.JsonFavoritados
import br.senai.sp.jandira.s_book.service.RetrofitHelper
import br.senai.sp.jandira.s_book.sqlite_repository.UserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun FavoritoScreen(
    navController: NavController,
    navRotasController: NavController,
    lifecycleScope: LifecycleCoroutineScope?
) {

    val context = LocalContext.current

    var listAnuncios by remember{
        mutableStateOf(listOf<JsonFavoritados>())
    }
    
    val array = UserRepository(context).findUsers()

    val user = array[0]

    // Cria uma chamada para o EndPoint
    val call = RetrofitHelper.getAnunciosFavoritadosService().getAnunciosFavoritosByUsuarioId(user.id)

    Log.e("API Call", "Antes da chamada da API: ${listAnuncios}")

    // Executar a chamada
    call.enqueue(object : Callback<AnunciosFavoritosBaseResponse> {
        override fun onResponse(
            call: Call<AnunciosFavoritosBaseResponse>,
            response: Response<AnunciosFavoritosBaseResponse>
        ) {
            listAnuncios = response.body()!!.anuncios

        }


        override fun onFailure(call: Call<AnunciosFavoritosBaseResponse>, t: Throwable) {
            Log.d("API Call", "Depois da chamada da API: ${listAnuncios}")
        }
    })


    Column (
        modifier = Modifier
            .fillMaxSize(),
    ){
        Header(
            navController = navController, navRotasController = navRotasController
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            items(listAnuncios) { item ->
                Card(
                    nome_livro = item.anuncio.nome,
                    ano_lancamento = item.anuncio.ano_lancamento,
                    foto = item.foto[0].foto,
                    tipo_anuncio = item.tipo_anuncio[0].tipo,
                    autor = item.autores[0].nome,
                    preco = item.anuncio.preco,
                    lifecycleScope = lifecycleScope!! ,
                    id = item.anuncio.id,
                    onClick = {
                        navRotasController.navigate("annouceDetail")
                    }
                )
            }
        }


    }
}

//@Composable
//@Preview
//fun FavoritoScreenPreview() {
//    FavoritoScreen()
//}