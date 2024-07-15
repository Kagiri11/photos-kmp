package com.cmaina.photos

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform