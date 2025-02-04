package br.senai.sp.jandira.s_book.components.Filters.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.senai.sp.jandira.s_book.components.Filters.components.Form
import br.senai.sp.jandira.s_book.components.universal.HeaderFilter


@Composable
fun FiltersScreen(
    navController: NavController
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            HeaderFilter(
                text = "Filtros",
                onclick = navController.navigate("navigation_home_bar")
            )
            Form()
        }
    }
}
