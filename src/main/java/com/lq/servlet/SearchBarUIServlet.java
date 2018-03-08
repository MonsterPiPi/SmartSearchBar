package com.lq.servlet;


import com.lq.bean.Message;
import com.lq.service.QueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by LiQian_Nice on 2018/3/8
 */

public class SearchBarUIServlet extends HttpServlet {

    private static Logger logger= LoggerFactory.getLogger(SearchBarUIServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command="查看";
        QueryService queryService=new QueryService();
        List<Message> messageList=queryService.queryMessageList(command);
        logger.info(messageList.toString());
        req.getRequestDispatcher("index.jsp").forward(req,resp);
        logger.info("跳转成功");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
