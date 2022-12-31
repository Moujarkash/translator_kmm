package com.mod.translator_kmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform