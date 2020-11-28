interface ReportFactory<T> {
    fun get(data: ByteArray): T
}

enum class ReportType {
    REMAINING_TERM, INVENTORY_DATA, CONTRACT_STATUS
}

data class RemainingTermReport(private val data: String)
data class InventoryReport(private val data: String)
data class ContractStatusReport(private val data: String)


class RemainingTermReportFactory: ReportFactory<RemainingTermReport> {
    override fun get(data: ByteArray) = RemainingTermReport("Dataset for remaining term of devices: ${data.decodeToString()}")
}
class InventoryReportFactory: ReportFactory<InventoryReport> {
    override fun get(data: ByteArray) = InventoryReport("Dataset for Inventory of installations: ${data.decodeToString()}")
}
class ContractStatusReportFactory: ReportFactory<ContractStatusReport> {
    override fun get(data: ByteArray) = ContractStatusReport("Dataset for Contracts: ${data.decodeToString()}")
}

class AbstractReportFactory {
    companion object {
        fun adq(type: ReportType) = when(type) {
            ReportType.REMAINING_TERM -> RemainingTermReportFactory()
            ReportType.INVENTORY_DATA -> InventoryReportFactory()
            ReportType.CONTRACT_STATUS -> ContractStatusReportFactory()
        }
    }
}

fun main() {
    val rtReport = AbstractReportFactory.adq(ReportType.REMAINING_TERM)
    println(rtReport.get("Mock data for remaining term report".encodeToByteArray()))
    val invReport = AbstractReportFactory.adq(ReportType.INVENTORY_DATA)
    println(invReport.get("Mock data for inventory report".encodeToByteArray()))
    val contReport = AbstractReportFactory.adq(ReportType.CONTRACT_STATUS)
    println(contReport.get("Mock data for contract status report".encodeToByteArray()))
}
