package chapter2.exercises.ex1

import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec
import kotlinx.collections.immutable.persistentMapOf

//TODO: Enable tests by removing `!` prefix
class Exercise1 : WordSpec({
    //tag::init[]
    fun fib(i: Int): Int {
        tailrec fun loop(counter: Int, prev: Int, current: Int): Int {
            if (counter == 1)
                return current

            val next = current + prev
            return loop(counter - 1, current, next)
        }

        return loop(i, 0, 1)
    }
    //end::init[]

    "fib" should {
        "return the nth fibonacci number" {
            persistentMapOf(
                1 to 1,
                2 to 1,
                3 to 2,
                4 to 3,
                5 to 5,
                6 to 8,
                7 to 13,
                8 to 21
            ).forEach { (n, num) ->
                fib(n) shouldBe num
            }
        }
    }
})
