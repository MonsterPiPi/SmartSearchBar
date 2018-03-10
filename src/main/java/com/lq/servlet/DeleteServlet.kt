package com.lq.servlet

import com.lq.service.DeleteService
import org.slf4j.LoggerFactory
import java.io.IOException
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
    override fun doDelete(req: HttpServletRequest?, resp: HttpServletResponse?) {
        logger.info("请求了删除所有记录")
        val deleteService= DeleteService()
        deleteService.deleteAllRecord()
    }
}