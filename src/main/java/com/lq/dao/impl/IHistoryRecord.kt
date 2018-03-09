package com.lq.dao.impl

import com.lq.bean.HistoryRecord

/**
 * Created by LiQian_Nice on 2018/3/9
 *
 * 与HistoryRecord配置文件相对于的接口
 */
interface IHistoryRecord {

    /**
     * 添加历史查询记录
     * @param historyRecord
     */
    fun addRecord(historyRecord: HistoryRecord)
    /**
     * 查询全部历史查询记录
     */
    fun queryHistoryRecordList():List<HistoryRecord>
}