package com.lq.service

import com.lq.bean.HistoryRecord
import com.lq.bean.Message
import com.lq.dao.HistoryRecordDao
import com.lq.dao.MessageDao

/**
 * Created by LiQian_Nice on 2018/3/9
 *
 * 查询相关的业务功能
 */
class QueryService{

    fun queryMessageList(command:String):List<Message>{
        var messageDao=MessageDao()
        return messageDao.queryMessageList(command)
    }

    fun queryHistoryRecordList():List<HistoryRecord>{
        var historyRecordDao=HistoryRecordDao()
        return historyRecordDao.queryHistoryRecordList()
    }
}