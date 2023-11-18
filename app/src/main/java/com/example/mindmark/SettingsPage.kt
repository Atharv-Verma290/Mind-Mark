package com.example.mindmark

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mindmark.ui.theme.md_theme_light_onSurfaceVariant
import com.example.mindmark.ui.theme.md_theme_light_outlineVariant
import com.example.mindmark.ui.theme.md_theme_light_surface

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsPage(){
    Surface(modifier = Modifier.fillMaxSize(), color = md_theme_light_surface) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = { Text(text = "Settings") },
                    navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Default.ArrowBack,"back to home")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = md_theme_light_surface,
                        navigationIconContentColor = md_theme_light_onSurfaceVariant,
                        titleContentColor = md_theme_light_onSurfaceVariant,

                    )
                )
            },
            containerColor = md_theme_light_surface
        ) { innerPadding ->
            var isExpanded by remember{
                mutableStateOf(false)
            }
            var theme by remember{
                mutableStateOf("Theme")
            }
            ExposedDropdownMenuBox(
                expanded = isExpanded,
                onExpandedChange = {isExpanded = it},
                modifier = Modifier.padding(innerPadding)
            ) {
                TextField(
                    value = theme,
                    onValueChange = {},
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth(),
                    readOnly = true,
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = md_theme_light_surface,
                        unfocusedContainerColor = md_theme_light_surface,
                        unfocusedTextColor = md_theme_light_onSurfaceVariant,
                        focusedTextColor = md_theme_light_onSurfaceVariant,
                        unfocusedIndicatorColor = md_theme_light_outlineVariant,
                        focusedIndicatorColor = md_theme_light_outlineVariant
                    )
                )
                ExposedDropdownMenu(
                    expanded = isExpanded,
                    onDismissRequest = { isExpanded = false },
                    modifier = Modifier.background(md_theme_light_surface)
                ) {
                    DropdownMenuItem(
                        text = { Text(text = "Light") },
                        onClick = {
                            theme = "Light"
                            isExpanded = false
                        },
                        colors = MenuDefaults.itemColors(
                            textColor = md_theme_light_onSurfaceVariant,
                        )
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Dark") },
                        onClick = {
                            theme = "Dark"
                            isExpanded = false
                        },
                        colors = MenuDefaults.itemColors(
                            textColor = md_theme_light_onSurfaceVariant,
                        )
                    )
                    DropdownMenuItem(
                        text = { Text(text = "System default") },
                        onClick = {
                            theme = "System default"
                            isExpanded = false
                        },
                        colors = MenuDefaults.itemColors(
                            textColor = md_theme_light_onSurfaceVariant,
                        )
                    )
                }
            }
        }
    }
}
