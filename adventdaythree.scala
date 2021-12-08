import scala.io.Source._

object AdventDayTwo{
    def main( args: Array[String]) : Unit = {
        val filename = if (!args.isEmpty) args(0) else "daythree.txt"
        val binaryNumbers = fromFile(filename).getLines.toList
        val numberOfBits = binaryNumbers(0).length
        
        var gamma = ""
        var epsilon = ""
        var mostCommonBit = -1
        var leastCommonBit = -1

        for(i <- 0 to numberOfBits - 1){
            var numberOfOnes = 0
            var numberOfZeros = 0
            for(bin <- binaryNumbers){
                bin(i) match{
                    case '1' => numberOfOnes += 1
                    case '0' => numberOfZeros += 1
                    case _ => println("Error")
                }
            }
            mostCommonBit = mostCommon(numberOfOnes, numberOfZeros)
            leastCommonBit = mostCommonBit * -1 + 1

            gamma += mostCommonBit.toString
            epsilon += leastCommonBit.toString
        } 

        println(Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2))
        
    }

    def mostCommon(ones : Int, zeros : Int) : Int = {
        if (ones > zeros) 1 else 0
    }
}