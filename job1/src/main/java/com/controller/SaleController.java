package com.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.entity.Product;
import com.entity.Sale;
import com.entity.Users;
import com.service.IProductService;
import com.service.ISaleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//添加和查询
@Controller
@RequestMapping("/sale")
public class SaleController {
    @Resource
    private ISaleService iSaleService;
    @Resource
    private IProductService iProductService;

    @RequestMapping("/insertSale")
    public String insertSale(Sale sale, HttpServletResponse response) throws IOException {
        Product productById = iProductService.getProductById(sale.getProductId());
        if (sale.getQuantitys() > productById.getQuantity()) {
            response.setContentType("text/html; charset=UTF-8"); //转码
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('库存不足！');");
            out.println("</script>");
            return "/main";
        } else {
            //修改库存
            Integer number = productById.getQuantity() - sale.getQuantitys();
            iProductService.updateProduct(number, sale.getProductId());
            //添加记录
            sale.setUserId(2);
            int i = iSaleService.insertSale(sale);
            if (i >= 0) {
                response.setContentType("text/html; charset=UTF-8"); //转码
                PrintWriter out = response.getWriter();
                out.flush();
                out.println("<script>");
                out.println("alert('添加成功！');");
                out.println("</script>");
                return "/main";
            } else {
                response.setContentType("text/html; charset=UTF-8"); //转码
                PrintWriter out = response.getWriter();
                out.flush();
                out.println("<script>");
                out.println("alert('添加失败！');");
                out.println("</script>");
                return "/main";
            }

        }


    }


    @RequestMapping("/salelist")
    @ResponseBody
    public void saleList(@RequestParam(value = "order", defaultValue = "销售日期") String order, @RequestParam(required = false, defaultValue = "1") int pageNum, @RequestParam(required = false, defaultValue = "5") int pageSize, HttpServletResponse response) throws IOException {

        PageInfo<Sale> saleLists = iSaleService.getSaleList(order, (pageNum + 1), pageSize);
        for (Sale u : saleLists.getList()) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String format1 = format.format(u.getSaleDate());
            u.setDatetime(format1);
        }
        response.setCharacterEncoding("utf-8");
        String s = JSON.toJSONString(saleLists);
        response.getWriter().write(s);


    }
}
