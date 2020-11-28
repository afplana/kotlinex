package dpatterns

class BookFactory {
    companion object {
        fun get(category: Category): Book = when (category) {
            Category.SCIENCE -> object: Book {
                private val title = "Relativity Vol. III"
                override fun getInfo() = println("$title covers deeply the concepts of...")
            }
            Category.PROGRAMMING -> object: Book {
                private val title = "Data Structures And Algorithms in Java"
                override fun getInfo() = println("$title covers a wide range of...")
            }
            Category.HISTORY -> object: Book {
                private val title = "W.W II"
                override fun getInfo() = println("$title, published in 1967 narrates the...")
            }
        }
    }
}

fun main() {
    BookFactory.get(Category.PROGRAMMING).getInfo()
    BookFactory.get(Category.SCIENCE).getInfo()
}
