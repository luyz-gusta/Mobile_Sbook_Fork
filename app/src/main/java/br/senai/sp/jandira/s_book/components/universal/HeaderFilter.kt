package br.senai.sp.jandira.s_book.components.universal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.s_book.R


@Composable
fun HeaderFilter(
    text : String,
    onclick : Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(123.dp)
        ) {
            IconButton(
                onClick = {
                    onclick
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.voltar),
                    contentDescription = "",
                    modifier = Modifier
                        .size(28.dp),
                    tint = Color(0xFFAA6231)
                )
            }
            Text(
                text = text,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.intermedium)),
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.8.dp)
                .background(color = Color(0xFFE0E0E0))
        ){}
    }
}