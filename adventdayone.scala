import scala.io.Source._

object Advent{
    def main(args: Array[String])  
    {
        val filename = if (!args.isEmpty) args(0) else "depths.txt"
        val lines = fromFile(filename).getLines.toList.map(_.toString.toInt)
        var increasingCount = 0
        
        // Want to find number of occurances of increasing windowed values.
        // Ex. L = [1, 2, 3, 4, 5, 6] 
        // w1 = [1, 2, 3], w2 = [2, 3, 4], etc.
        // delta between windwos is sum(w1) - sum(w2) for all windows in L.
        // Return number of increasing occurances.

        for(i <- 2 to lines.length - 2){
            val windowDelta = getWindowSum(i, lines) - getWindowSum(i - 1, lines)
            if (isIncreasing(windowDelta)) increasingCount += 1
        }

        println(increasingCount)
    }

    def isIncreasing(delta : Int) : Boolean = {
        if (delta > 0) true else false
    }

    def getWindowSum(index : Int, arr : List[Int]) : Int = {
        arr(index-1) + arr(index) + arr(index+1)
    }
}