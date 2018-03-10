package com.lq.dao

import com.lq.bean.HistoryRecord
import com.lq.dao.impl.IHistoryRecord
import com.lq.db.DBAccess
import org.apache.ibatis.session.SqlSession
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.ArrayList

/**
 * Created by LiQian_Nice on 2018/3/9
 *
 * 与HistoryRecord相关的数据库表操作
 */
class HistoryRecordDao{

    private var logger: Logger =LoggerFactory.getLogger(HistoryRecord::class.java)
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
    fun queryHistoryRecordList(command: String): List<HistoryRecord> {
        var list: List<HistoryRecord> = ArrayList()
        val dbAccess = DBAccess()
        var sqlSession: SqlSession? = null
        try {
            var historyRecord=HistoryRecord()
            historyRecord.command=command
            sqlSession = dbAccess.getSqlSession()
            val iHistoryRecord = sqlSession.getMapper(IHistoryRecord::class.java)
            list = iHistoryRecord.queryHistoryRecordList(historyRecord)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            if (sqlSession != null) {
                sqlSession.close()
            }
        }
        return list
    }

    fun querySameHistroyRecord(msg: String): Boolean {
        val dbAccess = DBAccess()
        var sqlSession: SqlSession? = null
        var flag:Boolean=false
        try {
            var historyRecord=HistoryRecord()
            historyRecord.command=msg
            sqlSession = dbAccess.getSqlSession()
            val iHistoryRecord = sqlSession.getMapper(IHistoryRecord::class.java)
            flag = iHistoryRecord.querySameHistroyRecord(historyRecord)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            if (sqlSession != null) {
                sqlSession.close()
            }
        }
        logger.info(flag.toString()+"查询相同记录")
        return flag
    }

    fun deleteAllRecord() {
        val dbAccess = DBAccess()
        var sqlSession: SqlSession? = null
        try {
            sqlSession = dbAccess.getSqlSession()
            val iHistoryRecord = sqlSession.getMapper(IHistoryRecord::class.java)
            iHistoryRecord.deleteAllRecord()
            sqlSession.commit()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            if (sqlSession != null) {
                sqlSession.close()
            }
        }
    }
}

