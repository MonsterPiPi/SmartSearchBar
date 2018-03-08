package com.lq.service;


import com.lq.bean.Message;
import com.lq.dao.MessageDao;
import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User : 51103942@qq.com
 * Date : 2018/1/19
 * Time : 14:46
 * Talk is cheap. Show me the code.
 */
//查询相关的业务功能
public class QueryService {

    public List<Message> queryMessageList(String command) {
        MessageDao messageDao = new MessageDao();
        return messageDao.queryMessageList(command);
    }

}
