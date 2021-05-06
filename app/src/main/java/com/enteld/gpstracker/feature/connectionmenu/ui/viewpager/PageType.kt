package com.enteld.gpstracker.feature.connectionmenu.ui.viewpager

sealed class PageType() {
    object FollowersPage: PageType()
    object FollowedPage: PageType()
}
