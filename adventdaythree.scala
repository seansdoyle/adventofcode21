import scala.io.Source._

object AdventDayTwo{
    def main( args: Array[String]){
        val filename = if (!args.isEmpty) args(0) else "daythree.txt"
        val lines = fromFile(filename).getLines.toList
        var numberOfBits = lines(0).length
        println("Number of bits: " + numberOfBits)
        var gamma = ""
        var epsilon = ""

        var mostCommonBit = -1
        var leastCommonBit = -1

        for(i <- 0 to numberOfBits - 1){
            var numberOfOnes = 0
            var numberOfZeros = 0
            for(bin <- lines){
                bin(i) match{
                    case '1' => numberOfOnes += 1
                    case '0' => numberOfZeros += 1
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