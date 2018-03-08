import com.lq.bean.Message;
import com.lq.service.QueryService;
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
            System.out.println(message.getDescription());
        }
    }
}
