package com.lq.servlet;

import com.alibaba.fastjson.JSON;
import com.lq.bean.Message;
import com.lq.service.QueryService;
import com.lq.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by LiQian_Nice on 2018/3/8
 */
public class SearchServlet extends HttpServlet {

    private static Logger logger= LoggerFactory.getLogger(SearchServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //禁用缓存，确保网页信息是最新数据
        resp.setHeader("Pragma","No-cache");
        resp.setHeader("Cache-Control","no-cache");
        resp.setDateHeader("Expires", -10);
        String msg=req.getParameter("message");
        if (msg!=""&&msg.length()!=0&&msg!=null){
            logger.info(msg);
            QueryService queryService=new QueryService();
            List<Message> messageList=queryService.queryMessageList(msg);
            PrintWriter out = null;
            try {
                out = resp.getWriter();
                Object object= JSON.toJSON(ResultUtil.success(messageList));
                out.print(object);
                out.flush();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                out.close();
            }
        }

    }
}
