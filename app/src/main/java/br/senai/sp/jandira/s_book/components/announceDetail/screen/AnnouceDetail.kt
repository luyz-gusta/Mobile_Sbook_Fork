package br.senai.sp.jandira.s_book.components.announceDetail.screen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.senai.sp.jandira.s_book.components.announceDetail.components.CardInformacao
import br.senai.sp.jandira.s_book.components.announceDetail.components.FooterDescricao
import br.senai.sp.jandira.s_book.components.announceDetail.components.Header



@Composable
fun AnnouceDetail(
    navController: NavController
){
    Surface(
        modifier = Modifier
            .fillMaxSize(),
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(
                    ScrollState(115)
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Header()
            CardInformacao()
            FooterDescricao()
        }
    }
}
