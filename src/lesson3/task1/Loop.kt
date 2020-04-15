@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import lesson1.task1.sqr
import java.lang.Integer.max
import java.lang.Integer.min
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.math.PI as PI1


/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var count = 0
    var new_n: Int = n
    do {
        new_n /= 10
        count++
    } while (new_n != 0)
    return count
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int
// if (n <= 2) 1
// else fib(n - 2) + fib(n - 1)
{
    var result1 = 1
    var result2 = 1
    var result = 1
    if (n <= 2)
    else {
        for (i in 3..n) {
            result = result1 + result2
            result1 = result2
            result2 = result
        }
    }
    return result
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var count = 0
    do count++
    while (((max(m, n) * count) % min(m, n)) != 0)
    return (max(m, n) * count)
}


/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var MinDiv = 2
    if (n % 2 == 0)
    else for (m in 3..sqrt(n.toDouble()).toInt() step 2) if (n % m == 0) {
        MinDiv = m
        break
    } else MinDiv = n
    return MinDiv
}


/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var newn = n
    return (newn / minDivisor(newn))
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var min_num: Int = min(m, n)
    var temp1: Int
    var difference: Int = max(m, n) - min_num
    while (min_num != difference) {
        temp1 = min_num
        min_num = min(temp1, difference)
        difference = max(temp1, difference) - min_num
    }
    return (difference == 1)
}


/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var sqm: Int = sqrt(m.toDouble()).toInt()
    var sqn: Int = sqrt(n.toDouble()).toInt()
    return ((((m % sqm) == 0) || ((n % sqn) == 0)) || (sqm < sqn))
}


/**
 * Средняя
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */


fun collatzSteps(x: Int): Int {
    var xxx = x
    var count = 0
    if (xxx == 1) return count
    do {
        if (xxx % 2 == 0) xxx /= 2 else xxx = 3 * xxx + 1
        count++
    } while (xxx != 1)
    return count
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double {
    var xxx = x
    var chlen: Double
    var count = 3
    var sign = -1
    xxx /= kotlin.math.PI
    xxx %= 2.0
    xxx *= kotlin.math.PI
    var sinus = xxx
    do {
        chlen = xxx.pow(count.toDouble()) / factorial(count).toDouble()
        sinus += sign * chlen
        sign *= -1
        count += 2
    } while (chlen > eps)
    return sinus
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double {
    var xxx = x
    var cosinus = 1.0
    var chlen: Double
    var count = 2
    var sign = -1
    xxx /= kotlin.math.PI
    xxx %= 2.0
    xxx *= kotlin.math.PI
    do {
        chlen = xxx.pow(count.toDouble()) / factorial(count).toDouble()
        cosinus += sign * chlen
        sign *= -1
        count += 2
    } while (chlen > eps)
    return cosinus
}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var lastdigit = n
    var nnn = n
    var newdigit = 0
    while (nnn / 10 != 0) {
        lastdigit = nnn % 10
        newdigit = newdigit * 10 + lastdigit
        nnn /= 10
    }
    return newdigit * 10 + nnn
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    var nnn = n
    return n == revert(nnn)
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var last1 = n
    var last2 = n
    var nnn = n
    var res = false
    while (nnn / 10 != 0) {
        last1 = nnn % 10
        nnn /= 10
        last2 = nnn % 10
        if (last1 != last2) {
            res = true
            break
        }


    }
    return res
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    if (n == 1) return 1
    var count = 1
    var posled = 1
    var digits = 1
    var temp: Int
    var needednumber: Int
    do {
        count++
        digits += digitNumber(sqr(count))
    } while (digits < n)

    needednumber = digits - n + 1
    temp = sqr(count)

    for (i: Int in 1..needednumber) {
        if (temp >= 10) posled = temp % 10 else posled = temp
        temp /= 10
    }



    return posled

}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int = TODO()
