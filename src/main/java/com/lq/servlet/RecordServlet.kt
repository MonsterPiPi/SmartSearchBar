package com.lq.servlet

import com.lq.bean.HistoryRecord
import com.lq.service.AddService
import com.lq.service.DeleteService
import com.lq.service.QueryService
import org.slf4j.LoggerFactory
import java.io.IOException
import java.text.SimpleDateFormat
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by LiQian_Nice on 2018/3/9
 *
 */
class RecordServlet : HttpServlet(){

    private val logger = LoggerFactory.getLogger(RecordServlet::class.java)

    @Throws(ServletException::class, IOException::class)
    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {


    }

    @Throws(ServletException::class, IOException::class)
    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        resp.contentType = "text/html;charset=UTF-8"
        //禁用缓存，确保网页信息是最新数据
        resp.setHeader("Pragma", "No-cache")
        resp.setHeader("Cache-Control", "no-cache")
        resp.setDateHeader("Expires", -10)
        val msg = req.getParameter("message")
        val addService = AddService()
        val queryService = QueryService()
        //判断接收信息是否为空
        if (msg !== "" && msg!!.length != 0 && msg != null) {
            //查询是否存在相同的历史记录，如果没有，则添加进去
            var flag=queryService.querySameHistroyRecord(msg)
            if (flag){
                logger.error("历史记录表已存在相同查询")
            }else{

                logger.info(msg)
                //获取当前时间
                val df = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                val time = df.format(System.currentTimeMillis())
                val historyRecord = HistoryRecord()
                historyRecord.command = msg
                historyRecord.createtime = time
                addService.addRecord(historyRecord)
            }

        }


    }
}