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

    var historyRecordDao=HistoryRecordDao()
    var messageDao=MessageDao()

    fun queryMessageList(command:String):List<Message>{

        return messageDao.queryMessageList(command)
    }

    fun queryHistoryRecordList(command: String):List<HistoryRecord>{

        return historyRecordDao.queryHistoryRecordList(command)
    }

    fun querySameHistroyRecord(msg: String): Boolean {
        return historyRecordDao.querySameHistroyRecord(msg)
    }
}