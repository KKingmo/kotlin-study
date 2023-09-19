/**
 * Scope Functions (범위 지정 함수)
 *
 * 코틀린 표준 라이브러리는 코드의 간결성과 명료성을 향상시키며, 유지보수를 용이하게 하는 범위 지정 함수를 제공합니다.
 * 이러한 함수들은 특정 객체에 대한 작업을 수행하는 코드 블록을 정의하고, 그 범위 내에서 객체의 속성이나 함수에 직접 접근할 수 있게 합니다.
 * 이를 통해 코드의 가독성을 향상시키고, 중복을 줄일 수 있습니다.
 *
 * - Context: 범위 지정 함수 내에서, 수신 객체의 속성이나 함수에 직접 접근할 수 있는 환경을 의미합니다.
 *            이 환경은 코드의 간결성과 명료성을 높이며, 객체 지향 프로그래밍을 더욱 효과적으로 수행할 수 있게 돕습니다.
 *
 * - Receiver (수신 객체): 범위 지정 함수가 호출되는 대상 객체를 의미합니다.
 *                       이 객체의 속성이나 함수에 직접 접근할 수 있으며, 코드 블록 내에서 this 키워드를 통해 참조할 수 있습니다.
 *
 * - Lambda with Receiver (수신 객체 지정 람다): 수신 객체를 명시하지 않고, 람다의 본문 안에서 해당 객체의 메서드를 호출할 수 있게 하는 람다입니다.
 *                                           이를 통해 코드 블록 내에서 객체의 메서드를 더욱 간결하게 호출할 수 있습니다.
 *
 * - 차이점:
 *   - 수신 객체 접근 방법: this (apply, run, with), it (also, let)
 *   - 반환 값: 수신 객체 (apply, also), 람다 식의 마지막 행 (run, let, with)
 *
 * - let: null 체크가 필요하거나 지역 변수를 명시적으로 표현해야 할 때 사용합니다.
 *        또한, 수신 객체를 다른 이름으로 사용하고 싶을 때 유용합니다.
 *        it 키워드를 통해 수신 객체에 접근하며, 람다의 마지막 표현식을 반환합니다.
 *
 * - run: 객체의 초기화를 수행하고, 그 결과를 반환하고 싶을 때 사용합니다.
 *        또한, 수신 객체 내에서 여러 연산을 수행하고 결과를 반환하고 싶을 때 유용합니다.
 *        this 키워드를 통해 수신 객체에 접근하며, 람다의 마지막 표현식을 반환합니다.
 *
 * - apply: 객체의 초기화를 수행하고, 그 객체 자체를 반환하고 싶을 때 사용합니다.
 *          이를 통해 객체 생성과 동시에 속성을 설정할 수 있습니다.
 *          this 키워드를 통해 수신 객체에 접근하며, 수신 객체 자신을 반환합니다.
 *
 * - with: non-extension function으로, 객체 초기화 시 람다 리턴 값이 필요 없을 때 사용합니다.
 *         주어진 객체를 수신 객체로 사용하여 람다 본문을 실행합니다.
 *         this 키워드를 통해 수신 객체에 접근하며, 람다의 마지막 표현식을 반환합니다.
 *
 * - also: 수신 객체를 처리하고, 그 객체 자체를 반환하고 싶을 때 사용합니다.
 *         주로 부수 효과(side-effects)를 위해 사용됩니다.
 *         it 키워드를 통해 수신 객체에 접근하며, 수신 객체 자신을 반환합니다.
 */
package fastcampus.part0.kotlin

fun main() {
    /**
     * let 함수: 수신 객체를 it 키워드를 통해 접근하며, 람다의 마지막 표현식을 반환합니다.
     * it 키워드는 생략할 수 없습니다. 주로 null 체크와 함께 사용되며, 객체의 속성을 추출할 때 유용합니다.
     * 주로 null 가능성이 있는 객체에서 안전한 속성 접근을 위해 사용됩니다.
     */
    val a = 3
    a.let { }
    val user: UserDetails? = UserDetails("오창모", 10, true)
    val age = user?.let {
        it.age
    }
    println(age)

    /**
     * run 함수: 수신 객체를 this 키워드를 통해 접근하며, 람다의 마지막 표현식을 반환합니다.
     * this 키워드는 생략 가능합니다. 객체의 속성을 읽거나 수정하는 코드 블록을 그룹화할 때 유용합니다.
     * 주로 객체의 여러 속성을 동시에 수정하거나, 객체의 속성을 읽어 복잡한 연산을 수행할 때 사용됩니다.
     */
    val kid = UserDetails("아이", 4, false)
    val kidAge = kid.run {
        age
    }
    println(kidAge)

    /**
     * apply 함수: 수신 객체를 this 키워드를 통해 접근하며, 수신 객체 자신을 반환합니다.
     * this 키워드는 생략 가능합니다. 객체의 초기화 과정에서 속성을 설정할 때 주로 사용됩니다.
     * 주로 객체 생성과 동시에 속성을 설정하거나 초기화할 때 사용됩니다.
     */
    val kidName = kid.apply {
        name
    }
    println(kidName)

    /**
     * apply 함수를 사용하여 hasGlasses 속성을 수정하고, 수정된 객체를 반환합니다.
     * 주로 객체의 속성을 수정하면서 그 객체를 반환할 때 유용합니다.
     */
    val female = UserDetails("슬기", 20, false, true)
    val femaleValue = female.apply {
        hasGlasses = false
    }
    println(femaleValue.hasGlasses)

    /**
     * also 함수: 수신 객체를 it 키워드를 통해 접근하며, 수신 객체 자신을 반환합니다.
     * it 키워드는 생략할 수 없습니다. 객체의 속성을 수정하면서 그 객체를 반환할 때 유용합니다.
     * 주로 객체의 속성을 수정한 후 로깅 또는 다른 부수 효과를 수행할 때 사용됩니다.
     */
    val male = UserDetails("민수", 17, true, true)
    val maleValue = male.also {
        it.name
        it.hasGlasses = false
    }
    val maleValue2 = male.also {
        println("maleValue2 : ${it.name}")
    }
    println(maleValue)
    println(maleValue.hasGlasses)

    /**
     * with 함수: non-extension function으로, 수신 객체를 this 키워드를 통해 접근하며, 람다의 마지막 표현식을 반환합니다.
     * this 키워드는 생략 가능합니다. 객체의 속성을 읽거나 수정하는 코드 블록을 그룹화할 때 유용합니다.
     * 주로 null이 아닌 객체의 속성을 읽거나 수정할 때 사용됩니다.
     */
    val result = with(male) {
        hasGlasses = false
        true
    }
}

/**
 * UserDetails 클래스: 사용자의 세부 정보를 저장하는 클래스입니다.
 * name: 사용자의 이름
 * age: 사용자의 나이
 * isMale: 사용자의 성별 (true: 남성, false: 여성)
 * hasGlasses: 사용자가 안경을 착용하는지 여부
 */
class UserDetails(
    val name: String,
    val age: Int,
    val isMale: Boolean,
    var hasGlasses: Boolean = true,
)

