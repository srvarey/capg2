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

    def isHot(itemName: String): Boolean = {


        val item = items.filter(x => x.name == itemName)


        if (item.nonEmpty)
            true
        else
            false
    }

    var items: List[MenuItem] = List()
}