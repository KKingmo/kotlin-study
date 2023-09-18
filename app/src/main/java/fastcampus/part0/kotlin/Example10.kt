/**
 * String template
 */
package fastcampus.part0.kotlin

fun main() {
    val a = 10
    val name = "멋쟁이 오창모"
    val isHigh = true

    /**
     * Kotlin에서 문자열 템플릿을 사용하는 기본 예시입니다.
     * 문자열 내에서 '$' 기호를 사용하여 변수의 값을 직접 참조할 수 있습니다.
     * 이를 통해 문자열과 변수 값을 쉽게 결합할 수 있습니다.
     */
    println("$a $name $isHigh")

    /**
     * Kotlin에서 문자열 템플릿을 사용하여 표현식을 평가하는 예시입니다.
     * 문자열 내에서 '${}'를 사용하여 복잡한 표현식을 평가하고 결과를 문자열에 포함시킬 수 있습니다.
     * 이 예시에서는 'name' 변수의 길이(length)를 계산하여 문자열에 포함시킵니다.
     */
    println("$a ${name.length} $isHigh")
}
