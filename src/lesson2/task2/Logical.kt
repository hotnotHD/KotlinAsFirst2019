@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr
import kotlin.math.*

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    val ab = (number / 1000) + (number / 100 % 10)
    val cd = (number / 10 % 10) + (number % 10)
    return ab == cd
}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    if (abs(x1 - x2) == abs(y1 - y2) || (x1 == x2 || y1 == y2)) return true
    return false
}


/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    var a = 0
    when (month) {
        1 -> a = 31
        2 -> a = 28
        3 -> a = 31
        4 -> a = 30
        5 -> a = 31
        6 -> a = 30
        7 -> a = 31
        8 -> a = 31
        9 -> a = 30
        10 -> a = 31
        11 -> a = 30
        12 -> a = 31
    }
    if (year % 400 == 0 && month == 2) return a + 1
    if (year % 4 == 0 && year % 100 != 0) return a + 1
    return a
}

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean {
    val r = r2 - r1
    val s = sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2))
    return s <= r
}

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
    val min: Int
    val mid: Int
    if (a == min(a, b) && a == min(a, c)) {
        min = a
        mid = min(c, b)
    } else if (b == min(a, b) && b == min(b, c)) {
        min = b
        mid = min(c, a)
    } else {
        min = c
        mid = min(b, a)
    }
    return (min <= min(r, s) && mid <= max(r, s))
}
