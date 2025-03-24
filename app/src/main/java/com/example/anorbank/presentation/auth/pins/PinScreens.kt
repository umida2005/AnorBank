package com.example.anorbank.presentation.auth.pins

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.example.anorbank.R
import com.example.anorbank.presentation.components.TextCompo
import com.example.anorbank.ui.theme.Anor_black_medium
import com.example.anorbank.ui.theme.Anor_light_grey
import com.example.anorbank.utils.spacers.SpacerHFourtyEight
import com.example.anorbank.utils.spacers.SpacerWTwentyFour
import kotlinx.coroutines.delay
import kotlin.math.log

class PinScreens : Screen {
    @Composable
    override fun Content() {
        PinLock()
    }


}

const val pinSize = 4
const val password = "1234"

@Composable
fun PinLock() {

    val inputPin = remember { mutableListOf<Int>() }
    val error = remember { mutableStateOf<String>("") }
    val showSuccess = remember { mutableStateOf(false) }
    val context = LocalContext.current


    if (inputPin.size == 4) {
        LaunchedEffect(true) {
            delay(300)

            if (inputPin.joinToString("") == password) {
                showSuccess.value = true
                error.value = ""
            } else {
                inputPin.clear()
                error.value = context.getString(R.string.pins_wrong)
            }
        }

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Anor_light_grey),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.size(50.dp))

                Image(
                    modifier = Modifier.size(100.dp),
                    painter = painterResource(id = R.drawable.ic_pin),
                    contentDescription = "pin"
                )

                TextCompo(
                    modifier = Modifier,
                    fontik = FontFamily(Font(R.font.monsbold)),
                    text = stringResource(id = R.string.pins_enter)
                )

                SpacerWTwentyFour()

                if (!showSuccess.value) {

                    Row {
                        (0 until pinSize).forEach {
                            Icon(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .size(30.dp),
                                tint = Color.Black,

                                imageVector = if (inputPin.contains(it+1))
                                    Icons.Default.CheckCircle else Icons.Outlined.CheckCircle,
                                contentDescription = null
                            )
                        }
                    }


                }

                Text(
                    text = error.value,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(16.dp)
                )

                SpacerHFourtyEight()

                Column(
                    modifier = Modifier

                        .wrapContentSize()
                        .padding(bottom = 20.dp)
                        //.align(Alignment.BottomCenter)
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        (1..3).forEach {

                            PinKeyItem(onClick = { inputPin.add(it) }
                            ) {
                                Text(text = it.toString(),
                                    )
                            }
                        }
                    }


                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        (4..6).forEach {

                            PinKeyItem(onClick = { inputPin.add(it) }) {
                                Text(text = it.toString(),
                                )
                            }
                        }
                    }


                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        (7..9).forEach {

                            PinKeyItem(onClick = { inputPin.add(it) }) {
                                Text(text = it.toString(),
                                )
                            }
                        }
                    }
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp), horizontalArrangement = Arrangement.SpaceEvenly){

                        Image(modifier = Modifier
                            .size(25.dp)
                            .clickable { },
                            painter = painterResource(id = R.drawable.ic_touches),
                            contentDescription =null  )
                        
                        PinKeyItem(onClick = { inputPin.add(0) },
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {

                            Text(modifier = Modifier.padding(4.dp),
                                text = "0 ")
                        }

                        Image(modifier = Modifier
                            .size(25.dp)
                            .clickable {
                                if (inputPin.isNotEmpty()) {
                                    inputPin.removeLast()
                                }
                            },
                            painter = painterResource(id = R.drawable.ic_touches),
                            contentDescription =null  )
                    }
                }

            }
        }
    }

}
    @Composable
    fun PinKeyItem(
        onClick: () -> Unit,
        modifier: Modifier = Modifier.padding(8.dp),
        shape: Shape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50)),
        backgroundColor: Color = Anor_black_medium,
        contentColor: Color = contentColorFor(backgroundColor = backgroundColor),
        elevation: Dp = 4.dp,
        content: @Composable () -> Unit
    ) {

        Surface(
            modifier = Modifier.semantics {
                role = Role.Button
            },
            shape = shape,
            color = backgroundColor,
            contentColor = contentColor,
            tonalElevation = elevation,
            onClick = onClick,
            ) {
            CompositionLocalProvider (LocalContentAlpha provides contentColor.alpha){

                ProvideTextStyle(value = MaterialTheme.typography.displayMedium) {
                    Box(modifier = Modifier.defaultMinSize(minWidth = 60.dp, minHeight = 64.dp),
                     contentAlignment = Alignment.Center
                       ){
                        content()
                    }

                }
            }


        }

    }


@Preview
@Composable
fun PinssssPrev() {
    PinLock()
}
//    @Composable
//    fun LottieLoadingView(
//        context: Context,
//        file: String,
//        modifier : Modifier = Modifier,
//        iterations: Int = 10
//    ) {
//        val composition by remeber
//
//    }


