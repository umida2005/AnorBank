package com.example.anorbank.presentation.main.payment.componenetsimport


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.anorbank.ui.theme.Anor_hint
import com.example.anorbank.ui.theme.Anor_hinting

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray),
        topBar = {
            SearchBar()
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            // Your content here
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }

    TextField(
        value = searchQuery,
        onValueChange = { searchQuery = it },
        modifier = Modifier.background(color = Color.White)
            .fillMaxWidth()
            .padding(16.dp),
        placeholder = {
            Text(
                text = "Search...",
                color = Color.Gray
            )
        },
        trailingIcon = {
            if (searchQuery.text.isNotEmpty()) {
                IconButton(onClick = { searchQuery = TextFieldValue("") }) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = "Clear text"
                    )
                }
            } else {
                Icon(
                    imageVector = Icons.Filled.Search,
                    tint = Anor_hinting,
                    contentDescription = "Search icon"
                )
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent, // Use containerColor for the background
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Preview
@Composable
fun PaymentPrevss() {
    MyApp()
}