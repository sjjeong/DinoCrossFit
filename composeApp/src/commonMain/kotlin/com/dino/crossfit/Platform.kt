package com.dino.crossfit

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform