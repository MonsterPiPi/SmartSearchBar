package com.lq.dao;

import com.lq.bean.Message;
import com.lq.dao.impl.IMessage;
import com.lq.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by LiQian_Nice on 2018/3/8
 *
 * 和message表相关的数据库操作
 */

public class MessageDao {

    /**
     *
     * 根据查询条件查询消息列表
     * mybatis的方法
     */
    public List<Message> queryMessageList(String command){
        List<Message> list=new ArrayList<>();
        DBAccess dbAccess=new DBAccess();
        SqlSession sqlSession=null;

        try {
            sqlSession=dbAccess.getSqlSession();
            Message message=new Message();
            message.setCommand(command);
            //通过sqlSession执行sql语句
            IMessage imessage=sqlSession.getMapper(IMessage.class);
            list=imessage.queryMessageList(message);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession!=null){
                sqlSession.close();
            }

        }
        return list;
    }


    public static void main(String[] args){
        MessageDao messageDao=new MessageDao();
        //messageDao.queryMessageListByPage("","");
    }


    //数据库用户名
    String userName="root";
    //数据库访问密码
    String userPasswd="123456";


}
