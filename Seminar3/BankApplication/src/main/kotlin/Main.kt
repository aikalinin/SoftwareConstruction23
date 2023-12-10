import java.math.BigDecimal
import java.time.LocalDate

fun main(args: Array<String>) {

    val account1 = SafeAccount(
        name ="Safe1",
        money = BigDecimal.TEN,
        createDate = LocalDate.now().minusYears(1)
    )
}
