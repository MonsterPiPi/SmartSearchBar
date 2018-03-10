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
     * 根据条件查询历史查询记录
     */
    fun queryHistoryRecordList(historyRecord: HistoryRecord):List<HistoryRecord>

    /**
     * 根据条件查询是否存在相同的历史记录
     */
    fun querySameHistroyRecord(historyRecord: HistoryRecord): Boolean

    /**
     * 删除所有历史查询记录
     */
    fun deleteAllRecord()

}