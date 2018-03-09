package com.lq.service

import com.lq.bean.HistoryRecord
import com.lq.dao.HistoryRecordDao

/**
 * Created by LiQian_Nice on 2018/3/9
 *
 * 添加相关的业务功能
 */
class AddService{

    fun addRecord(historyRecord: HistoryRecord){
        val historyRecordDao = HistoryRecordDao()
        historyRecordDao.addRecord(historyRecord)
    }
}