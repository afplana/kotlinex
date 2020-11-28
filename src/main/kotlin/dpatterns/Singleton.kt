package dpatterns

class Singleton private constructor() {

    val host = "localhost"
    val port = 9090

    private object UNIQUE {
        val INSTANCE = Singleton()
    }
    companion object {
        val instance: Singleton by lazy { UNIQUE.INSTANCE }
    }
}

fun main() {
    println("https://${Singleton.instance.host}:${Singleton.instance.port}")
}
