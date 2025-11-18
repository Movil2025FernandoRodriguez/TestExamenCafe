package net.iessochoa.fernandorodriguez.testexamencafe.Componentes_Cafetera

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.fernandorodriguez.testexamencafe.R
import net.iessochoa.fernandorodriguez.testexamencafe.ui.theme.TestExamenCafeTheme

@Composable
fun agregarAzucar(
    azucar: Array<String>,
    opcion: String,
    onSelection: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    var azucarero = mapOf<String, Int>(
        azucar[0] to R.drawable.nosugar,
        azucar[1] to R.drawable._azucar,
        azucar[2] to R.drawable.muchoazucar
    )

    
    Column(modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier
                .selectableGroup()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
            ) {

            azucar.forEach { texto ->
                Row(
                    modifier = Modifier
                        .selectable(
                            selected = (texto == opcion),
                            onClick = { onSelection(texto) },
                            role = Role.RadioButton
                        ),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (texto == opcion) ,
                        onClick = { onSelection(texto) }
                    )
                    Text(
                        text= texto,
                    )

                }
            }
        }
        Image(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp),
            painter = painterResource(azucarero.get(opcion)!!),
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
fun sugarPreview() {

    var sugarQuantity = stringArrayResource(R.array.sugar)
    var selectedSugar by remember { mutableStateOf(sugarQuantity[0]) }


    TestExamenCafeTheme {
        agregarAzucar(
            azucar = sugarQuantity,
            opcion = selectedSugar,
            onSelection = {selectedSugar = it},
        )
    }

}