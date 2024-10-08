package com.cmaina.photos.presentation.utils

import org.jetbrains.compose.resources.StringResource
import photos.shared.generated.resources.Res
import photos.shared.generated.resources.language_ar
import photos.shared.generated.resources.language_de
import photos.shared.generated.resources.language_en
import photos.shared.generated.resources.language_it

data class Language(
    val name: String,
    val initials: String,
    val resource: StringResource,
    val shouldShowInRTL: Boolean = false
)

val LanguageList = listOf(
    Language("English", "en", Res.string.language_en),
    Language("Italian", "it", Res.string.language_it),
    Language("German", "de", Res.string.language_de),
    Language("Arabic", "ar", Res.string.language_ar, true)
)