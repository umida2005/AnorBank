package com.example.anorbank.zed.expendables.home_ex

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.example.anorbank.R
import com.example.anorbank.ui.theme.AnorBankTheme


class ExpandabeS: Screen {
    @Composable
    override fun Content() {

    }
}



@ExperimentalAnimationApi
@Composable
fun ExpandableD(text: String) {

    var isExpanded by rememberSaveable {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier.fillMaxWidth().clickable {
            isExpanded = !isExpanded
        }
    ) {
        Column() {

            Text(text = text,
                modifier = Modifier.padding(4.dp)
                    ,
                fontFamily = FontFamily(Font(R.font.monsbold)))

            AnimatedVisibility(visible = isExpanded) {
                Row(modifier = Modifier.clickable {
                    isExpanded = !isExpanded
                }) {
                    Button(onClick = {
                    }) {

                    }
                }
            }

        }

    }

}




@OptIn(ExperimentalAnimationApi::class)
@Composable
@Preview
fun PfofPrevs(){
    AnorBankTheme {
        ExpandableD("Keshbek")
    }
}