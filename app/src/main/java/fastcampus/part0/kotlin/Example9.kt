/**
 * 타입체크와 캐스팅
 */
package fastcampus.part0.kotlin

fun main() {
    println(check2("안녕"))
    println(check2(3))
    println(check2(true))

    println(cast("안녕"))
    println(cast(3))

    println(smartcast("안녕"))
    println(smartcast(3))
    println(smartcast(true))
}

/**
 * Kotlin에서 타입 체크를 수행하는 함수 예시입니다.
 * `is` 키워드를 사용하여 변수의 타입을 체크할 수 있습니다.
 * 이 함수는 if-else 문을 사용하여 입력된 변수의 타입을 체크하고, 해당 타입에 따라 문자열을 반환합니다.
 */
fun check(a: Any): String {
    return if (a is String) {
        "문자열"
    } else if (a is Int) {
        "숫자"
    } else {
        "몰라요"
    }
}

/**
 * Kotlin에서 타입 체크를 수행하는 또 다른 함수 예시입니다.
 * 이 함수는 when 문을 사용하여 입력된 변수의 타입을 체크하고, 해당 타입에 따라 문자열을 반환합니다.
 */
fun check2(a: Any): String {
    return when (a) {
        is String -> {
            "문자열"
        }
        is Int -> {
            "숫자"
        }
        else -> {
            "몰라요"
        }
    }
}

/**
 * Kotlin에서 안전한 타입 캐스팅을 수행하는 함수 예시입니다.
 * `as?` 연산자를 사용하여 안전하게 타입을 캐스팅할 수 있으며, 캐스팅이 실패하면 Elvis 연산자(`?:`)를 사용하여 기본값을 반환합니다.
 */
fun cast(a: Any) {
    val result = (a as? String) ?: "실패"
    println(result)
}

/**
 * Kotlin에서 스마트 캐스팅을 수행하는 함수 예시입니다.
 * `is` 키워드를 사용하여 타입을 체크한 후, 해당 타입이 확인되면 추가적인 캐스팅 없이 해당 타입의 메서드나 프로퍼티를 사용할 수 있습니다.
 */
fun smartcast(a: Any): Int {
    return if (a is String) {
        a.length
    } else if (a is Int) {
        a.dec()
    } else {
        -1
    }
}
