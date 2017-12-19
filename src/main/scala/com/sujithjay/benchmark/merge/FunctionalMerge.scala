package com.sujithjay.benchmark.merge

/**
 * @author Sujith
 */
object FunctionalMerge {

  def merge(nums1: List[Int], nums2: List[Int]): List[Int] = {
    def loop(xss: List[Int], yss: List[Int], aux: List[Int] ): List[Int] = (xss, yss) match {
      case (x::xs, y::ys) if x < y => loop(xs, yss, x::aux)
      case (_, y::ys) => loop(xss, ys, y::aux)
      case (x::xs, Nil) => loop(xs, Nil, x::aux)
      case (Nil, Nil) => aux
    }

    loop(nums1, nums2, Nil)
  }
}
