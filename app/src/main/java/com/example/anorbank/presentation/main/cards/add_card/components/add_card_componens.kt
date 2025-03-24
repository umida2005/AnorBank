package com.example.anorbank.presentation.main.cards.add_card.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anorbank.R
import com.example.anorbank.ui.theme.Anor_grey
import com.example.anorbank.utils.spacers.SpacerWSixteen
import com.example.anorbank.utils.spacers.SpacerWThirtyTwo
import com.example.anorbank.utils.spacers.SpacerWTwentyFour

@Composable
fun MyTop( modifier : Modifier,title: String ) {
    Row(modifier = Modifier
        .height(56.dp)
        .background(color = Color.White)
        .fillMaxWidth()) {

        Image(modifier = Modifier
            .size(26.dp)
            .padding(start = 12.dp)
            .align(Alignment.CenterVertically)
            .clickable {

            },
            painter = painterResource(id = R.drawable.ic_back_left),
            contentDescription = null)

        SpacerWThirtyTwo()

        Text(modifier = Modifier.align(Alignment.CenterVertically), text = title,
            color = Anor_grey, fontSize = 20.sp)
    }
}

@Preview
@Composable
fun PrevAddCard() {
}