package com.lq.db

import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSession
import org.apache.ibatis.session.SqlSessionFactory
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import java.io.Reader

/**
 * Created by LiQian_Nice on 2018/3/9
 *
 */
class DBAccess{

    fun getSqlSession(): SqlSession{
        //通过配置文件获取数据库连接信息
        var reader: Reader = Resources.getResourceAsReader("Configuration.xml")
        //通过配置信息构建一个SessionFactory
        var sqlSessionFactory:SqlSessionFactory= SqlSessionFactoryBuilder().build(reader)
        //通过sqlSessionFactory打开一个数据库会话
        var sqlSession:SqlSession=sqlSessionFactory.openSession()
        //返回
        return sqlSession
    }
}