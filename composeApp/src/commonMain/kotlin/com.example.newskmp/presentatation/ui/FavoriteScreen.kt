package com.example.newskmp.presentatation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

class FavoriteScreen: Tab {
    @Composable
    override fun Content() {

    }

    override val options: TabOptions
        @Composable
        get() = remember {
            TabOptions(
                index = 1u,
                title = "Favorite",
                icon = null
            )
        }
}