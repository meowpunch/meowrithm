val arr = arrayOf("a", "b", "c", "d", "f")

for ((i, v) in arr.withIndex()) {
    println("$i, $v")
}

for (i in arr.indices) {
    println("$i, ${arr[i]}")
}

for (i in arr.toList().chunked(3)) {
    println(i)
}

for (i in arr.toList().windowed(2, 1)) {
    println(i)
}