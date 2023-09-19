/**
 * 확장함수
 */
package fastcampus.part0.kotlin

fun main() {
    /**
     * Kotlin에서 확장 함수(extension function)를 사용하는 예시입니다.
     * 확장 함수를 사용하면 기존 클래스에 새로운 함수를 추가할 수 있습니다.
     * 이를 통해 기존 클래스를 상속받지 않고도 클래스에 새로운 기능을 추가할 수 있습니다.
     * 아래의 예시에서는 Test 클래스에 추가된 확장 함수 'hi'를 main 함수에서 호출합니다.
     */
    val test = Test()
    Test().hello()
    test.hi()
}

/**
 * Test 클래스에 확장 함수 'hi'를 정의합니다.
 * 확장 함수를 사용하면 코드를 간결하게 유지할 수 있으며, 필요한 기능을 직접 추가하여 사용할 수 있습니다.
 * 예를 들어, Android 개발에서 TextView 클래스에 확장 함수를 추가하여 커스텀 기능을 쉽게 구현할 수 있습니다.
 */
fun Test.hi() = print("하이")

/**
 * Test 클래스 정의입니다.
 * 이 클래스에는 'hello'와 'bye' 두 개의 멤버 함수가 정의되어 있습니다.
 * 확장 함수를 사용하여 이 클래스에 추가적인 함수를 추가할 수 있습니다.
 */
class Test() {
    fun hello() = println("안녕")
    fun bye() = println("잘가")
}
