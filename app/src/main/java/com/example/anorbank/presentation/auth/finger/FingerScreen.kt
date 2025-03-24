package com.example.anorbank.presentation.auth.finger

import androidx.activity.ComponentActivity
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentActivity
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getScreenModel
import cafe.adriel.voyager.hilt.getViewModel
import com.example.anorbank.R
import com.example.anorbank.data.model.remote.BiometricAuthStatus
import com.example.anorbank.presentation.auth.finger.BioTouch.BioTouch
import com.example.anorbank.presentation.components.TextCompo
import com.example.anorbank.presentation.components.TextCompoRed
import com.example.anorbank.ui.theme.Anor_dark
import com.example.anorbank.ui.theme.Anor_light_grey

class FingerScreen(): Screen , FragmentActivity(){
    @Composable
    override fun Content() {

        val viewModel = getViewModel<FingerModel>()
        Fin(viewModel::onEventDispatcher)
    }


    @Composable
    fun Fin(onEventDispatcher:(FingerContract.MyIntent)->Unit){
        val activity = LocalContext.current as FragmentActivity
        val bioTouch = BioTouch(activity)
        var message by remember {
            mutableStateOf("")
        }
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
                    contentDescription = "Back",)
            }
            Column (modifier= Modifier
                .weight(1.3f)
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Spacer(modifier = Modifier.height(24.dp))
                TextCompo(modifier = Modifier,FontFamily(Font(R.font.monsbold)), fontSize = 18.sp, stringResource(id = R.string.fin_title))
                Spacer(modifier = Modifier.height(24.dp))
                TextCompo(modifier = Modifier,FontFamily(Font(R.font.monsbold)),
                    fontSize = 12.sp,
                    stringResource(id = R.string.fin_txt))
                Spacer(modifier = Modifier.height(24.dp))

            }
            Box(modifier = Modifier
                .weight(2.8f)
                .align(Alignment.CenterHorizontally)){
                Image(modifier = Modifier
                    .size(250.dp, 250.dp)
                    .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.ic_finger),
                    contentDescription = "Back",
                )
            }
            Column(modifier = Modifier
                .weight(2f)
                .fillMaxWidth()){
                TextCompoRed(modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 38.dp), fontSize = 12.sp,
                    onClick = {
                              onEventDispatcher(FingerContract.MyIntent.NextKeywordScreen)
                    },
                    fontik = FontFamily(Font(R.font.monsbold)),
                    text = stringResource(
                    id = R.string.fin_step,
                )
                )
                Spacer(modifier = Modifier.height(14.dp))
                Button(
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .padding(start = 24.dp, end = 24.dp, top = 16.dp)
                        .height(48.dp)
                        .fillMaxWidth(),
                    onClick = {
                      //  onEventDispatcher(FingerContract.MyIntent.NextKeywordScreen)
                              bioTouch.promptBioAuth(
                                  title = "Login",
                                  subTitle = "Use your finger print",
                                  negativeBtnTxt = "Cancel",
                                  fragmentActivity = activity,
                                  onSuccess = {
                                      message = "Success"
                                      onEventDispatcher(FingerContract.MyIntent.NextKeywordScreen)

                                  },
                                  onFailed = {
                                      message = "Wrong fingerprint"
                                  }
                              ) { _, error ->
                                  message = error
                              }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Anor_dark,
                    )
                ) {
                    Text(text = stringResource(id = R.string.fin_install))
                }
            }
        }
    }
    @Composable
    @Preview
    fun PhonePreview(){
        Fin({})
    }
}