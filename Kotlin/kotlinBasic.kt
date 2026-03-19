class test1 {
    // 1. 변수
    val name: String = "토스"        // final (불변)
    var count: Int = 0              // 가변
    val inferred = "타입 추론됨"       // 타입 생략 가능

    // 2. 함수
    fun add(a: Int, b: Int): Int {
        return a + b
    }
    fun add(a: Int, b: Int): Int = a + b // 한줄 함수

    // 기본값 파라미터
    fun greet(name: String = "Guest") =  "Hello, $name"

    // 3. Null Safety - 가장 중요
    var nullable: String? = null        // ? 붙여야 null 가능
    var len = nullable?.length          // null이면 null 반환
    var len2 = nullable?.length ?: 0    // null이면 0 (엘비스 연산자)
    var len3 = nullable!!.length        // null이면 NPE (위험)

    // 4. when (= Java switch)
    when (status) {
        "READY" -> println("준비")
        "DONE"  -> println("완료")
        else    -> println("기타")
    }

    // 5. data class (= Java record/Lombok @Data)
    data class Payment(
        val id: Long,
        val amount: Int,
        val status: String = "READY"
    )
    // equals, hashCode, toString, copy 자동 생성

    // 6. String template
    val msg = "결제 금액: ${payment.amount}원"

    // 7. 컬렉션
    val names = listOf("A", "B", "C")
    val filtered = names.filter { it.startsWith("A") }
    val mapped = names.map { it.lowercase() }
}