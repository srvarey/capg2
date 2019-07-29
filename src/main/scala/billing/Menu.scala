package billing

class Menu {



    def addItem(item: MenuItem) = {
        items = item :: items
    }


    def getItemPrice(itemName: String): Option[Double] = {


        val item = items.filter(x => x.name == itemName)


        if (item.nonEmpty)
            Some(item.head.price)
        else
            None
    }

    def getItem(itemName: String): Option[MenuItem] = {


        val item = items.filter(x => x.name == itemName)


        if (item.nonEmpty)
            Some(item.head)
        else
            None
    }

    def isHot(itemName: String): Boolean = {


        val item = items.filter(x => x.name == itemName)


        if (item.nonEmpty) {
            item.head.hot
        }

        else
            false
    }

    def isHotFood(itemName: String): Boolean = {


        val item = items.filter(x => x.name == itemName)


        if (item.nonEmpty) {
            item.head.hot && item.head.isFood
        }

        else
            false
    }


    def isFood(itemName: String): Boolean = {


        val item = items.filter(x => x.name == itemName)


        if (item.nonEmpty) {
            item.head.isFood
        }

        else
            false
    }

    var items: List[MenuItem] = List()
}