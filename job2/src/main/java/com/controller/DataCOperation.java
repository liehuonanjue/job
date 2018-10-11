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
    @ResponseBody
    public void saleList(int uid, PrintWriter pw) throws Exception {
        int num = iDataCOperationMapper.DeletePosts(uid);
        System.out.println(num);
        if (num > 0) {
            pw.write("true");
        } else {
            pw.write("flase");
        }
    }

    @RequestMapping("/ad")
    @ResponseBody
    public void ad(@Validated ReplyDetail replyDetail, PrintWriter pw) throws Exception {
        int num = iDataCOperationMapper.AddAReply(replyDetail);
        if (num > 0) {
            pw.write("true");
        } else {
            pw.write("flase");
        }
    }


}
