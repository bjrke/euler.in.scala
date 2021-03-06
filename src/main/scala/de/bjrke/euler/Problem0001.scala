package de.bjrke.euler

/**
 * Multiples of 3 and 5
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
class Problem0001 extends Problem[Int] {

  override val result = 233168

  override def apply = (0 to 999)
    .filter( a => a % 3 == 0 || a % 5 == 0 )
    .sum

}
