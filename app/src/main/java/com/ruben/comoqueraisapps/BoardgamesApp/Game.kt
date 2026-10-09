package com.ruben.comoqueraisapps.BoardgamesApp

data class Game (val name: String, val category: GameCategory, var isSelected: Boolean = true)