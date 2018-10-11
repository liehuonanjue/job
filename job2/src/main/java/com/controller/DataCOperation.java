package com.controller;

import com.dao.IDataCOperationMapper;
import com.entity.ReplyDetail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
@RequestMapping("/Operation")
public class DataCOperation {
    @Resource
    private IDataCOperationMapper iDataCOperationMapper;
    PrintWriter out = null;

    @RequestMapping("/delete")
    public String saleList(int uid, HttpServletResponse response) throws Exception {
        try {
            response.setContentType("text/html; charset=UTF-8"); //转码
            int num = iDataCOperationMapper.DeletePosts(uid);
            System.out.println(num + "-----" + uid);
            out = response.getWriter();
            if (num > 0) {
                out.flush();
                out.println("<script>");
                out.println("alert('刪除成功！');");
                out.println("</script>");
                return "/index";
            }
            out.flush();
            out.println("<script>");
            out.println("alert('刪除失败！');");
            out.println("</script>");
            return "/index";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/index";
    }

    @RequestMapping("/add")
    public ModelAndView add(ReplyDetail replyDetail, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = null;
        out = response.getWriter();
        int num = iDataCOperationMapper.AddAReply(replyDetail);
        System.out.println(num);
        if (num > 0) {
            System.out.println(num);
            modelAndView = new ModelAndView("/index");
        } else {
            System.out.println("22222");
            modelAndView = new ModelAndView("/add");
        }
        System.out.println("页面你到是给我跳转啊");
        return modelAndView;
    }

}
