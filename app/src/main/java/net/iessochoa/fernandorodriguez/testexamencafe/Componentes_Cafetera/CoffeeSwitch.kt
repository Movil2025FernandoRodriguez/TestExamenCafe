package net.iessochoa.fernandorodriguez.testexamencafe.Componentes_Cafetera

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.fernandorodriguez.testexamencafe.R
import net.iessochoa.fernandorodriguez.testexamencafe.ui.theme.TestExamenCafeTheme

@Composable
fun coffeeSwitch(cafeina: Boolean,
                 onSelectedCaffeine: (Boolean) -> Unit){
    Row (modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = if (cafeina) "Con cafeina" else "Sin cafeina",
            fontWeight = if (cafeina) FontWeight.Bold else FontWeight.Normal
        )
        Spacer(
            modifier = Modifier
                .width(16.dp)
        )
        Switch(
            checked = cafeina,
            onCheckedChange = onSelectedCaffeine
        )
    }
}

@Composable
fun palito(
    palito: Boolean,
    onSelectedPalito: (Boolean) -> Unit
){

    Column(modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(
            text = "¿Quieres palito?"
        )
        Row {
            Text(text = if (!palito) "Sin palito" else "Palito añadido")
        }
        Switch(
            checked = palito,
            onCheckedChange = onSelectedPalito
        )
        if(palito) {
            Image(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp),
                painter = painterResource(R.drawable.palito),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

    }

}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun switchPrefiew(){


    var conCafeina by remember { mutableStateOf(false) }

    TestExamenCafeTheme {
        coffeeSwitch(conCafeina, {conCafeina = it})
    }

}