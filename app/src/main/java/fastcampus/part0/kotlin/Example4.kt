/**
 * 클래스
 */
package fastcampus.part0.kotlin

fun main() {
    // 'User' 클래스의 인스턴스를 생성하며, "오창모"라는 이름을 인자로 전달합니다.
    // 'age' 속성은 기본값 28을 사용합니다.
    val user = User("오창모")

    // 'Kid3' 클래스의 부 생성자를 호출하여, "아이", 3, "male"을 인자로 전달하여 인스턴스를 생성합니다.
    Kid3("아이", 3, "male")

    // 'user' 인스턴스의 'age' 속성을 출력합니다.
    println(user.age)
}

/**
 * 'User' 클래스는 사용자의 이름과 나이를 속성으로 가집니다.
 * 클래스 선언 시, 속성에 기본값을 할당할 수 있으며, 이 경우 인스턴스 생성 시 해당 속성의 인자를 생략할 수 있습니다.
 * 또한, 클래스의 구현 부가 없으면 중괄호({})를 생략할 수 있습니다.
 * 클래스의 속성이나 메서드를 숨기려면 'private' 키워드를 사용할 수 있습니다.
 */
class User(val name: String, var age: Int = 28)

/**
 * 'User2' 클래스는 'open' 키워드를 사용하여 선언되었으므로, 다른 클래스에서 상속받을 수 있습니다.
 * 코틀린에서는 클래스가 기본적으로 상속을 허용하지 않는 'final' 상태로 선언됩니다.
 * 클래스를 상속 가능한 상태로 만들려면 'open' 키워드를 사용해야 합니다.
 * 'name'과 'age' 속성도 'open' 키워드를 사용하여, 하위 클래스에서 오버라이드할 수 있게 하였습니다.
 */
open class User2(open val name: String, open var age: Int = 28)

/**
 * 'Kid2' 클래스는 'User2' 클래스를 상속받아, 'name'과 'age' 속성을 오버라이드합니다.
 */
class Kid2(override val name: String, override var age: Int) : User2(name, age)

/**
 * 'User3' 클래스는 'open' 키워드를 사용하여 선언되었으며, 'name'과 'age' 속성도 오버라이드할 수 있게 'open' 키워드를 사용하였습니다.
 */
open class User3(open val name: String, open var age: Int = 28)

/**
 * 'Kid3' 클래스는 'User3' 클래스를 상속받아, 'name'과 'age' 속성을 오버라이드하고, 추가적으로 'gender' 속성을 가지고 있습니다.
 * 클래스에는 주 생성자와 부 생성자가 있습니다.
 * 'init' 블록은 주 생성자가 호출될 때 실행되며, 여기서는 "초기화 중 입니다."라는 메시지를 출력합니다.
 * 부 생성자는 'constructor' 키워드를 사용하여 선언하며, 주 생성자를 호출하기 위해 'this(name, age)'를 사용합니다.
 * 부 생성자에서는 추가적인 로직을 수행할 수 있으며, 여기서는 'gender' 속성을 초기화하고, 메시지를 출력합니다.
 */
class Kid3(override val name: String, override var age: Int) : User2(name, age) {
    var gender: String = "female"

    init {
        println("초기화 중 입니다.")
    }

    constructor(name: String, age: Int, gender: String) : this(name, age) {
        this.gender = gender
        println("부 생성자 호출")
    }
}
