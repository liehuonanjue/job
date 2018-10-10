package com.controller;

import com.entity.Product;
import com.entity.Users;
import com.service.IProductService;
import com.service.IUsersService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * 登陆注销
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUsersService iUsersService;
    @Resource
    private IProductService iProductService;


    @RequestMapping("/login")
    public ModelAndView login(String userName, String password, HttpServletResponse response, HttpSession session) throws IOException {
        ModelAndView mv = null;
        System.out.println("接收的值为：" + userName + ":" + password);
        Users users = iUsersService.doLogin(userName, password);
        if (users == null) {
            mv = new ModelAndView("/login");
            response.setContentType("text/html; charset=UTF-8"); //转码
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('用户名或者密码错误！');");
            out.println("</script>");
        } else {
            mv = new ModelAndView("/main");
            mv.addObject("user", users);
            List<Product> productList = iProductService.getProductList();
            mv.addObject("prolist", productList);
            session.setAttribute("usermodel", users);
            session.setAttribute("productList", productList);
        }
        return mv;
    }


    @RequestMapping("/loginout")
    public String loginout(HttpSession session) {
        session.removeAttribute("user");
        return "/login";
    }
}
