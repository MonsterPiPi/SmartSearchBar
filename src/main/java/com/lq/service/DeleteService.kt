package com.lq.service

import com.lq.dao.HistoryRecordDao

/**
 * Created by LiQian_Nice on 2018/3/10
 *
 */
class DeleteService{

    var historyRecordDao= HistoryRecordDao()

    fun deleteAllRecord(){

        historyRecordDao.deleteAllRecord()
    }
}