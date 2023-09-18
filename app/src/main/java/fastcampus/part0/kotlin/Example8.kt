/**
 * Null
 */
package fastcampus.part0.kotlin

fun main() {
    /**
     * Kotlin에서는 변수 선언 시에 타입 뒤에 '?'를 붙이지 않으면 해당 변수는 null 값을 가질 수 없습니다.
     * 아래의 'name'과 'number' 변수는 null을 할당할 수 없는 타입으로 선언되었습니다.
     */
    var name: String = "창모"
    // name = null  // 이 줄은 컴파일 에러를 발생시킵니다, null을 할당할 수 없습니다.

    var number: Int = 10
    // number = null  // 이 줄도 컴파일 에러를 발생시킵니다, null을 할당할 수 없습니다.

    /**
     * 반면, '?' 표시가 있는 변수는 null 값을 가질 수 있습니다.
     * 이렇게 함으로써, Kotlin은 null safety를 보장하며, 런타임에서의 NullPointerExeption을 방지할 수 있습니다.
     */
    var nickname: String? = null
    var secondNumber: Int? = null

    /**
     * Kotlin에서는 null 가능성을 명시적으로 처리해야 합니다.
     * 아래 형태로 사용하는 것은 bad practice
     * 아래의 예시는 'nickname' 변수가 null인지 확인하고, null이면 "값이 없음"을 반환하고, 그렇지 않으면 'nickname' 값을 반환합니다.
     */
    val result1 = if (nickname == null) {
        "값이 없음"
    } else {
        nickname
    }

    /**
     * '?:' 연산자는 null 병합 연산자라고도 하며, 변수가 null인 경우 지정된 기본값을 반환합니다.
     * 아래의 예시는 'nickname'이 null인 경우 "값이 없음"을 반환합니다.
     */
    val result2 = nickname ?: "값이 없음"
    println(result2)

    /**
     * '?.' 연산자는 안전한 호출 연산자라고도 하며, 변수가 null이 아닌 경우에만 뒤에 오는 속성이나 함수를 호출합니다.
     * 아래의 예시는 'nickname'이 null인 경우 length 속성을 호출하지 않고 null을 반환합니다.
     */
    nickname = null
    val size = nickname?.length
    println(size)
}
