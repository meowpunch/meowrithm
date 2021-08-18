package others

class TestKotlin {}

data class KDA(var a: Int) {
}

class KA(var a: Int) {}

fun inplaceKDA(a: KDA) {
    a.a = 2
}

fun inplaceKA(a: KA) {
    a.a = 2
}

fun main() {
    val i1 = KDA(1)
    val i2 = KA(1)

    inplaceKDA(i1)
    inplaceKA(i2)

    println(i1)
    println(i2.a)
}
