package com.example.anorbank.presentation.main.services

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.example.anorbank.R
import com.example.anorbank.presentation.main.services.components.GovInsurance
import com.example.anorbank.presentation.main.services.components.GovServices
import com.example.anorbank.presentation.main.services.components.SerItemData
import com.example.anorbank.presentation.main.services.components.ServiceItems
import com.example.anorbank.ui.theme.Anor_dark
import com.example.anorbank.utils.spacers.SpacerHSixteen

class ServiceScreen : Screen {
    @Composable
    override fun Content() {
        ServiceFun()
    }
}


@Preview
@Composable
fun PrevService() {
    ServiceFun()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServiceFun() {
    val resources = LocalContext.current.resources
    val lists = listOf(
        SerItemData(R.drawable.ser1, title = resources.getString(R.string.ser_kross)),
        SerItemData(R.drawable.ser2, title = resources.getString(R.string.ser_order)),
        SerItemData(R.drawable.ser3, title = resources.getString(R.string.ser_vklad)),
        SerItemData(R.drawable.ser4, title = resources.getString(R.string.ser_rassrochka)),
        SerItemData(R.drawable.ser5, title = resources.getString(R.string.ser_credits)),
        SerItemData(R.drawable.ser6, title = resources.getString(R.string.ser_myhome)),

    )


    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back_toolbar),
                    contentDescription = "App Bar Background",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp)
                )
                TopAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    title = {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Center),
                            text = stringResource(id = R.string.service_all),
                            color = Color.White,
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.monsbold)),
                            textAlign = TextAlign.Center
                        )
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Transparent)
                )
            }
        }) {

        Box(
            modifier = Modifier
                .background(color = Anor_dark)
                .padding(it)
                .clip(shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
        ) {

            Box(
                modifier = Modifier
                    .background(color = Color.White)
                    .clip(shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            ) {
                LazyColumn {
                    item {
                        GovServices()
                    }

                    item {
                        GovInsurance()
                    }

                    items(lists) {
                        ServiceItems(data = it)
                    }
                    item {
                        SpacerHSixteen()
                        SpacerHSixteen()
                        SpacerHSixteen()
                    }


                }
            }
        }
    }
}
