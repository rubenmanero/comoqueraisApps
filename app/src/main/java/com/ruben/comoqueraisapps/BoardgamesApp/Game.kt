package com.ruben.comoqueraisapps.BoardgamesApp

data class Game (val name: String, val categorie: GameCategory, var isSelected: Boolean = true)