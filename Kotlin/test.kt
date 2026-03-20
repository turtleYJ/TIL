fun main() {
    val payment = Payment(1, 0)
    val payment2 = Payment(2, 1000, "DONE")
    val payment3 = Payment(2, 1000)
    var pamentValidation = validatePament(payment)
    var readys = findByStatus(listOf(payment, payment2, payment3), "READY")

    // 3. Null Safety
    var payment4: Payment? = null
    var amt = payment4?.amount
    var amt2 = payment4?.amount ?: 0
    var amt3 = payment4!!.amount

    println(amt3)
}
data class Payment(
    val id: Long,
    val amount: Int,
    val status: String = "READY"
)
fun validatePament(payment: Payment): Boolean = payment.amount > 0
fun findByStatus(payments: List<Payment>, status: String): List<Payment> = payments.filter { it.status == "READY" }