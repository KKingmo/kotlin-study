/**
 * 초기화 지연 : lateinit과 lazy
 *
 * Kotlin에서는 변수의 초기화를 지연시킬 수 있는 두 가지 방법, 즉 lateinit과 lazy를 제공합니다.
 * 이러한 방법들은 변수의 초기화 시점을 제어하면서 메모리를 효율적으로 사용하고, null 안전성을 유지할 수 있게 돕습니다.
 *
 * 1. lateinit:
 * - non-null 타입의 변수를 선언 시점에 초기화하지 않고, 나중에 초기화할 수 있게 해줍니다.
 * - var 변수에만 사용 가능하며, primitive 타입에는 사용할 수 없습니다.
 *
 * 2. lazy:
 * - 변수를 처음 사용하는 시점에 초기화합니다.
 * - val 변수에만 사용 가능하며, 초기화 블록을 통해 초기화 로직을 제공합니다.
 * - 이를 통해 불필요한 메모리 사용을 줄일 수 있습니다.
 */
package fastcampus.part0.kotlin

/**
 * lateinit 사용 예시:
 * String 타입의 text 변수를 선언하고, main 함수 내에서 초기화합니다.
 */
lateinit var text: String

/**
 * lazy 사용 예시:
 * Int 타입의 test 변수를 선언하고, 처음 접근하는 시점에 초기화합니다.
 */
val test: Int by lazy {
    println("초기화 중")
    100
}

// 주의: lateinit은 primitive 타입에 사용할 수 없습니다.
// 아래 코드는 에러를 발생시킵니다.
// lateinit var age: Int

fun main() {
    /**
     * text 변수에 값을 할당하여 초기화합니다.
     */
    text = "안녕하세요"

    println("메인 함수 실행")

    /**
     * lazy 초기화:
     * test 변수에 처음으로 접근하므로, 이 시점에 초기화 블록이 실행됩니다.
     */
    println("초기화 한 값 $test")

    /**
     * 두 번째 접근:
     * test 변수는 이미 초기화되었으므로, 초기화 블록은 실행되지 않습니다.
     */
    println("두번째 호출 $test")
}
