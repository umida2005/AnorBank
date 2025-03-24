package com.example.anorbank.presentation.auth.keyword

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import com.example.anorbank.R
import com.example.anorbank.presentation.auth.register.reg.RegContract
import com.example.anorbank.presentation.auth.register.reg.StringInputField
import com.example.anorbank.presentation.components.TextCompo
import com.example.anorbank.ui.theme.Anor_light_grey

class KeywordScreen: Screen {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<KeywordModel>()
        Keyword(viewModel::onEventDispatcher)
    }


    @Composable
        fun Keyword(onEventDispatcher :(KeywordContract.MyIntent.NextMain)->Unit){
        var keyWord by rememberSaveable { mutableStateOf("") }
        var isButtonEnabled = keyWord.length >= 6 && keyWord.length<=12
        Column (modifier = Modifier
            .fillMaxSize()
            .background(color = Anor_light_grey)){


            Column (modifier = Modifier.weight(1f)){

            }
            Box(modifier = Modifier
                .weight(1.5f)
                .align(Alignment.CenterHorizontally)){
                Image(modifier = Modifier
                    .size(150.dp, 150.dp)
                    .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.ic_keyword),
                    contentDescription = "Back",
                )
            }

            Column (modifier= Modifier
                .weight(1.3f)
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Spacer(modifier = Modifier.height(16.dp))
                TextCompo(modifier = Modifier,FontFamily(Font(R.font.monsbold)), fontSize = 18.sp, stringResource(id = R.string.keyword_title))
                Spacer(modifier = Modifier.height(16.dp))
                TextCompo(modifier = Modifier,FontFamily(Font(R.font.monsbold)),
                    fontSize = 12.sp,
                    stringResource(id = R.string.keyword_text))
                Spacer(modifier = Modifier.height(16.dp))

            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.9f)
                    .padding(horizontal = 24.dp)
                    .clip(shape = RoundedCornerShape(24.dp))
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                ){

                    Spacer(modifier = Modifier.height(24.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .padding(horizontal = 24.dp)
                            .background(color = Anor_light_grey, shape = RoundedCornerShape(16.dp)),
                    ) {
                        StringInputField(
                            hint = stringResource(id = R.string.reg_password),
                            text = keyWord,
                            onValueChanged = { newText ->
                                keyWord = newText

                            }
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                    Button(

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .padding(horizontal = 24.dp),
                        shape = RoundedCornerShape(16.dp),

                        enabled = isButtonEnabled,
                        onClick = {


                            onEventDispatcher(KeywordContract.MyIntent.NextMain)
                        }){
                        Text(
                            modifier = Modifier.background(color = Color.Transparent),
                            text = stringResource(id = R.string.btn_continue)
                        )
                    }



                }
                Spacer(modifier = Modifier.height(24.dp))


            }

            Box(modifier = Modifier.weight(2f)){

            }
        }
    }

    @Composable
    @Preview
    fun PhonePreview(){
        Keyword({})
    }
}