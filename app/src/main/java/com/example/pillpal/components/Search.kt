package com.example.pillpal.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Search(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: () -> Unit,
    active: Boolean,
    onActiveChange: (Boolean) -> Unit,
    placeholder: @Composable () -> Unit,
    leadingIcon: @Composable () -> Unit,
    trailingIcon: @Composable () -> Unit,
) {
    Box(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .background(color = Color(0xFFF5F5F3), shape = RoundedCornerShape(8.dp))
                .padding(16.dp),
        contentAlignment = Alignment.CenterStart,
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Icon(Icons.Filled.Search, contentDescription = null, tint = Color(0xFF9A9A9A))
        Text(modifier = Modifier.padding(start = 32.dp), text = "Search", color = Color(0xFF9A9A9A))
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        Search(
            query = "",
            onQueryChange = {},
            onSearch = {},
            active = false,
            onActiveChange = {},
            placeholder = {},
            leadingIcon = {},
            trailingIcon = {},
        )
    }
}
