package com.example.anorbank.presentation.main.payment.transaction.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anorbank.R
import com.example.anorbank.ui.theme.Anor_black_medium
import com.example.anorbank.ui.theme.Anor_dark
import com.example.anorbank.ui.theme.Anor_grey
import com.example.anorbank.ui.theme.Anor_hint
import com.example.anorbank.ui.theme.Anor_hinting
import com.example.anorbank.ui.theme.Anor_light_grey
import com.example.anorbank.ui.theme.Anor_white
import com.example.anorbank.utils.spacers.SpacerWEight


@Composable
fun ItemPayment(name: String, pan: String,amount: Int,  onClicks: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clickable { onClicks() }
            .border(
                width = 1.5.dp,
                color = Anor_black_medium,
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.5.dp,
                    color = Anor_hint,
                    shape = RoundedCornerShape(18.dp)
                )

                .background(Color.White),

            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(modifier = Modifier
                .weight(1.5f)
                .padding(8.dp),
                painter = painterResource(id = R.drawable.ic_uzcard),
                contentDescription = null)

            Column(modifier = Modifier.weight(6f).padding(vertical = 4.dp)) {
                Text(modifier = Modifier.weight(1f),
                    text = name)
                Text(modifier = Modifier.weight(1f), text = pan)

            }

            Text(modifier = Modifier.weight(2f),
                text = amount.toString())


        }

    }
}



@Composable
fun ItemTransaction(name: String, pan: String,amount: Int,  onClicks: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 12.dp)
            .fillMaxWidth()
            .clickable { onClicks() }
            .height(60.dp)
            .border(
                width = 0.3.dp,
                color = Anor_hinting,
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.5.dp,
                    color = Anor_hint,
                    shape = RoundedCornerShape(12.dp)
                )
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(modifier = Modifier
                .weight(1.5f)
                .padding(8.dp),
                painter = painterResource(id = R.drawable.ic_quenn),
                contentDescription = null)

            Column(modifier = Modifier
                .weight(4f)
                .padding(vertical = 4.dp)) {
                Spacer(modifier = Modifier.weight(0.3f))
                Text(modifier = Modifier.weight(1f),
                    text = name,
                    fontSize = 13.sp,
                    fontFamily = FontFamily(Font(R.font.monsbold))
                )
                Row(modifier = Modifier.weight(1f)) {

                    Text(modifier = Modifier,
                        fontFamily = FontFamily(Font(R.font.monsbold)),
                        color = Anor_hinting,
                        text = "****")
                    Text(modifier = Modifier,
                        fontFamily = FontFamily(Font(R.font.monsbold)),
                        color = Anor_hinting,
                        fontSize = 10.sp,
                        text = pan)

                }

            }

            Row(modifier = Modifier.weight(3f)) {
                Text(modifier = Modifier,
                    fontFamily = FontFamily(Font(R.font.mons_regular)),
                    color = Anor_grey,
                    text = amount.toString())

                Text(modifier = Modifier.align(Alignment.CenterVertically),
                    fontSize = 8.sp,
                    color = Anor_hinting,
                    text = ".00UZS")
                SpacerWEight()
            }


        }

    }
}


@Composable
fun ItemSelectedTransaction(name: String, pan: String,amount: Int,  onClicks: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 12.dp)
            .fillMaxWidth()
            .clickable { onClicks() }
            .height(60.dp)
            .border(
                width = 0.3.dp,
                color = Anor_hinting,
                shape = RoundedCornerShape(12.dp),

            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.5.dp,
                    color = Anor_hint,
                    shape = RoundedCornerShape(12.dp)
                )
                .background(Anor_dark),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(modifier = Modifier
                .weight(1.5f)
                .padding(8.dp),
                painter = painterResource(id = R.drawable.ic_anor_white),
                contentDescription = null)

            Column(modifier = Modifier
                .weight(4f)
                .padding(vertical = 4.dp)) {
                Spacer(modifier = Modifier.weight(0.3f))
                Text(modifier = Modifier.weight(1f),
                    text = name,
                    fontSize = 13.sp,
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.monsbold))
                )
                Row(modifier = Modifier.weight(1f)) {

                    Text(modifier = Modifier,
                        fontFamily = FontFamily(Font(R.font.monsbold)),
                        color = Anor_white,
                        text = "****")
                    Text(modifier = Modifier,
                        fontFamily = FontFamily(Font(R.font.monsbold)),
                        color = Anor_white,
                        fontSize = 10.sp,
                        text = pan)

                }

            }

            Row(modifier = Modifier.weight(3f)) {
                Text(modifier = Modifier,
                    fontFamily = FontFamily(Font(R.font.mons_regular)),
                    color = Anor_white,
                    text = amount.toString())

                Text(modifier = Modifier.align(Alignment.CenterVertically),
                    fontSize = 8.sp,
                    color = Anor_white,
                    text = ".00UZS")
                SpacerWEight()
            }


        }

    }
}





@Preview
@Composable
fun ItemPrimaryPrev() {
  ItemSelectedTransaction(name = "Uzcard", amount = 20000, pan = "78949897", onClicks = {})
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmountMoney(

    phone: String,
    hint: String,
    modifier: Modifier = Modifier,
    fontik: FontFamily, // Font family parameter
    mask: String = "",
    maskNumber: Char = '0',
    onPhoneChanged: (String) -> Unit
) {
    TextField(
        value = phone,

        onValueChange = { it ->
            onPhoneChanged(it.take(mask.count { it == maskNumber }))
        },
        placeholder = if (phone.isEmpty()) {
            { Text(text = hint, color = Anor_hinting, fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.monsbold))
            ) }
        } else null,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Anor_light_grey,
            focusedBorderColor = Anor_light_grey,
            unfocusedBorderColor = Anor_light_grey
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        visualTransformation = PhoneVisualTransformation(mask, maskNumber),
        modifier = modifier
            .padding(end = 8.dp),
        textStyle = LocalTextStyle.current.copy(color = Anor_grey, fontFamily = fontik)
    )
}


class PhoneVisualTransformation(val mask: String, val maskNumber: Char) : VisualTransformation {

    private val maxLength = mask.count { it == maskNumber }

    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = if (text.length > maxLength) text.take(maxLength) else text

        val annotatedString = buildAnnotatedString {
            if (trimmed.isEmpty()) return@buildAnnotatedString

            var maskIndex = 0
            var textIndex = 0
            while (textIndex < trimmed.length && maskIndex < mask.length) {
                if (mask[maskIndex] != maskNumber) {
                    val nextDigitIndex = mask.indexOf(maskNumber, maskIndex)
                    append(mask.substring(maskIndex, nextDigitIndex))
                    maskIndex = nextDigitIndex
                }
                append(trimmed[textIndex++])
                maskIndex++
            }
        }

        return TransformedText(annotatedString, PhoneOffsetMapper(mask, maskNumber))
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PhoneVisualTransformation) return false
        if (mask != other.mask) return false
        if (maskNumber != other.maskNumber) return false
        return true
    }


    override fun hashCode(): Int {
        return mask.hashCode()
    }
}

class PhoneOffsetMapper(val mask: String, val numberChar: Char) : OffsetMapping {

    override fun originalToTransformed(offset: Int): Int {
        var noneDigitCount = 0
        var i = 0
        while (i < offset + noneDigitCount) {
            if (mask[i++] != numberChar) noneDigitCount++
        }
        return offset + noneDigitCount
    }

    override fun transformedToOriginal(offset: Int): Int =
        offset - mask.take(offset).count { it != numberChar }
}




