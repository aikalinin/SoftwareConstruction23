import java.math.BigDecimal
import java.time.LocalDate

fun validatePercent(value: Int) {
    if (value > 100 || value < 0)
        throw IllegalStateException("Percent incorrect")
}

class ReturnMoneyNotAllowedException(
    private val returnDate: LocalDate,
    cause: Throwable? = null
) : Exception(cause) {

    override val message: String
        get() = "Money can't be return for SafeAccount until $returnDate"
}

class OutOfMoneyLimitException(
    private val limit: BigDecimal,
    cause: Throwable? = null
) : Exception(cause) {

    override val message: String
        get() = "You can't withdraw money more than $limit"
}

abstract class Account(
    val name: String,
    protected var money: BigDecimal = BigDecimal.ZERO
) {

    open fun addMoney(value: BigDecimal) {
        if (value <= BigDecimal.ZERO) {
            throw IllegalStateException("You can't add negative value or zero")
        }

        money += value
    }

    open fun withdrawMoney(value: BigDecimal): BigDecimal {
        if (value <= BigDecimal.ZERO)
            throw IllegalStateException("You can't withdraw negative money")

        return value
    }
}

class SafeAccount(
    name: String,
    money: BigDecimal = BigDecimal.ZERO,
    private val createDate: LocalDate = LocalDate.now(),
    private val returnDate: LocalDate = createDate.plusYears(1)
) : Account(name, money) {

    fun getReturnDate() = returnDate

    fun addDays(days: Long) {
        returnDate.plusDays(days)
    }

    override fun withdrawMoney(value: BigDecimal): BigDecimal {
        super.withdrawMoney(value)

        if (LocalDate.now() < returnDate)
            throw ReturnMoneyNotAllowedException(returnDate)

        return if (money < value) {
            val returnMoney = money
            money = BigDecimal.ZERO

            returnMoney
        } else {
            money -= value

            value
        }
    }
}

class CreditAccount(
    name: String,
    money: BigDecimal = BigDecimal.ZERO,
    percent: Int,
    private val limit: BigDecimal
) : Account(name, money) {

    private var _percent: Int = percent
    var percent: Int
        get(): Int = _percent
        set(value) {
            validatePercent(value)

            _percent = value
        }

    init {
        validatePercent(percent)
    }

    override fun withdrawMoney(value: BigDecimal): BigDecimal {
        super.withdrawMoney(value)

        if (value > limit)
            throw OutOfMoneyLimitException(limit)

        val payment = value * BigDecimal(percent / 100)
        money -= value + payment

        return payment
    }
}
