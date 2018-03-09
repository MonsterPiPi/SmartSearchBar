package com.lq.service;


import com.lq.bean.Message;
import com.lq.dao.MessageDao;
import java.util.List;


/**
 * Created by LiQian_Nice on 2018/3/9
 *
 * 查询相关的业务功能
 */
public class QueryService {

    public List<Message> queryMessageList(String command) {
        MessageDao messageDao = new MessageDao();
        return messageDao.queryMessageList(command);
    }

}
