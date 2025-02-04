package br.senai.sp.jandira.s_book.components.announceDetail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.s_book.R

@Preview(showSystemUi = true)
@Composable
fun FooterDescricao() {

    Column(
        modifier = Modifier
            .width(313.dp)
            .height(404.dp)
            .padding(start = 18.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Descrição",
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.intermedium)),
            fontWeight = FontWeight(600),
            color = Color(0xFF000000),
        )
        Text(
            text = "A escola não é uma experiência agradável para " +
                    "o quase adolescente Greg Heffley, mas sim um campo minado que ele " +
                    "precisa enfrentar.",
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.intermedium)),
            fontWeight = FontWeight(400),
            color = Color(0xFF9F9898),
        )
        Column(
            modifier = Modifier
                .width(313.dp)
                .height(200.dp),
        ) {

            Text(
                text = "Especificações",
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.intermedium)),
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
            )
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp),
                horizontalArrangement = Arrangement.spacedBy(80.dp),
                verticalAlignment = Alignment.Top,
            ) {
                Text(
                    text = "Ano da edição",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.intermedium)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                )
                Text(
                    text = "2022",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.intermedium)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF7E7D7A)
                )
            }
            Column(
                modifier = Modifier
                    .padding(0.dp)
                    .width(320.dp)
                    .height(0.8.dp)
                    .background(color = Color(0xFFE0E0E0))
            ) {}

            // segundo componente
            Spacer(modifier = Modifier.height(6.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp),
                horizontalArrangement = Arrangement.spacedBy(137.dp),
                verticalAlignment = Alignment.Top,
            ) {
                Text(
                    text = "Autor",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.intermedium)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                )
                Text(
                    text = "Thiago Freitas",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.intermedium)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF7E7D7A)
                )
            }
            Column(
                modifier = Modifier
                    .padding(0.dp)
                    .width(320.dp)
                    .height(0.8.dp)
                    .background(color = Color(0xFFE0E0E0))
            ) {}

            //terceiro componente
            Spacer(modifier = Modifier.height(6.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp),
                horizontalArrangement = Arrangement.spacedBy(127.dp),
                verticalAlignment = Alignment.Top,
            ) {
                Text(
                    text = "Editora",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.intermedium)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                )
                Text(
                    text = "Saraiva",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.intermedium)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF7E7D7A)
                )
            }
            Column(
                modifier = Modifier
                    .padding(0.dp)
                    .width(320.dp)
                    .height(0.8.dp)
                    .background(color = Color(0xFFE0E0E0))
            ) {}

            //ultimo componente
            Spacer(modifier = Modifier.height(6.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp),
                horizontalArrangement = Arrangement.spacedBy(128.dp),
                verticalAlignment = Alignment.Top,
            ) {
                Text(
                    text = "Idioma",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.intermedium)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                )
                Text(
                    text = "Português",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.intermedium)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF7E7D7A)
                )
            }
            Column(
                modifier = Modifier
                    .padding(0.dp)
                    .width(320.dp)
                    .height(0.8.dp)
                    .background(color = Color(0xFFE0E0E0))
            ) {}
        }
    }

}