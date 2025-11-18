package net.iessochoa.fernandorodriguez.testexamencafe.Componentes_Cafetera

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.iessochoa.fernandorodriguez.testexamencafe.ui.theme.TestExamenCafeTheme



@Composable
fun topTittle(){

    Column (modifier = Modifier) {
        Row(modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Prepare your own cofee ",
                fontSize = 30.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold
            )
        }
        Row(modifier = Modifier
            .padding(top = 30.dp, start = 10.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.Left
        ) {
            Text(
                text = "Selecciona el típo de café",
                fontSize = 20.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold
            )
        }

    }

}








@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun tittlePreview(){

    TestExamenCafeTheme {

        topTittle()

    }

}