package com.example.newskmp.presentatation.store

import com.example.newskmp.presentatation.ui.component.state.SearchWidgetState

sealed class FavoriteScreenEvent {
    data object GetFavoriteArticles: FavoriteScreenEvent()
    data class SearchArticles(val searchText: String): FavoriteScreenEvent()
    data class UpdateAppBarState(val searchWidgetState: SearchWidgetState): FavoriteScreenEvent()

    data class UpdateSearchText(val text: String): FavoriteScreenEvent()
}