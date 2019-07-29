package billing

object Restaurant extends App {
  val COLA = "Cola"
  val COFFEE = "Coffee"
  val CHEESE_SANDWICH = "Cheese Sandwich"
  val STEAK_SANDWICH = "Steak Sandwich"

  def calcBill(menu: Menu, items: List[String]): Double = {

    val prices: Seq[Option[Double]] = items collect {
      case m: String => menu.getItemPrice(m)
    }


    val filtered = prices.filter(x => {
      val p: Double = x.getOrElse(0)
      (p > 0)
    })

    var sum = 0.0
    filtered.foreach(e => sum += e.get)


    sum

  }


  def roundTo2Decimals(num: Double) = {


    Math.round(num * 100.0) / 100.0
  }

  def calcBillWithService(menu: Menu, items: List[String]) = {

    val prices = items collect {
      case m: String => menu.getItem(m)
    }


    val filtered = prices.filter(x => {
      x != None
    })

    var anyHotFood = false
    var anyFood = false

    filtered.foreach(e => {
      if (e.get.isFood && e.get.hot) anyHotFood = true
      if (e.get.isFood) anyFood = true
    })


    var beforeService = calcBill(menu, items)

    if (anyHotFood) {
      roundTo2Decimals(Math.min(20.00, beforeService * 1.20))
    }
    else if (anyFood) {
      roundTo2Decimals(beforeService * 1.10)
    }
    else {
      roundTo2Decimals(beforeService)
    }


  }


  val menu = new Menu

  val cola = MenuItem(COLA, 0.5, hot = false, isFood = false)
  val coffee = MenuItem("Coffee", 1.0, hot = true, isFood = false)
  val cheeseSandwich = MenuItem(CHEESE_SANDWICH, 2.0, hot = false, isFood = true)
  val steakSandwich = MenuItem("Steak Sandwich", 4.5, hot = true, isFood = true)

  menu.addItem(cola)
  menu.addItem(coffee)
  menu.addItem(cheeseSandwich)
  menu.addItem(steakSandwich)

  val bill1 = Restaurant.calcBillWithService(menu, List(COLA, COLA, COLA))

  println("Bill1 = " + bill1)

  val bill2 = Restaurant.calcBillWithService(menu, List(COLA, COFFEE, CHEESE_SANDWICH))


  println("Bill2 = " + bill2)

  val bill3 = Restaurant.calcBillWithService(menu, List(COLA, COFFEE, STEAK_SANDWICH))

  println("Bill3 = " + bill3)

  val bill4 = Restaurant.calcBillWithService(menu, List(COLA, COFFEE, STEAK_SANDWICH, STEAK_SANDWICH, STEAK_SANDWICH, STEAK_SANDWICH, STEAK_SANDWICH))

  println("Bill4 = " + bill4)

}
