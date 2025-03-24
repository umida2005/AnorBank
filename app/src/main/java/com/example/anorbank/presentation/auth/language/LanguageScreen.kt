package com.example.anorbank.presentation.auth.language

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat.recreate
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import com.example.anorbank.R
import com.example.anorbank.ui.theme.AnorBankTheme
import com.example.anorbank.ui.theme.Anor_dark
import com.example.anorbank.ui.theme.Anor_light
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import java.util.Locale

class LanguageScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<LanguageModel>()
        Lang(viewModel::onEventDispatcher)
    }

    @Composable
    fun Lang(onEventDispatcher: (LanguageContract.Intent) -> Unit, ) {
        val context = LocalContext.current

        val viewModel = getViewModel<LanguageModel>()
        var currentLanguage = remember { mutableStateOf("") }
        val systemUiController = rememberSystemUiController()
        val useDarkIcons = !isSystemInDarkTheme()

        DisposableEffect(systemUiController, useDarkIcons) {

            systemUiController.setSystemBarsColor(
                color = Anor_dark, darkIcons = useDarkIcons
            )
            systemUiController.setStatusBarColor(Color.Black)
            onDispose {}
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Anor_light, Anor_dark),
                    )
                )
        ) {
            Column(modifier = Modifier.weight(1f)) {

            }

            Column(modifier = Modifier.weight(1f)) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_anor),
                        contentDescription = "App icon",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(top = 12.dp)
                            .size(width = 140.dp, height = 140.dp)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = stringResource(id = R.string.welcoming),
                    color = Color.White,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.monsbold))
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = stringResource(id = R.string.anor),
                    color = Color.White,
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.monsbold))
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = stringResource(id = R.string.language_option).toString(),
                    color = Color.White,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.monsbold))
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Spacer(modifier = Modifier.padding(start = 40.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_uz),
                        contentDescription = "UZBEK",

                        Modifier
                            .size(100.dp)
                            .clickable {
                                setLocate(context =context, "uz")
                                currentLanguage.value = "uz"
                                viewModel.selectedLanguage(currentLanguage.value)
                                onEventDispatcher(LanguageContract.Intent.openAuthPhone)
                            }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_ru),
                        contentDescription = "RUSSIAN",
                        Modifier
                            .size(100.dp)
                            .clickable {
                                setLocate(context =context, "ru")
                                currentLanguage.value = "ru"
                                viewModel.selectedLanguage(currentLanguage.value)
                                onEventDispatcher(LanguageContract.Intent.openAuthPhone)
                            }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_en),
                        contentDescription = "ENGLISH",
                        Modifier
                            .size(100.dp)
                            .clickable {
                                setLocate(context =context, "eng")
                                currentLanguage.value = "en"
                                viewModel.selectedLanguage(currentLanguage.value)
                                onEventDispatcher(LanguageContract.Intent.openAuthPhone)
                            }
                    )
                    Spacer(modifier = Modifier.padding(start = 40.dp))
                }

            }
        }

    }


    private fun setLocate(context: Context, language: String) {
        val activity =context as Activity
        val resources: Resources = context.resources
        val configuration = resources.configuration
        configuration.setLocale(Locale(language))
        resources.updateConfiguration(configuration, resources.displayMetrics)
        recreate(activity)
    }

    @Composable
    @Preview
    fun LangPreview() {
        AnorBankTheme {

        }
    }
}