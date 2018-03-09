package com.lq.dao.impl;

import com.lq.bean.Message;

import java.util.List;
import java.util.Map;

/**
 * Created by LiQian_Nice on 2018/3/8
 *
 * 与message配置文件相对应的接口
 * */
public interface IMessage {

    /**
     * 根据查询条件查询消息列表
     */
    List<Message> queryMessageList(Message message);

}
