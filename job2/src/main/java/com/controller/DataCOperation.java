package com.controller;

import com.dao.IDataCOperationMapper;
import com.entity.ReplyDetail;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.PrintWriter;

@Controller
@RequestMapping("/Operation")
public class DataCOperation {
    @Resource
    private IDataCOperationMapper iDataCOperationMapper;
    PrintWriter printWriter = null;

    @RequestMapping("/delete")
    public String saleList(int uid, HttpServletResponse response) throws Exception {
        response.setContentType("text/html; charset=UTF-8"); //转码
        int num = iDataCOperationMapper.DeletePosts(uid);
        printWriter = response.getWriter();
        if (num > 0) {
            printWriter.flush();
            printWriter.println("<script>");
            printWriter.println("alert('刪除成功！');");
            printWriter.println("</script>");
            return "redirect:/Operation/inde";
        } else {
            printWriter.flush();
            printWriter.println("<script>");
            printWriter.println("alert('刪除失败！');");
            printWriter.println("</script>");
            return "redirect:/Operation/inde";
        }
    }

    @RequestMapping("/ad")
    public String ad(@Validated ReplyDetail replyDetail, HttpServletResponse response) throws Exception {
        response.setContentType("text/html; charset=UTF-8"); //转码
        int num = iDataCOperationMapper.AddAReply(replyDetail);
        printWriter = response.getWriter();
        System.out.println(num);
        if (num > 0) {
            printWriter.println("<script>");
            printWriter.println("alert('添加成功！');");
            printWriter.println("</script>");
            System.out.println("2q-----------------------------------++++_____________________");
            return "redirect:/Operation/inde";
        } else {
            printWriter.flush();
            printWriter.println("<script>");
            printWriter.println("alert('添加失败！');");
            printWriter.println("</script>");
            return "/add";
        }
    }

    @RequestMapping("/inde")
    public String indexx() {
        System.out.println("w2");
        return "index";
    }

}
