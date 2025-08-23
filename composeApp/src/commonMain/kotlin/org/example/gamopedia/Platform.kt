package org.example.gamopedia

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform