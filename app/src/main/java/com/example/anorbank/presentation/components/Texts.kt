package com.example.anorbank.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import com.example.anorbank.R
import com.example.anorbank.ui.theme.Anor_dark
import com.example.anorbank.ui.theme.Anor_grey
import kotlin.math.absoluteValue


@Composable
fun TextNormal(
    text: String,
    maxLength: Int = Int.MAX_VALUE,
    modifier: Modifier = Modifier,
    color: Color = Anor_grey,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = FontFamily(Font(R.font.monsbold)),
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    softWrap: Boolean = true,
    maxLines: Int = 1,
    minLines: Int = 1,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current
) {
    val trimmedText = if (text.length > 8) {
        text.substring(0, 8) + ".".repeat(text.length - 8) // Truncate and add dots
    } else {
        text
    }


        Text(
        text = trimmedText,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        textAlign = textAlign,
        lineHeight = lineHeight,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        minLines = minLines,
        onTextLayout = onTextLayout,
        style = style,
    )
}

@Composable
fun TextCompo(
    modifier: Modifier,
    fontik: FontFamily,
    fontSize: TextUnit = 16.sp,
    text: String,
    onCick: () -> Unit ={}
) {
    Text(
        modifier = modifier,
        textAlign = TextAlign.Center,
        text = text,
        //   platformStyle = PlatformTextStyle(includeFontPadding = false),
        lineHeight = TextUnit(18f, TextUnitType.Sp),
        fontSize = fontSize,
        color = Anor_grey,
        fontFamily = fontik


    )
}


@Composable
fun TextCompoRed(
    modifier: Modifier,
    fontik: FontFamily,
    fontSize: TextUnit = 16.sp,
    text: String,
    onClick: () -> Unit ={}
) {
    Text(
        modifier = modifier
            .clickable(onClick = onClick),
        textAlign = TextAlign.Center,
        text = text,
        lineHeight = TextUnit(18f, TextUnitType.Sp),
        fontSize = fontSize,
        color = Anor_dark,
        fontFamily = fontik,



    )
}



@Composable
fun TextPolicy(
    modifier: Modifier,
    fontik: FontFamily,
    fontSize: TextUnit = 16.sp,
    text: String,
    onCick: () -> Unit ={}
) {
    Text(
        modifier = modifier,
        text = text,
        //   platformStyle = PlatformTextStyle(includeFontPadding = false),
        lineHeight = TextUnit(12f, TextUnitType.Sp),
        fontSize = fontSize,
        color = Anor_grey,
        fontFamily = fontik


    )
}


@Composable
fun ButtonEnabled(){

}



class MaskVisualTransformation(private val mask: String) : VisualTransformation {

    private val specialSymbolsIndices = mask.indices.filter { mask[it] != '#' }

    override fun filter(text: AnnotatedString): TransformedText {
        var out = ""
        var maskIndex = 0
        text.forEach { char ->
            while (specialSymbolsIndices.contains(maskIndex)) {
                out += mask[maskIndex]
                maskIndex++
            }
            out += char
            maskIndex++
        }
        return TransformedText(AnnotatedString(out), offsetTranslator())
    }

    private fun offsetTranslator() = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            val offsetValue = offset.absoluteValue
            if (offsetValue == 0) return 0
            var numberOfHashtags = 0
            val masked = mask.takeWhile {
                if (it == '#') numberOfHashtags++
                numberOfHashtags < offsetValue
            }
            return masked.length + 1
        }

        override fun transformedToOriginal(offset: Int): Int {
            return mask.take(offset.absoluteValue).count { it == '#' }
        }
    }
}
