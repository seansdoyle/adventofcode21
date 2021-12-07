import scala.io.Source._

object AdventDayTwo{
    def main( args: Array[String]){
        val filename = if (!args.isEmpty) args(0) else "daytwo.txt"
        val lines = fromFile(filename).getLines.toList

        var x = 0
        var depth = 0
        var aim = 0


        for (dir <- lines){
            val splitDirection = dir.split(" ")
            val direction = splitDirection(0)
            var distance = splitDirection(1).toInt

            direction match{
                case "up" => aim -= distance
                case "down" => aim += distance
                case "forward" => 
                    x += distance
                    depth += aim * distance
            }
        }

        println(x*depth)
    }
}