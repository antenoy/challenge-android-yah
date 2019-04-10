package com.challenge.mob.repository.maincategory

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class JsonRessources(
    @JsonProperty("resources")
    val resources: List<JsonMainCategory>
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class JsonMainCategory(
    @JsonProperty("id")
    val id: String,

    @JsonProperty("name")
    val name: String,

    @JsonProperty("parent")
    val parent: JsonParent?
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class JsonParent(
    @JsonProperty("id")
    val id: String
)