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
        val msg = req.getParameter("message")
        if (msg !== "" && msg!!.length != 0 && msg != null) {
            logger.info(msg)
            val queryService = QueryService()
            val messageList = queryService.queryMessageList(msg)
            logger.info(messageList.size.toString() + "")
            var out: PrintWriter? = null
            try {
                out = resp.writer
                val `object` = JSON.toJSON(ResultUtil.success(messageList))
                out!!.print(`object`)
                out.flush()
            } catch (e: IOException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            } finally {
                out!!.close()
            }


        }

    }
}