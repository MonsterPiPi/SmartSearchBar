package com.lq.servlet

import com.alibaba.fastjson.JSON
import com.lq.service.QueryService
import com.lq.util.ResultUtil
import org.slf4j.LoggerFactory
import java.io.IOException
import java.io.PrintWriter
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by LiQian_Nice on 2018/3/9
 *
 */
class SearchServlet:HttpServlet(){
    private val logger = LoggerFactory.getLogger(SearchServlet::class.java)
    @Throws(ServletException::class, IOException::class)
    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        super.doPost(req, resp)
    }

    @Throws(ServletException::class, IOException::class)
    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        resp.contentType = "text/html;charset=UTF-8"
        //禁用缓存，确保网页信息是最新数据
        resp.setHeader("Pragma", "No-cache")
        resp.setHeader("Cache-Control", "no-cache")
        resp.setDateHeader("Expires", -10)
        //接收前台传来的值
        val msg = req.getParameter("message")
        //定义任意变量
        var obj:Any=""
        val queryService = QueryService()
        //判断接收信息是否为空
        if (msg == null || msg.isEmpty()){
            //没有查找到
            obj=JSON.toJSON(ResultUtil.success("",2,"没有查询到结果"))
            logger.error("1没有查询到结果")
        }else{
            //logger.info(msg)
            //不为空优先查询历史查询记录
            val historyRecordList=queryService.queryHistoryRecordList(msg)
            if (historyRecordList.size!==0&&historyRecordList!==null){
                obj=JSON.toJSON(ResultUtil.success(historyRecordList,1,"历史搜索记录"))
            }else{
                //为空查询数据库记录表
                val messageList = queryService.queryMessageList(msg)
                if (messageList.size!==0&&messageList!==null){
                    obj=JSON.toJSON(ResultUtil.success(messageList,0,"本地搜索记录"))
                }else{
                    //没有查找到
                    obj=JSON.toJSON(ResultUtil.success("",2,"没有查询到结果"))
                    logger.error("2没有查询到结果")
                }
            }

        }
        // 将结果以json方式传给前台
        var out: PrintWriter? = null
        try {
            out = resp.writer
            out!!.print(obj)
            out.flush()
        } catch (e: IOException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        } finally {
            out!!.close()
        }

    }

}