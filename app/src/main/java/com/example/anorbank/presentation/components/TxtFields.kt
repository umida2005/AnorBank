package com.example.anorbank.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anorbank.R
import com.example.anorbank.ui.theme.Anor_grey
import com.example.anorbank.ui.theme.Anor_hinting
import com.example.anorbank.ui.theme.Anor_light_grey

@Composable
fun PasswordTextField() {
    val password = remember { mutableStateOf("") }

    TextField(modifier = Modifier
        .clip(shape = RoundedCornerShape(8.dp))
        .background(color = Anor_light_grey),
        value = password.value,
        onValueChange = { password.value = it },
        label = { Text(stringResource(id = R.string.verify_code)) },
        visualTransformation = PasswordVisualTransformation()

    )
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneFieldSms(
    phone: String,
    modifier: Modifier = Modifier,
    mask: String = "000000",
    maskNumber: Char = '0',
    onPhoneChanged: (String) -> Unit
) {
    var hasInput by rememberSaveable { mutableStateOf(false) }
    TextField(
        value = phone,
        onValueChange = { it ->
            onPhoneChanged(it.take(mask.count { it == maskNumber }))
            hasInput = it.isNotEmpty()
        },
        placeholder = if (!hasInput) {
            { Text(stringResource(id = R.string.msg_txt), color = Anor_grey,fontFamily = FontFamily(
                Font(R.font.monsbold),

                )
            ) }
        } else null,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Anor_light_grey,
            focusedBorderColor = Anor_light_grey,
            unfocusedBorderColor = Anor_light_grey
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        visualTransformation = PhoneVisualTransformationSms(mask, maskNumber),
        modifier = modifier
            .padding(end = 8.dp, start = 8.dp)


    )
}


class PhoneVisualTransformationSms(val mask: String, val maskNumber: Char) : VisualTransformation {

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
        if (other !is PhoneVisualTransformationSms) return false
        if (mask != other.mask) return false
        if (maskNumber != other.maskNumber) return false
        return true
    }


    override fun hashCode(): Int {
        return mask.hashCode()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneField(

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
                fontFamily = FontFamily(Font(R.font.monsbold))) }
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