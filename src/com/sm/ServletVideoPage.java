package com.sm;

import com.alibaba.fastjson.JSON;
import com.sm.dao.VideoSelectList;
import com.sm.entity.VideoInfo;
import com.sun.glass.ui.Size;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.util.List;

@WebServlet("/servlet/videopage")
public class ServletVideoPage extends HttpServlet {
     VideoSelectList videoSelectList = new VideoSelectList();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
//获取当前页码，和当前选择的每页显示数量
        String start = req.getParameter("pageNum");
        String size = req.getParameter("size");
        Integer i = Integer.valueOf(start);
        Integer j = Integer.valueOf(size);
        //需要查询的数据为当前页码-1*显示数量 为在数据库中的索引位置
        System.out.println(i+"----"+j);
        List<VideoInfo> videoInfoList = videoSelectList.query((i-1)*j, j);

        //转为json对象
        String s = JSON.toJSONString(videoInfoList);
        resp.getWriter().write(s);

    }

    }
