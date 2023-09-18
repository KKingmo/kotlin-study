/**
 * 조건식
 */
package fastcampus.part0.kotlin

fun main() {
    max(10, 3)
    max2(10, 3)
    isHoliday("금")
    isHoliday("토")
}

/**
 * 코틀린에서는 조건문을 '식(expression)'으로 사용할 수 있습니다.
 * 이는 조건문이 값을 반환할 수 있다는 것을 의미하며, 이러한 특성 덕분에 변수 'result'에 바로 할당할 수 있습니다.
 * 아래의 'if-else' 구문은 'a'와 'b' 중 더 큰 값을 'result'에 할당하고, 그 값을 출력합니다.
 */
fun max(a: Int, b: Int) {
    val result = if (a > b) {
        a
    } else {
        b
    }
    println(result)
}

/**
 * 코틀린에서는 자바의 삼항 연산자(?)를 사용할 수 없습니다.
 * 대신, 'if-else' 구문을 '식'으로 사용하여 같은 기능을 구현할 수 있습니다.
 * 아래의 코드는 'if-else' 구문을 한 줄로 간단하게 표현하여 'a'와 'b' 중 더 큰 값을 'result'에 할당하고, 그 값을 출력합니다.
 */
fun max2(a: Int, b: Int) {
    val result = if (a > b) a else b
    println(result)
}

/**
 * 코틀린에서 'when' 구문은 다양한 방법으로 사용할 수 있습니다.
 * 'when'을 식으로 사용할 때는 모든 경우에 대해 값을 반환해야 하며, 그러기 위해 'else' 절이 필요합니다.
 * 또한, 'when' 구문 내에서 변수를 선언하고 그 변수를 조건절에서 사용할 수 있습니다.
 * 아래의 코드는 'dayOfWeek' 변수의 값에 따라 다른 문자열을 반환하고 출력하는 예시입니다.
 */
fun isHoliday(dayOfWeek: Any) {
    val result = when (dayOfWeek) {
        "토", "일" -> if (dayOfWeek == "토") "좋아" else "너무 좋아"
        in 2..4 -> "일반적인 요일"
        in listOf("월", "화") -> "주중의 시작"
        else -> "안좋아"
    }
    println(result)
}

/**
 * 'when' 구문에서 변수 선언을 함께 사용할 수 있습니다.
 * 이렇게 하면, 'when' 구문 내의 각 분기에서 해당 변수를 사용할 수 있습니다.
 * 이러한 방식은 코드를 더 깔끔하게 만들고, 중복을 줄여주며, 조건 분기 내에서의 추가적인 연산이나 처리를 용이하게 합니다.
 * 아래의 코드에서는 'dayOfWeek' 파라미터의 값을 'day' 변수에 할당하고, 이 'day' 변수를 'when' 구문 내에서 사용하여
 * 다양한 조건 분기를 처리하고 있습니다.
 */
fun isHoliday2(dayOfWeek: Any) {
    val result = when (val day = dayOfWeek) {
        "토", "일" -> if (day == "토") "좋아" else "너무 좋아"
        in 2..4 -> "일반적인 요일"
        in listOf("월", "화") -> "주중의 시작"
        else -> "안좋아"
    }
    println(result)
}
