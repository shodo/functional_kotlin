package chapter3.exercises.ex12

import chapter3.Cons
import chapter3.List
import chapter3.Nil
import chapter3.exercises.ex9.foldLeft
import chapter3.foldRight
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec
import utils.SOLUTION_HERE

// tag::init[]
fun <A, B> foldLeftR(xs: List<A>, z: B, f: (B, A) -> B): B =
    foldRight(xs, { b: B -> b }) { a, fbb -> { c -> fbb(f(c, a)) } }(z)

fun <A, B> foldRightL(xs: List<A>, z: B, f: (A, B) -> B): B =
    foldLeft(xs, { b: B -> b }) { fbb, a -> { c -> fbb(f(a, c)) } }(z)
// end::init[]

//TODO: Enable tests by removing `!` prefix
class Exercise12 : WordSpec({
    "list foldLeftR" should {
        "implement foldLeft functionality using foldRight" {
            foldLeftR<Int, List<Int>>(
                List.of(1, 2, 3, 4, 5),
                Nil,
                { b, a -> Cons(a, b) }) shouldBe List.of(5, 4, 3, 2, 1)
        }
    }

    "list foldRightL" should {
        "implement foldRight functionality using foldLeft" {
            foldRightL<Int, List<Int>>(
                List.of(1, 2, 3, 4, 5),
                Nil,
                { a, b -> Cons(a, b) }) shouldBe List.of(1, 2, 3, 4, 5)
        }
    }
})
