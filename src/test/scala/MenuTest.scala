import billing.{Menu, MenuItem, Restaurant}
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter


class menuTests extends FunSuite with BeforeAndAfter {

    val COLA = "Cola"
    val COFFEE = "Coffee"
    val CHEESE_SANDWICH = "Cheese Sandwich"
    val STEAK_SANDWICH = "Steak Sandwich"

    
    var menu: Menu = _

    before {
        menu = new Menu

        val cola = MenuItem(COLA, 0.5, hot=false, isFood = false)
        val coffee = MenuItem(COFFEE, 1.0, hot=true, isFood = false)
        val cheeseSandwich = MenuItem(CHEESE_SANDWICH, 2.0, hot=false, isFood = true)
        val steakSandwich = MenuItem(STEAK_SANDWICH, 4.5, hot=true, isFood = true)

        menu.addItem(cola)
        menu.addItem(coffee)
        menu.addItem(cheeseSandwich)
        menu.addItem(steakSandwich)

    }



    test("Service charge - Drinks only") {

        assert(!menu.isHot(COLA))
        assert(menu.isHot(COFFEE))
        assert(!menu.isHot(CHEESE_SANDWICH))
        assert(menu.isHot(STEAK_SANDWICH))
        assert(!menu.isFood(COLA))
        assert(!menu.isFood(COFFEE))
        assert(menu.isFood(CHEESE_SANDWICH))
        assert(menu.isFood(STEAK_SANDWICH))

        val bill = Restaurant.calcBillWithService(menu, List(COLA, COLA, COLA))

        println("Bill = " + bill)

        assert(bill === 1.5)


    }


    test("Service charge - Bill with cold food") {

        val bill = Restaurant.calcBillWithService(menu, List(COLA, COFFEE, CHEESE_SANDWICH))

        println("Bill = " + bill)

        assert(bill === 3.85)

    }

    test("Service charge - Bill with hot food < 20 ") {

        val bill = Restaurant.calcBillWithService(menu, List(COLA, COFFEE, STEAK_SANDWICH))

        println("Bill = " + bill)

        assert(bill === 7.2)

    }

    test("Service charge - Bill with hot food > 20 ") {

        val bill = Restaurant.calcBillWithService(menu, List(COLA, COFFEE, STEAK_SANDWICH, STEAK_SANDWICH, STEAK_SANDWICH, STEAK_SANDWICH, STEAK_SANDWICH))

        println("Bill = " + bill)

        assert(bill === 20.0)

    }


    test("Standard Bill") {


        val bill = Restaurant.calcBill(menu, List(COLA, COFFEE, CHEESE_SANDWICH))

        println("Bill = " + bill)

        assert(bill === 3.5)
    }

    // mark that you want a test here in the future
    //test("Invoice")(pending)
    test("Split charge")(pending)

}