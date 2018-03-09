package com.lq.dao.impl

import com.lq.bean.Message

/**
 * Created by LiQian_Nice on 2018/3/9
 *
 * 与message配置文件相对应的接口
 */
interface IMessage {

    /**
     * 根据查询条件查询消息列表
     */
    fun queryMessageList(message: Message): List<Message>
}