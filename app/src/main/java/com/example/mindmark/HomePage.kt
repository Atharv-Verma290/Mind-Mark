package com.example.mindmark

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AddPhotoAlternate
import androidx.compose.material.icons.outlined.Archive
import androidx.compose.material.icons.outlined.Brush
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Label
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mindmark.ui.theme.md_theme_light_background
import com.example.mindmark.ui.theme.md_theme_light_onSecondaryContainer
import com.example.mindmark.ui.theme.md_theme_light_onSurface
import com.example.mindmark.ui.theme.md_theme_light_onSurfaceVariant
import com.example.mindmark.ui.theme.md_theme_light_outlineVariant
import com.example.mindmark.ui.theme.md_theme_light_scrim
import com.example.mindmark.ui.theme.md_theme_light_secondaryContainer
import com.example.mindmark.ui.theme.md_theme_light_surface
import com.example.mindmark.ui.theme.md_theme_light_surfaceVariant
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun HomePage(){
    Surface(modifier = Modifier.fillMaxSize(), color = md_theme_light_background) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet(
                    modifier = Modifier.fillMaxWidth(0.8f),
                    drawerContainerColor = md_theme_light_surfaceVariant
                ) {
                    NavigationDrawerItem(
                        label = { Text(text = "Mind Mark") },
                        selected = false,
                        onClick = { /*TODO*/ },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = md_theme_light_surfaceVariant,
                            selectedContainerColor = md_theme_light_secondaryContainer,
                        )
                    )
                    NavigationDrawerItem(
                        label = { Text(text = "Notes")}, 
                        selected = false, 
                        onClick = { scope.launch { drawerState.close() } },
                        icon = { Icon(imageVector = Icons.Outlined.Edit, contentDescription = "All notes")},
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = md_theme_light_surfaceVariant,
                            selectedContainerColor = md_theme_light_secondaryContainer,
                        )
                    )
                    Divider(color = md_theme_light_outlineVariant)
                    NavigationDrawerItem(
                        label = { Text(text = "Labels") },
                        selected = false,
                        onClick = { /*TODO*/ },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = md_theme_light_surfaceVariant,
                            selectedContainerColor = md_theme_light_secondaryContainer,
                        )
                    )
                    NavigationDrawerItem(
                        label = { Text(text = "Create new label") },
                        selected = false,
                        onClick = { /*TODO*/ },
                        icon = {Icon(Icons.Default.Add,"add label")},
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = md_theme_light_surfaceVariant,
                            selectedContainerColor = md_theme_light_secondaryContainer,
                        )
                    )
                    NavigationDrawerItem(
                        label = { Text(text = "Important") },
                        selected = false,
                        onClick = { /*TODO*/ },
                        icon = {Icon(Icons.Outlined.Label,"label")},
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = md_theme_light_surfaceVariant,
                            selectedContainerColor = md_theme_light_secondaryContainer,
                        )
                    )
                    Divider(color = md_theme_light_outlineVariant)
                    NavigationDrawerItem(
                        label = { Text(text = "Archive") },
                        selected = false,
                        onClick = { /*TODO*/ },
                        icon = {Icon(Icons.Outlined.Archive,"archived")},
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = md_theme_light_surfaceVariant,
                            selectedContainerColor = md_theme_light_secondaryContainer,
                        )
                    )
                    NavigationDrawerItem(
                        label = { Text(text = "Deleted") },
                        selected = false,
                        onClick = { /*TODO*/ },
                        icon = {Icon(Icons.Outlined.Delete,"deleted")},
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = md_theme_light_surfaceVariant,
                            selectedContainerColor = md_theme_light_secondaryContainer,
                        )
                    )
                    NavigationDrawerItem(
                        label = { Text(text = "Settings") },
                        selected = false,
                        onClick = { /*TODO*/ },
                        icon = {Icon(Icons.Outlined.Settings,"settings")},
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = md_theme_light_surfaceVariant,
                            selectedContainerColor = md_theme_light_secondaryContainer,
                        )
                    )
                }
            },
            drawerState = drawerState,
            scrimColor = md_theme_light_scrim
        ) {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            Text(text = "Mind Mark")
                        },
                        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                            containerColor = md_theme_light_surface,
                            titleContentColor = md_theme_light_onSurface
                        ),
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    contentDescription = "Menu button",
                                    tint = md_theme_light_onSurfaceVariant
                                )
                            }
                        },
                        actions = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search button"
                                )
                            }
                        }
                    )
                },
                bottomBar = {
                    BottomAppBar(
                        actions = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Outlined.Brush,
                                    contentDescription = "draw notes",
                                    tint = md_theme_light_onSurfaceVariant
                                )
                            }
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Outlined.AddPhotoAlternate,
                                    contentDescription = "Add image",
                                    tint = md_theme_light_onSurfaceVariant
                                )
                            }
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Outlined.Mic,
                                    contentDescription = "Add sound recordings",
                                    tint = md_theme_light_onSurfaceVariant
                                )
                            }
                        },
                        containerColor = md_theme_light_surfaceVariant,
                        floatingActionButton = {
                            FloatingActionButton(
                                onClick = { /*TODO*/ },
                                containerColor = md_theme_light_secondaryContainer,
                                contentColor = md_theme_light_onSecondaryContainer
                            ) {
                                Icon(Icons.Filled.Add,"Add note")
                            }
                        }
                    )
                }
            ) {innerPadding ->
                Text(modifier = Modifier.padding(innerPadding), text = "Example of scaffold with bottom app bar")
            }
        }
    }
}