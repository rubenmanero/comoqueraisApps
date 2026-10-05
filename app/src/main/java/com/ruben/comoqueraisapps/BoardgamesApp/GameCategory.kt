package com.ruben.comoqueraisapps.BoardgamesApp

sealed class GameCategory (var isSelected: Boolean = true) {
    object DeckBuilding: GameCategory()
    object Euro: GameCategory()
    object LCG: GameCategory()
    object Cooperative: GameCategory()
    object Legacy: GameCategory()
}