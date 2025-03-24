package com.example.anorbank.presentation.profile.compo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anorbank.R
import com.example.anorbank.ui.theme.Anor_dark
import com.example.anorbank.ui.theme.Anor_grey
import com.example.anorbank.ui.theme.Anor_hinting
import com.example.anorbank.utils.spacers.SpacerHSixteen
import com.example.anorbank.utils.spacers.SpacerWSixteen


@Composable
fun ProfiData() {

    Column(modifier = Modifier.fillMaxWidth()) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(18.dp))
                .padding(14.dp)
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(22.dp),
                painter = painterResource(id = R.drawable.ic_profile_sc),
                contentDescription = null
            )
            SpacerWSixteen()
            Text(
                text = stringResource(id = R.string.prof_client_data),
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(0.6f),
                fontSize = 14.sp,
                color = Anor_grey,
                fontFamily = FontFamily(Font(R.font.monsbold))
            )
            Image(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 12.dp)
                    .size(24.dp),
                painter = painterResource(id = R.drawable.ic_exclam),
                colorFilter = ColorFilter.tint(Anor_dark),
                contentDescription = null
            )
        }

    }
}

@Composable
fun ProfiTheme() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(18.dp))
            .padding(12.dp)
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .size(22.dp),
            painter = painterResource(id = R.drawable.ic_settings),
            contentDescription = null
        )
        SpacerWSixteen()
        Text(
            text = stringResource(id = R.string.prof_theme),
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(0.6f),
            fontSize = 14.sp,
            color = Anor_grey,
            fontFamily = FontFamily(Font(R.font.monsbold))
        )

    }
}

@Composable
fun ProfiLang() {
    Column(modifier = Modifier.fillMaxWidth()) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(18.dp))
                .padding(12.dp)
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(22.dp),
                painter = painterResource(id = R.drawable.ic_globe_lang),
                contentDescription = null
            )
            SpacerWSixteen()
            Text(
                text = stringResource(id = R.string.prof_language),
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(0.6f),
                fontSize = 14.sp,
                color = Anor_grey,
                fontFamily = FontFamily(Font(R.font.monsbold))
            )
            Text(
                text = stringResource(id = R.string.prof_language),
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 12.dp),
                fontSize = 14.sp,
                color = Anor_hinting,
                fontFamily = FontFamily(Font(R.font.monsbold))
            )
        }

    }
}

@Composable
fun ProfiSec() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(18.dp))
            .padding(12.dp)
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .size(22.dp),
            painter = painterResource(id = R.drawable.ic_security),
            contentDescription = null
        )
        SpacerWSixteen()
        Text(
            text = stringResource(id = R.string.prof_security),
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(0.6f),
            fontSize = 14.sp,
            color = Anor_grey,
            fontFamily = FontFamily(Font(R.font.monsbold))
        )

    }
}


@Composable
fun ProfiPolicy() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(18.dp))
            .padding(12.dp)
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .size(22.dp),
            painter = painterResource(id = R.drawable.ic_doc),
            contentDescription = null
        )
        SpacerWSixteen()
        Text(
            text = stringResource(id = R.string.prof_agreement),
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(0.6f),
            fontSize = 14.sp,
            color = Anor_grey,
            fontFamily = FontFamily(Font(R.font.monsbold))
        )

    }
}


@Composable
fun ProfiAgree() {

    Column(modifier = Modifier.fillMaxWidth()) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(18.dp))
                .padding(12.dp)
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(22.dp),
                painter = painterResource(id = R.drawable.ic_doc),
                contentDescription = null
            )
            SpacerWSixteen()
            Text(
                text = stringResource(id = R.string.prof_prpl),
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(0.6f),
                fontSize = 14.sp,
                color = Anor_grey,
                fontFamily = FontFamily(Font(R.font.monsbold))
            )
            Image(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 12.dp)
                    .size(24.dp),
                painter = painterResource(id = R.drawable.ic_external_link),
                colorFilter = ColorFilter.tint(Anor_dark),
                contentDescription = null
            )
        }


    }
}


@Composable
fun ProfExtras() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(18.dp))
            .background(Anor_hinting)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(18.dp))
                .background(Anor_hinting)
                .padding(12.dp)
        ) {

            SpacerWSixteen()
            Text(
                text = "",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(0.6f),
                fontSize = 14.sp,
                color = Anor_grey,
                fontFamily = FontFamily(Font(R.font.monsbold))
            )
            Image(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 12.dp)
                    .size(24.dp),
                painter = painterResource(id = R.drawable.ic_question_mark),
                contentDescription = null
            )
        }

    }

}


@Composable
fun PhoneFunProfi(text: String, modifier: Modifier) {
    Text(modifier = modifier,
        text = text,
        fontFamily = FontFamily(Font(R.font.monsbold)),
        color = Anor_grey
    )
}

@Preview
@Composable
fun ProfiItemPrev() {
    ProfExtras()
}
