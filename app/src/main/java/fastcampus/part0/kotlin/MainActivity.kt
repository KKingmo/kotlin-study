package fastcampus.part0.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * SAM (Single Abstract Method) 변환을 사용하여 함수형 인터페이스를 람다로 대체하는 예시입니다.
         * Kotlin에서는 SAM 변환을 통해 함수형 인터페이스를 구현하는 자바 메서드를 호출할 때 람다 표현식을 사용할 수 있습니다.
         * 이를 통해 코드를 더 간결하고 읽기 쉽게 만들 수 있습니다.
         * 아래의 예시에서는 View.OnClickListener 인터페이스를 람다로 대체하여 setOnClickListener 메서드에 전달하고 있습니다.
         */
        val view = View(this)
//        view.setOnClickListener(
//            new View.OnClickListener() {
//                @Override
//                public void onClick(View: View) {
//                    //
//                }
//            }
//        )

//        view.setOnClickListener({ println("안녕") })
        // Lambda argument should be moved out of parentheses
        view.setOnClickListener { println("안녕") }
    }
}