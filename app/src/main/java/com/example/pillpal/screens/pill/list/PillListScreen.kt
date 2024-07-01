package com.example.pillpal.screens.pill.list

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pillpal.components.CardItem
import com.example.pillpal.components.PlanCard
import com.example.pillpal.components.Search
import com.example.pillpal.ui.theme.PillPalTheme

@Composable
fun PillListScreen() {
    PillListScreenSkeleton()
}

@Preview(showBackground = true)
@Composable
private fun PillListScreenSkeletonPreview() {
    PillPalTheme {
        PillListScreenSkeleton()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PillListScreenSkeletonPreviewDark() {
    PillPalTheme {
        PillListScreenSkeleton()
    }
}

@Composable
fun PillListScreenSkeleton() {
    Scaffold {
        Column(
            modifier =
                Modifier
                    .padding(it)
                    .padding(top = 16.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Search(
                query = "",
                onQueryChange = {},
                onSearch = {},
                active = false,
                onActiveChange = {},
                placeholder = { Text(text = "Search") },
                leadingIcon = {
                    Icon(Icons.Filled.Search, contentDescription = "search")
                },
            ) {}
            Spacer(modifier = Modifier.height(32.dp))
            PlanCard(
                userName = "Fahim",
                completedPill = 2,
                totalPill = 4,
            )
            Column(
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            ) {
                Text(
                    text = "Daily Review",
                    modifier = Modifier.padding(top = 16.dp, start = 32.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                )
                LazyColumn(
                    modifier = Modifier.height(400.dp),
                    contentPadding = PaddingValues(top = 16.dp, start = 32.dp, end = 32.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    items(10) {
                        CardItem(
                            pillName = "Napa extra",
                            "01:40 PM",
                            completed = true,
                        )
                    }
                }
            }
        }
    }
}
