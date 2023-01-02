package chapter3.exercises.ex8

import chapter3.List
import chapter3.Nil
import chapter3.exercises.ex5.init
import chapter3.foldRight
import chapter4.foldRight
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec
import utils.SOLUTION_HERE

// tag::init[]
fun <A> length(xs: List<A>): Int =
    foldRight(xs, 0) { _, acc -> 1 + acc }
// end::init[]

//TODO: Enable tests by removing `!` prefix
class Exercise8 : WordSpec({
    "list length" should {
        "calculate the length" {
            length(List.of(1, 2, 3, 4, 5)) shouldBe 5
        }

        "calculate zero for an empty list" {
            length(Nil) shouldBe 0
        }
    }
})
