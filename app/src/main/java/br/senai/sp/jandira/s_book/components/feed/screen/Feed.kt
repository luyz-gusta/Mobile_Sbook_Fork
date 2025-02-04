package br.senai.sp.jandira.s_book.components.feed.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.s_book.R
import br.senai.sp.jandira.s_book.components.feed.components.AnunciosProximos
import br.senai.sp.jandira.s_book.components.feed.components.EscolhaFazer
import br.senai.sp.jandira.s_book.components.feed.components.Header
import br.senai.sp.jandira.s_book.model.AnunciosBaseResponse
import br.senai.sp.jandira.s_book.model.JsonAnuncios
import br.senai.sp.jandira.s_book.service.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun FeedScreen(
    navController: NavController,
    navRotasController: NavController,
    lifecycleScope: LifecycleCoroutineScope?
) {
    val context = LocalContext.current

    var listAnuncios by remember{
        mutableStateOf(listOf<JsonAnuncios>())
    }

    val call = RetrofitHelper.getAnunciosService().getAnuncios()

    Log.e("API Call", "Antes da chamada da API: ${listAnuncios}")

    // Executar a chamada
    call.enqueue(object : Callback<AnunciosBaseResponse> {
        override fun onResponse(
            call: Call<AnunciosBaseResponse>,
            response: Response<AnunciosBaseResponse>
        ) {
            listAnuncios = response.body()!!.anuncios

        }


        override fun onFailure(call: Call<AnunciosBaseResponse>, t: Throwable) {
            Log.d("API Call", "Depois da chamada da API: ${listAnuncios}")
        }
    })

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        color = Color(0xFFF5F5F5)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ){
            Header(navController, navRotasController, context)
            EscolhaFazer(
                onclick = navRotasController.navigate("Filters")
            )
            Spacer(modifier = Modifier.height(16.dp))
            androidx.compose.material.Text(
                modifier = Modifier
                    .padding(start = 21.dp),
                text = "Anúncios mais próximos",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                fontWeight = FontWeight(400),
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(18.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxHeight(0.85f)
            ) {
                items(listAnuncios) { item ->
                    AnunciosProximos(
                        nome_livro = item.anuncio.nome,
                        foto = item.foto[0].foto,
                        tipo_anuncio = item.tipo_anuncio[0].tipo,
                        autor = item.autores[0].nome,
                        preco = item.anuncio.preco,
                        id = item.anuncio.id,
                        navController = navRotasController
                    )
                }
            }
        }
    }
}

