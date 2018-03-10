import com.lq.bean.HistoryRecord;
import com.lq.bean.Message;
import com.lq.bean.Result;
import com.lq.service.AddService;
import com.lq.service.QueryService;
import com.lq.util.ResultUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/3/8
 */
public class TestMybatis {

    private static Logger logger= LoggerFactory.getLogger(TestMybatis.class);
    @Test
    public void one(){
        String command="看";
        QueryService queryService=new QueryService();
        List<Message> messageList=queryService.queryMessageList(command);
        for (Message message:messageList){
            logger.info(message.getCommand());
        }
    }

    @Test
    public void two(){
        HistoryRecord historyRecord=new HistoryRecord();
        historyRecord.setCommand("测试");
        historyRecord.setCreatetime("测试");
        AddService addService=new AddService();
        addService.addRecord(historyRecord);
    }

    @Test
    public void three(){
        QueryService queryService=new QueryService();
        List<HistoryRecord> historyRecordList=queryService.queryHistoryRecordList("查");
        for (HistoryRecord historyRecord:historyRecordList){
           logger.info(historyRecord.getCommand()+historyRecord.getCreatetime());
        }
    }

    @Test
    public void four(){

        QueryService queryService=new QueryService();
        boolean flag=queryService.querySameHistroyRecord("22423");
        logger.info(flag+"");

    }

    }

