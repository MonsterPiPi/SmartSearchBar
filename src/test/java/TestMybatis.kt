import com.lq.bean.HistoryRecord
import com.lq.service.AddService
import com.lq.service.QueryService
import org.junit.Test
import org.slf4j.LoggerFactory

/**
 * Created by LiQian_Nice on 2018/3/10
 *
 */
class TestMybatis{

    private val logger = LoggerFactory.getLogger(TestMybatis::class.java)

    @Test
    fun one() {
        val command = "看"
        val queryService = QueryService()
        val messageList = queryService.queryMessageList(command)
        for (message in messageList) {
            logger.info(message.command)
        }
    }

    @Test
    fun two() {
        val historyRecord = HistoryRecord()
        historyRecord.command = "测试"
        historyRecord.createtime = "测试"
        val addService = AddService()
        addService.addRecord(historyRecord)
    }

    @Test
    fun three() {
        val queryService = QueryService()
        val historyRecordList = queryService.queryHistoryRecordList("查")
        for (historyRecord in historyRecordList) {
            logger.info(historyRecord.command + historyRecord.createtime)
        }
    }

    @Test
    fun four() {

        val queryService = QueryService()
        val flag = queryService.querySameHistroyRecord("22423")
        logger.info(flag.toString() + "")

    }

}