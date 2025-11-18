package net.iessochoa.fernandorodriguez.testexamencafe.Componentes_Cafetera

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import net.iessochoa.fernandorodriguez.testexamencafe.R
import net.iessochoa.fernandorodriguez.testexamencafe.ui.theme.TestExamenCafeTheme


@Composable
fun mainScreen(modifier: Modifier = Modifier){

    var arrayCafes = stringArrayResource(R.array.cafes)
    var selectedOption by remember { mutableStateOf(arrayCafes[0]) }

    var sugarQuantity = stringArrayResource(R.array.sugar)
    var selectedSugar by remember { mutableStateOf(sugarQuantity[0]) }


    var conCafeina by remember { mutableStateOf(false) }

    var conPalito by remember {mutableStateOf(false)}

    val tipoMensaje = mostrarMensaje(selectedOption, conCafeina, selectedSugar)
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()


    val mapaCafes = mapOf(
        arrayCafes[0] to R.drawable.cortado,
        arrayCafes[1] to R.drawable.solo,
        arrayCafes[2] to R.drawable.con_leche
    )
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {topTittle()},
        snackbarHost = { SnackbarHost(snackbarHostState) },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                scope.launch {
                    // Muestra el mensaje en el Snackbar
                    snackbarHostState.showSnackbar(
                        message = tipoMensaje,
                        duration = SnackbarDuration.Short
                    )
                }
            }) {
                // Icon( imageVector = Icons.Filled.Favorite, contentDescription = "Mostrar Snackbar")
            }
        }
    ) { innerPadding ->



            Column (
                modifier = Modifier
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
            ){

                cofeeSelector(
                    opciones = arrayCafes,
                    opcionSeleccionada = selectedOption,
                    onOpcionSeleccionada = { selectedOption = it }
                )

                coffeeSwitch(conCafeina, {conCafeina = it})

                impresionImagen(selectedOption)

                agregarAzucar(
                    azucar = sugarQuantity,
                    opcion = selectedSugar,
                    onSelection = { selectedSugar = it }
                )
                palito(conPalito, {conPalito = it})

            }


        }
    }

private fun mostrarMensaje(
    nombreCafe: String,
    descafeinado: Boolean,
    azucar: String
): String{

    var mensaje = ""

    if (nombreCafe.isBlank()){
        mensaje = "Por favor, selecciona un café antes de continuar."
    }else if (!descafeinado){
        mensaje = "Preparando $nombreCafe con cafeína y $azucar de azucar"
    } else if (descafeinado){
        mensaje = "Preparando $nombreCafe descafeinado y $azucar de azucar"
    }

    return mensaje
}



@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun mainScreenPreview(){

    TestExamenCafeTheme {
        mainScreen()
    }

}