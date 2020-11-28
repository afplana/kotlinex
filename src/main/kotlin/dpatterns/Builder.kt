package dpatterns

class Installation private constructor(
    var uuid: String? = null,
    var contractRef: String? = null,
    var customerRef: String? = null,
    var colorStatus: String? = null
) {

    data class Builder(
        var uuid: String? = null,
        var contractRef: String? = null,
        var customerRef: String? = null,
        var colorStatus: String? = null) {

        fun uuid(uuid: String) = apply { this.uuid=uuid }
        fun contractRef(contractRef: String) = apply { this.contractRef=contractRef }
        fun customerRef(customerRef: String) = apply { this.customerRef=customerRef }
        fun colorStatus(colorStatus: String) = apply { this.colorStatus=colorStatus }
        fun build() = Installation(uuid, contractRef, customerRef, colorStatus)
    }
}

fun main() {
    val installation = Installation.Builder()
        .uuid("R@344DAS*(ds222")
        .contractRef("400567$1243")
        .customerRef("CUS500&98")
        .colorStatus("GREEN")
        .build()
    println("Die Installation ${installation.uuid} mit Status ${installation.colorStatus} hat als " +
            "Kunde ${installation.customerRef} und die Vertragsnummer ${installation.contractRef}")
}
