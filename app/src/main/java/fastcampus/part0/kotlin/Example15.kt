/**
 * Data class와 Sealed class
 *
 * - Data class: 주로 데이터를 저장하는 데 사용되는 클래스입니다. 이 클래스는 다음과 같은 특징을 가지고 있습니다.
 *   - toString(), hashCode(), equals(), copy() 등의 유틸리티 메서드를 자동으로 생성하여 데이터 처리를 용이하게 합니다.
 *   - 필요한 경우, 이러한 메서드들을 override하여 사용자 정의 동작을 구현할 수 있습니다.
 *   - 최소 하나 이상의 프로퍼티를 포함해야 합니다.
 *   - abstract, open, sealed, inner 키워드를 사용하여 선언할 수 없습니다.
 *   - 다른 클래스에 상속될 수 없습니다.
 *
 * - Sealed class: 추상 클래스의 한 형태로, 상속 가능한 자식 클래스의 종류를 제한하는 역할을 합니다. 이 클래스는 다음과 같은 특징을 가지고 있습니다.
 *   - 컴파일러가 sealed 클래스의 자식 클래스들을 모두 알고 있어, when 표현식에서 모든 경우를 검사할 수 있게 합니다. 이로 인해, else 분기가 필요 없어집니다.
 *   - when 표현식과 함께 사용될 때, 모든 자식 클래스에 대한 처리가 되었는지 컴파일 시점에 검사할 수 있어, 코드의 안정성과 명확성이 향상됩니다.
 */
package fastcampus.part0.kotlin

fun main() {
    val person = Person("수지", 24)
    val dog = Dog("해피", 24)

    /**
     * Person 클래스의 toString 메서드 호출:
     * Person 클래스에는 toString 메서드가 별도로 정의되어 있지 않으므로,
     * Object 클래스의 toString 메서드가 호출되어 객체의 해시코드가 반환됩니다.
     */
    println(person.toString())

    /**
     * Dog 클래스의 toString 메서드 호출:
     * Dog 클래스는 데이터 클래스로, 자동으로 생성된 toString 메서드를 통해
     * 클래스의 속성을 문자열 형태로 반환합니다.
     */
    println(dog.toString()) // Dog(name=해피, age=24)

    /**
     * Dog 클래스의 copy 메서드 사용 예:
     * 데이터 클래스는 copy 메서드를 제공하여, 객체의 복사본을 생성하고,
     * 선택적으로 일부 속성을 변경할 수 있습니다.
     */

    println(dog.copy(age = 3).toString()) // Dog(name=해피, age=3)

    /**
     * Cat1 클래스와 when 표현식:
     * Cat1은 추상 클래스로, 여러 하위 클래스를 가지고 있습니다.
     * when 표현식을 사용하여 객체의 유형을 확인하고, 해당 유형에 따라 다른 결과를 반환합니다.
     * 여기서 컴파일러는 가능한 하위 클래스를 모두 알 수 없으므로, else 분기를 추가하여 모든 경우를 처리합니다.
     */
    val cat1: Cat1 = BlueCat1()
    val result1 = when (cat1) {
        is BlueCat1 -> "blue"
        is RedCat1 -> "red"
        is GreenCat1 -> "green"
        else -> "none"
    }

    /**
     * Cat2 클래스와 when 표현식:
     * Cat2는 봉인된 클래스(sealed class)로, 가능한 모든 하위 클래스가 알려져 있습니다.
     * 따라서 when 표현식에서 else 분기가 필요 없으며, 컴파일러는 모든 경우가 고려되었는지 확인할 수 있습니다.
     * 봉인된 클래스는 유형 검사를 더 안전하고 명확하게 만들어, 런타임 오류의 가능성을 줄입니다.
     */
    val cat2: Cat2 = BlueCat2()
    val result2 = when (cat2) {
        is BlueCat2 -> "blue"
        is RedCat2 -> "red"
        is GreenCat2 -> "green"
    }
}

class Person(val name: String, val age: Int)

/**
 * Dog 데이터 클래스:
 * 데이터 클래스는 주 생성자에 선언된 속성에 대해 toString, equals, hashCode, copy 등의
 * 메서드를 자동으로 생성합니다.
 * 이러한 메서드는 필요에 따라 오버라이드하여 사용자 정의 구현을 제공할 수 있습니다.
 */
data class Dog(val name: String, val age: Int) {
    // 데이터 클래스는 아래와 같이 오버라이딩 가능합니다.
    // override fun toString(): String {
    //     return "직접 구현 $name"
    // }
}

// 데이터 클래스는 상속이 불가능합니다.
// data class Corgi(
//     val pretty : Boolean = true
// ) : Dog()

/**
 * Cat1 추상 클래스와 하위 클래스:
 * 추상 클래스를 사용하여 여러 하위 클래스를 정의할 수 있습니다.
 * 이러한 하위 클래스들은 추상 클래스의 속성과 메서드를 상속받습니다.
 */
abstract class Cat1
class BlueCat1 : Cat1()
class RedCat1 : Cat1()
class GreenCat1 : Cat1()

/**
 * Cat2 봉인된 클래스와 하위 클래스:
 * 봉인된 클래스는 클래스 계층을 더 안전하게 정의할 수 있습니다.
 * 봉인된 클래스의 모든 하위 클래스는 동일한 파일에 선언되어야 하며,
 * 컴파일러는 가능한 모든 하위 클래스를 알 수 있습니다.
 * 이러한 특성 덕분에 when 표현식에서 모든 경우를 검사할 수 있으며, else 분기가 필요 없습니다.
 */
sealed class Cat2
class BlueCat2 : Cat2()
class RedCat2 : Cat2()
class GreenCat2 : Cat2()