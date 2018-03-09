import com.lq.bean.HistoryRecord;
import com.lq.bean.Message;
import com.lq.bean.Result;
import com.lq.service.AddService;
import com.lq.service.QueryService;
import com.lq.util.ResultUtil;
import org.junit.Test;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/3/8
 */
public class TestMybatis {

    @Test
    public void one(){
        String command="看";
        QueryService queryService=new QueryService();
        List<Message> messageList=queryService.queryMessageList(command);
        for (Message message:messageList){
            System.out.println(message.getCommand());
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
        List<HistoryRecord> historyRecordList=queryService.queryHistoryRecordList();
        for (HistoryRecord historyRecord:historyRecordList){
            System.out.println(historyRecord.getCommand()+historyRecord.getCreatetime());
        }
    }

    @Test
    public void four(){
        Result result=new Result(null);
        result.setCode(1);
        result.setData("22");
        System.out.println(ResultUtil.INSTANCE.success(result));

    }

    }

