package com.lq.dao

import com.lq.bean.Message
import com.lq.dao.impl.IMessage
import com.lq.db.DBAccess
import org.apache.ibatis.session.SqlSession
import java.util.ArrayList

/**
 * Created by LiQian_Nice on 2018/3/9
 *
 * 和message表相关的数据库操作
 */
class MessageDao{
    /**
     *
     * 根据查询条件查询消息列表
     * mybatis的方法
     */
    fun queryMessageList(command: String): List<Message> {
        var list: List<Message> = ArrayList()
        val dbAccess = DBAccess()
        var sqlSession: SqlSession? = null

        try {
            sqlSession = dbAccess.getSqlSession()
            val message = Message()
            message.command = command
            //通过sqlSession执行sql语句
            val imessage = sqlSession.getMapper(IMessage::class.java)
            list = imessage.queryMessageList(message)
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