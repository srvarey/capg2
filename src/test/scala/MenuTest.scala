import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter

class menuTests extends FunSuite with BeforeAndAfter {

    var menu: Menu = _

    before {
        menu = new Menu
    }

    test("Service charge") {
        println (menu.getItemPrice("Coffe"))
        menu.isHot("Coffee")
        assert(menu.items.size == 0)
    }

    test("Invoice") {

        val cola = MenuItem("Cola", 0.5, hot=false, isFood = false)
        val coffee = MenuItem("Coffee", 1.0, hot=true, isFood = false)
        val cheeseSandwich = MenuItem("Cheese Sandwich", 2.0, hot=false, isFood = true)
        val steakSandwich = MenuItem("Steak Sandwich", 4.5, hot=true, isFood = true)

        menu.addItem(cola)
        menu.addItem(coffee)
        menu.addItem(cheeseSandwich)
        menu.addItem(steakSandwich)

        println("Price of coffee = " + menu.getItemPrice("Coffe"))
        val bill = Restaurant.calcBill(menu, List("Cola", "Coffee", "Cheese Sandwich"))
        println("Bill = " + bill)

        assert(menu.items.size === 4)
    }

    // mark that you want a test here in the future
    //test("Invoice")(pending)
    test("Split charge")(pending)

}