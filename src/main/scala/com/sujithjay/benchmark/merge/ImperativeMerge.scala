package com.sujithjay.benchmark.merge

/**
 * @author Sujith
 */
object ImperativeMerge {

  def merge(arr1: Array[Int], arr2: Array[Int]): Array[Int]= {
      var i = 0
      var j = 0
      var k = 0
      val n1 = arr1.length
      val n2 = arr2.length
      val arr3 = new Array[Int](n1+n2)

      while (i< n1 && j < n2) {
          if (arr1(i) < arr2(j)){
            arr3(k) = arr1(i)
            k+=1
            i+=1
          }
          else{
            arr3(k) = arr2(j)
            k+=1
            j+=1
          }
      }
      while (i < n1){
        arr3(k) = arr1(i)
        k+=1
        i+=1
      }
      while (j < n2){
        arr3(k) = arr2(j)
        k+=1
        j+=1
      }
    arr3
  }

}
