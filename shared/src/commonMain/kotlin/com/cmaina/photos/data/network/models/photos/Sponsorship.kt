package com.cmaina.photos.data.network.models.photos

import kotlinx.serialization.SerialName

data class Sponsorship(
    @SerialName("impression_urls")
    val impression_urls: List<String>?,
    @SerialName("sponsor")
    val sponsor: Sponsor?,
    @SerialName("tagline")
    val tagline: String?,
    @SerialName("tagline_url")
    val tagline_url: String?
)