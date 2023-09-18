/**
 * 컬렉션 (list, map, set)
 */
package fastcampus.part0.kotlin

fun main() {
    /**
     * 'mutableListOf'는 코틀린에서 변경 가능한 리스트를 생성하는 함수입니다.
     * 이 리스트에는 요소를 추가, 수정, 삭제하는 메서드들이 있습니다.
     * 아래의 예시에서는 1부터 5까지의 요소를 가진 리스트를 생성하고, 'add'와 'addAll' 메서드를 사용하여 요소를 추가합니다.
     */
    val list = mutableListOf(1, 2, 3, 4, 5)
    list.add(6)
    list.addAll((listOf(7, 8, 9)))

    /**
     * 'listOf' 함수를 사용하여 생성된 리스트는 불변(immutable) 리스트입니다.
     * 이 리스트에서는 요소를 추가, 수정, 삭제할 수 없으며, 요소에 접근만 가능합니다.
     * 아래의 예시에서는 1부터 4까지의 요소를 가진 불변 리스트를 생성하고, 첫 번째 요소에 접근합니다.
     */
    val list1 = listOf(1, 2, 3, 4)
    list1[0]

    /**
     * 코틀린에서는 확장 함수를 사용하여 기존 클래스에 새로운 함수를 추가할 수 있습니다.
     * 아래의 예시에서는 'map' 확장 함수를 사용하여 리스트의 각 요소를 10배 한 후, 'joinToString' 확장 함수를 사용하여 "/"로 구분된 문자열을 생성합니다.
     */
    println(list1.map { it * 10 }.joinToString("/"))

    /**
     * 아래의 예시는 다양한 타입의 요소를 함께 가질 수 있는 리스트를 보여줍니다.
     * 코틀린에서는 한 리스트에 여러 타입의 요소를 함께 저장할 수 있습니다.
     */
    val diverseList = listOf(1, "안녕", 1.78, true)

    /**
     * 아래의 예시는 리스트의 출력 방법과 'joinToString' 함수를 사용하여 리스트의 요소를 특정 문자로 연결하여 출력하는 방법을 보여줍니다.
     * 'println(list)'는 리스트를 기본 형식으로 출력하며, 'joinToString' 함수를 사용하면 리스트의 요소를 콤마(,)로 연결하여 문자열 형태로 출력합니다.
     */
    println(list)
    println(list.joinToString(","))

    /**
     * 아래의 예시는 코틀린에서 Map과 MutableMap의 사용 방법을 보여줍니다.
     * 'mapOf' 함수를 사용하여 불변 Map을 생성하고, 'mutableMapOf' 함수를 사용하여 변경 가능한 Map을 생성합니다.
     * 변경 가능한 Map에서는 'put' 메서드나 인덱스 연산자를 사용하여 요소를 추가하거나 수정할 수 있습니다.
     * 아래의 예시에서는 여러 가지 방법으로 Map에 요소를 추가하고 수정하는 방법을 보여줍니다.
     */
    val map = mapOf((1 to "안녕"), (2 to "hello"))
    val map1 = mutableMapOf((1 to "안녕"), (2 to "hello"))
    map1.put(3, "응")
    map1[3] = "응"
    map1[100] = "호이"
}