package net.iessochoa.fernandorodriguez.testexamencafe.Componentes_Cafetera

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.fernandorodriguez.testexamencafe.R
import net.iessochoa.fernandorodriguez.testexamencafe.ui.theme.TestExamenCafeTheme

@Composable
fun impresionImagen(opcionSeleccionada: String
                    ){

    var arrayCafes = stringArrayResource(R.array.cafes)

    val mapaCafes = mapOf(
        arrayCafes[0] to R.drawable.cortado,
        arrayCafes[1] to R.drawable.solo,
        arrayCafes[2] to R.drawable.con_leche
    )

    Column (modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Image(
            modifier = Modifier
                .height(200.dp)
                .width(200.dp),
            painter = painterResource(mapaCafes.get(opcionSeleccionada)!!),
            // Se le pone las dos !! para que sepa que siempre va a existir la imagen
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

    }

}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun imagenPreview(){

    TestExamenCafeTheme {

    }

}