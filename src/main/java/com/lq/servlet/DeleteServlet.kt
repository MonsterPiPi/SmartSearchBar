package com.lq.servlet

import com.alibaba.fastjson.JSON
import com.lq.service.DeleteService
import com.lq.util.ResultUtil
import org.slf4j.LoggerFactory
import java.io.IOException
import java.io.PrintWriter
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by LiQian_Nice on 2018/3/10
 *
 */
class DeleteServlet : HttpServlet() {
    private val logger = LoggerFactory.getLogger(DeleteServlet::class.java)

    @Throws(ServletException::class, IOException::class)
    override fun doDelete(req: HttpServletRequest, resp: HttpServletResponse) {
        resp.contentType = "text/html;charset=UTF-8"
        //禁用缓存，确保网页信息是最新数据
        resp.setHeader("Pragma", "No-cache")
        resp.setHeader("Cache-Control", "no-cache")
        resp.setDateHeader("Expires", -10)
        logger.info("请求了删除所有记录")
        // 将结果以json方式传给前台
        var out: PrintWriter? = null
        var obj:Any=""
        try {
            val deleteService= DeleteService()
            deleteService.deleteAllRecord()
            obj= JSON.toJSON(ResultUtil.success("",0,"删除成功"))
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