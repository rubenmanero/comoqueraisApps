package com.ruben.comoqueraisapps.SuperheroApp

import com.google.gson.annotations.SerializedName

data class SuperheroDetailResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats: PowerStatsResponse,
    @SerializedName("image") val image: SuperheroImageDetailResponse,
    @SerializedName("biography") val biography: Biography,
    @SerializedName("appearance") val appearance: Appearance
)

data class PowerStatsResponse(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String
)

data class SuperheroImageDetailResponse(@SerializedName("url") val url:String)

data class Biography(
    @SerializedName("full-name") val fullName:String,
    @SerializedName("publisher") val publisher:String,
    @SerializedName("place-of-birth") val birthPlace:String,
    @SerializedName("alter-egos") val alteregos:String,
    @SerializedName("aliases") val aliases:List<String>,
    @SerializedName("first-appearance") val firstAppearance:String
)

data class Appearance(
    @SerializedName("race") val race:String,
    @SerializedName("publisher") val publisher:String,
    @SerializedName("height") val height:List<String>,
    @SerializedName("weight") val weight:List<String>
)