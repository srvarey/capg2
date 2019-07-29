object Restaurant extends App {
    println("Hello, world")

    def calcBill(menu: Menu, items: List[String]): Double = {

        val prices: Seq[Option[Double]] = items collect {
            case m: String => menu.getItemPrice(m)
        }


        val filtered = prices.filter(x => {
            val p : Double =  x.getOrElse(0)
            (p > 0)
        })

        var sum = 0.0
        filtered.foreach(e => sum += e.get)

        println(s"Sum = $sum")

        sum

    }
    def calcBillWithService(menu: Menu, items: List[String]): Double = {

        val prices: Seq[Option[Double]] = items collect {
            case m: String => menu.getItemPrice(m)
        }


        val filtered = prices.filter(x => {
            val p : Double =  x.getOrElse(0)
            (p > 0)
        })



        var sum = 0.0
        filtered.foreach(e => sum += e.get)

        println(s"Sum = $sum")

        sum

    }


}