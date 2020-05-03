import java.util.*

// https://www.hackerrank.com/challenges/maximum-element/problem

fun main() {
    val numOfCommands = readLine()!!.toInt()
    val stack = Stack<Int>()
    val maxMap = TreeMap<Int, Int>(kotlin.Comparator { o1, o2 -> return@Comparator o2 - o1 })

    for (i in 0 until numOfCommands) {
        when (val commandLine = readLine()!!) {
            "2" -> {
                val poppedValue = stack.pop()
                val count = maxMap[poppedValue]!!

                if (count > 1)
                    maxMap[poppedValue] = count - 1
                else
                    maxMap.remove(poppedValue)
            }
            "3" -> println(maxMap.firstKey())
            else -> {
                val newValue = commandLine.split(" ")[1].toInt()
                stack.push(newValue)

                val count = maxMap[newValue] ?: 0
                maxMap[newValue] = count + 1
            }
        }
    }
}