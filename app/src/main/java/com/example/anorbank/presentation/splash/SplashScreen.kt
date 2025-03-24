package com.example.anorbank.presentation.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import com.example.anorbank.R
import com.example.anorbank.ui.theme.AnorBankTheme
import com.example.anorbank.ui.theme.Anor_dark
import com.example.anorbank.ui.theme.Anor_light
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay

class SplashScreen : Screen {
    @SuppressLint("SuspiciousIndentation")
    @Composable
    override fun Content() {
     val viewModel = getViewModel<SplashModel>()

        
        LaunchedEffect(viewModel){
              delay(200)
            viewModel.onEventDispatcher(SplashContract.Intent.NextScreen)
        }
        SplashUi(viewModel::onEventDispatcher)
    }

    @SuppressLint("NotConstructor")
    @Composable
    fun SplashUi(onEventDispatcher: (SplashContract.Intent)->Unit) {

        val systemUiController = rememberSystemUiController()
        val useDarkIcons = !isSystemInDarkTheme()

        DisposableEffect(systemUiController, useDarkIcons) {

            systemUiController.setSystemBarsColor(
                color = Anor_dark, darkIcons = useDarkIcons
            )
            systemUiController.setStatusBarColor(Color.Black)
            onDispose {}
        }
        Box(
            modifier = androidx.compose.ui.Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Anor_light, Anor_dark),
                    )
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_anor),
                contentDescription = "App icon",
                modifier = androidx.compose.ui.Modifier
                    .align(Alignment.Center)
                    .size(width = 160.dp, height = 160.dp)
            )
        }
    }


    @Composable
    @Preview
    fun SplashPrev() {
        AnorBankTheme {

        }
    }
}









