package com.sujithjay.benchmark.merge

import org.scalameter.api._

/**
 * @author Sujith
 */
object MergePerformance extends Bench.LocalTime{

  val sizes = Gen.range("arraySizes")(0, 1500000, 300000)

  val lists =  for {
    size <- sizes
  } yield Tuple2((0 to (size, 2)).toList, (1 to (size, 2) ).toList)

  performance of "Merge" in {
    measure method "FunctionalMerge" in {
      using(lists) config (
        exec.independentSamples -> 1,
        exec.reinstantiation.frequency -> 2,
        exec.outliers.covMultiplier -> 1.5,
        exec.outliers.suspectPercent -> 40
        ) in{
        l=>
          FunctionalMerge.merge(l._1, l._2)
      }
    }
  }

  val arrays =  for {
    size <- sizes
  } yield Tuple2((0 to (size, 2)).toArray, (1 to (size, 2) ).toArray)

  performance of "Merge" in {
    measure method "ImperativeMerge" in {
      using(arrays) config (
        exec.independentSamples -> 1,
        exec.reinstantiation.frequency -> 2,
        exec.outliers.covMultiplier -> 1.5,
        exec.outliers.suspectPercent -> 40
        ) in{
        l=>
          ImperativeMerge.merge(l._1, l._2)
      }
    }
  }
}
