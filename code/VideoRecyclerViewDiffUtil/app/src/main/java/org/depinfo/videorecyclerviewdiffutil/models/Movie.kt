package org.depinfo.videorecyclerviewdiffutil.models

data class Movie(
    val id: Int,
    val name: String,
    val director: String,
    val year: Int,
    var vu: Boolean,
)
