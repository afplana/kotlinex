interface ItemPrototype {
    fun clone(): ItemPrototype
}

data class TextItem(var text: String? = null, var color: String? = null) : ItemPrototype {
    override fun clone(): TextItem {
        return TextItem(this.text, this.color)
    }
}

data class ImageItem(var url: String? = null, var width: Int? = null) : ItemPrototype {
    override fun clone(): ImageItem {
        return ImageItem(this.url, this.width)
    }
}


class Item {

    private var cache: ItemsCache? = null

    fun setCaching(cache: ItemsCache) {
        this.cache = cache
    }

    fun printItem() {
        if (cache != null) {
            cache!!.getFullCache().forEach { (k, v) -> println("$k => $v") }
        } else {
            println("No caching for $this")
        }
    }
}

class ItemsCache {
    private val reportItems: MutableMap<String, ItemPrototype> = mutableMapOf()

    init {
        val text = TextItem("Normal text", "Black")
        val image = ImageItem("/image/url",100)

        reportItems["item 1"] = text
        reportItems["item 2"] = image
    }

    fun getFullCache() = this.reportItems

    fun addItem(key: String, newItem: ItemPrototype) {
        reportItems[key] = newItem
        println(reportItems[key])
    }
}

fun main() {
    val cache = ItemsCache()
    cache.addItem("item 3", TextItem("Heading", "Blue"))
    val item = Item()
    item.setCaching(cache)
    item.printItem()
    println()
    val itemWOC = Item()
    itemWOC.printItem()
}
