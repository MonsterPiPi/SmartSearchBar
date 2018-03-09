package com.lq.servlet

import com.lq.bean.HistoryRecord
import com.lq.service.AddService
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
        super.doPost(req, resp)
    }

    @Throws(ServletException::class, IOException::class)
    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        resp.contentType = "text/html;charset=UTF-8"
        //禁用缓存，确保网页信息是最新数据
        resp.setHeader("Pragma", "No-cache")
        resp.setHeader("Cache-Control", "no-cache")
        resp.setDateHeader("Expires", -10)
        val msg = req.getParameter("message")
        logger.info(msg)
        //获取当前时间
        val df = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val time = df.format(System.currentTimeMillis())
        val historyRecord = HistoryRecord()
        historyRecord.command = msg
        historyRecord.createtime = time
        val addService = AddService()
        addService.addRecord(historyRecord)

    }
}