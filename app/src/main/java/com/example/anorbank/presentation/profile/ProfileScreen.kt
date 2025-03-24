package com.example.anorbank.presentation.profile


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.anorbank.presentation.main.services.ServiceFun
import com.example.anorbank.presentation.main.services.components.SerItemData
import com.example.anorbank.presentation.profile.compo.PhoneFunProfi
import com.example.anorbank.presentation.profile.compo.ProfExtras
import com.example.anorbank.presentation.profile.compo.ProfiAgree
import com.example.anorbank.presentation.profile.compo.ProfiData
import com.example.anorbank.presentation.profile.compo.ProfiLang
import com.example.anorbank.presentation.profile.compo.ProfiPolicy
import com.example.anorbank.presentation.profile.compo.ProfiSec
import com.example.anorbank.presentation.profile.compo.ProfiTheme
import com.example.anorbank.ui.theme.Anor_dark
import com.example.anorbank.ui.theme.Anor_grey
import com.example.anorbank.ui.theme.Anor_light_grey
import com.example.anorbank.utils.spacers.SpacerHFourtyEight
import com.example.anorbank.utils.spacers.SpacerHSixteen
import com.example.anorbank.utils.spacers.SpacerHThirtyTwo

class ProfileScreen : Screen {
    @Composable
    override fun Content() {
        ProfsFun()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfsFun() {
    val resources = LocalContext.current.resources
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
                        .height(65.dp)
                )
                TopAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    title = {
                        Row( // Use a Row to arrange title and icon horizontally
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically),
                                textAlign = TextAlign.Center,
                                text = stringResource(id = R.string.prof_name),
                                color = Color.White,
                                fontSize = 18.sp,
                                fontFamily = FontFamily(Font(R.font.monsbold)),

                            )

                              Image(modifier = Modifier.padding(end = 12.dp),
                                  painter = painterResource(id = R.drawable.ic_logout),
                                  contentDescription = null)

                        }
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
                Column (modifier = Modifier.fillMaxWidth()){
                   Row (modifier = Modifier
                       .fillMaxWidth()
                       .padding(16.dp)) {
                       Image(modifier = Modifier.weight(1f), painter = painterResource(id = R.drawable.ic_profi_head),
                           contentDescription = null)

                       Column(modifier = Modifier.weight(3f)) {

                           PhoneFunProfi(modifier = Modifier.padding(8.dp),
                               text = "+998 94 990 50 20")
                           ProfExtras()
                       }
                   }


                    Button(modifier = Modifier
                        .fillMaxWidth()

                        .padding(top = 16.dp)
                        .height(56.dp)
                        .padding(horizontal = 14.dp)
                        ,
                        colors = ButtonDefaults.buttonColors(Anor_dark),
                        shape = RoundedCornerShape(22.dp),
                        onClick = {

                        }) {
                        Text(
                            modifier = Modifier.background(color = Color.Transparent),
                            text = stringResource(id = R.string.prof_client),
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.monsbold))
                        )

                    }

                    SpacerHThirtyTwo()
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .clip(shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                            .background(color = Anor_light_grey)

                    ){


                        SpacerHSixteen()
                        Column (modifier = Modifier
                            .fillMaxWidth()
                            .weight(4f)){
                            ProfiData()
                            ProfiTheme()
                            ProfiLang()
                            ProfiSec()
                            SpacerHFourtyEight()
                            SpacerHFourtyEight()
                            SpacerHFourtyEight()
                        }

                        Spacer(modifier = Modifier.weight(2f))

                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .weight(2f)) {
                            ProfiPolicy()
                            ProfiAgree()
                        }

                        Box(modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(),
                            contentAlignment = Alignment.Center){
                            Text(
                                text = "v 2.1.0",
                                modifier = Modifier,
                                fontSize = 16.sp,
                                color = Anor_grey,
                                fontFamily = FontFamily(Font(R.font.monsbold))
                            )
                        }



                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun ProfilePreview() {
    ProfsFun()
}