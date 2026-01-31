package org.openmind.mentalhealth

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform