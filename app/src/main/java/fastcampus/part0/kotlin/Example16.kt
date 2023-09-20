/**
 * Object, Companion Object
 *
 * - Object :
 *   - 'object' 키워드를 사용하여 클래스 정의와 동시에 인스턴스를 생성할 수 있습니다. 이를 통해 싱글톤 패턴을 간단하게 구현할 수 있습니다.
 *   - 'object' 키워드로 생성된 객체는 생성자를 가질 수 없으나, 프로퍼티, 메서드, 초기화 블록은 정의할 수 있습니다.
 *   - 또한, 다른 클래스나 인터페이스를 상속받을 수 있어, 상속받은 메서드 등을 오버라이드할 수 있습니다.
 *   - 주로 유틸리티 클래스나, 시스템에서 유일하게 하나만 존재해야 하는 인스턴스를 관리할 때 사용됩니다.
 *
 * - Companion Object (동반 객체) :
 *   - 'companion object'를 사용하여 클래스 내부에 정적 멤버를 정의할 수 있습니다. 이는 Java의 static 멤버와 유사한 역할을 합니다.
 *   - 각 클래스 내에 하나의 'companion object'만 정의할 수 있으며, 이 안에 상수 또는 메서드를 정의할 수 있습니다.
 *   - 'companion object' 내부의 멤버들은 클래스 이름을 통해 직접 접근할 수 있습니다.
 *   - 주로 상수 정의나 팩토리 메서드 패턴 등을 구현할 때 사용됩니다.
 */
package fastcampus.part0.kotlin

fun main() {
    /**
     * Object 클래스 사용 예시:
     * Counter 객체는 object 키워드를 사용하여 선언되었으며, 싱글턴 패턴을 구현합니다.
     * 이 코드는 Counter 객체의 count 속성을 출력하고, countUp 메서드를 두 번 호출하여 count 값을 증가시킨 후,
     * 다시 count 속성을 출력합니다. 또한, Counter 객체가 Hello 클래스를 상속받았으므로 hello 메서드를 호출할 수 있습니다.
     */
    println(Counter.count)
    Counter.countUp()
    Counter.countUp()
    println(Counter.count)
    Counter.hello()

    /**
     * Companion Object 사용 예시:
     * Book 클래스 내부에 선언된 Companion Object Novel은 static 멤버를 담는 역할을 합니다.
     * 이 코드는 Novel 내부에 선언된 NAME 상수를 참조합니다.
     */
    Book.NAME

    /**
     * Companion Object의 메서드 사용 예시:
     * Novel 내부에 선언된 create 메서드를 호출하여 Book 클래스의 인스턴스를 생성합니다.
     */
    Book.create()
}

/**
 * Object 클래스 예시:
 * object 키워드를 사용하여 싱글턴 패턴을 구현한 Counter 클래스입니다.
 * 이 클래스는 Hello 클래스를 상속받으며, 카운트를 관리하는 count 속성과 count 값을 증가시키는 countUp 메서드를 포함합니다.
 * object 클래스는 생성자를 가질 수 없으며, 주로 상태를 유지해야 하는 싱글턴 객체나 유틸리티 함수를 담는 용도로 사용됩니다.
 */
object Counter : Hello() {
    init {
        println("카운터 초기화")
    }

    var count = 0
    fun countUp() {
        count++
    }
}

/**
 * Open 클래스 예시:
 * open 키워드를 사용하여 다른 클래스에서 상속할 수 있는 Hello 클래스입니다.
 * 이 클래스는 hello 메서드를 포함하며, 해당 메서드는 "Hello" 문자열을 출력합니다.
 */
open class Hello() {
    fun hello() = println("Hello")
}

/**
 * Companion Object 예시:
 * Book 클래스 내에 Companion Object Novel을 선언하여 static 멤버를 정의합니다.
 * Companion Object는 클래스 내에 단 하나만 선언할 수 있으며, 주로 상수 정의나 팩토리 메서드 등을 포함합니다.
 */
class Book {
    companion object Novel {
        const val NAME = "name"
        fun create() = Book()
    }
}