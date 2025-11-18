package net.iessochoa.fernandorodriguez.testexamencafe.Componentes_Cafetera

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.fernandorodriguez.testexamencafe.R
import net.iessochoa.fernandorodriguez.testexamencafe.ui.theme.TestExamenCafeTheme

@Composable
fun cofeeSelector(
    opciones: Array<String>,
    opcionSeleccionada: String,
    onOpcionSeleccionada: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    val cofeeType = arrayOf(stringArrayResource(R.array.cafes))

    Column(
        modifier = Modifier
            .selectableGroup() // Digo que es un grupo de selección
            .fillMaxWidth()
    ) {

        opciones.forEach { texto ->
            Row(
                modifier = Modifier
                    .selectable(
                        selected = (texto == opcionSeleccionada),
                        onClick = { onOpcionSeleccionada(texto) },
                        role = Role.RadioButton
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (texto == opcionSeleccionada) ,
                    onClick = { onOpcionSeleccionada(texto) }
                )
                    Text(
                        text= texto,
                    )

            }
        }

    }

}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun selectorPreview() {

    TestExamenCafeTheme {

        var arrayCafes = stringArrayResource(R.array.cafes)
        var selectedOption by remember { mutableStateOf(arrayCafes[0]) }

        cofeeSelector(arrayCafes, selectedOption, {selectedOption = it})

    }

}