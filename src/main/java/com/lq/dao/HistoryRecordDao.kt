package com.lq.dao

import com.lq.bean.HistoryRecord
import com.lq.dao.impl.IHistoryRecord
import com.lq.db.DBAccess
import org.apache.ibatis.session.SqlSession
import java.util.ArrayList

/**
 * Created by LiQian_Nice on 2018/3/9
 *
 * 与HistoryRecord相关的数据库表操作
 */
class HistoryRecordDao{
    /**
     * 插入历史查询记录
     */
    fun addRecord(historyRecord: HistoryRecord) {
        val dbAccess = DBAccess()
        var sqlSession: SqlSession? = null
        try {
            sqlSession = dbAccess.getSqlSession()
            val iHistoryRecord = sqlSession.getMapper(IHistoryRecord::class.java)
            iHistoryRecord.addRecord(historyRecord)
            sqlSession.commit()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            if (sqlSession != null) {
                sqlSession.close()
            }
        }
    }

    /**
     * 查询全部历史记录
     */
    fun queryHistoryRecordList(): List<HistoryRecord> {
        var list: List<HistoryRecord> = ArrayList()
        val dbAccess = DBAccess()
        var sqlSession: SqlSession? = null
        try {
            sqlSession = dbAccess.getSqlSession()
            val iHistoryRecord = sqlSession.getMapper(IHistoryRecord::class.java)
            list = iHistoryRecord.queryHistoryRecordList()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            if (sqlSession != null) {
                sqlSession.close()
            }
        }
        return list
    }
}