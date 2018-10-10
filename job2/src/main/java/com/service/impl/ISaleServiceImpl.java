package com.service.impl;

import com.entity.Invitation;
import com.entity.ReplyDetail;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.dao.ISaleMapper;
import com.service.ISaleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by FLC on 2018/8/24.
 */
@Service("iSaleServiceImpl")
public class ISaleServiceImpl implements ISaleService {
    @Resource
    private ISaleMapper iSaleMapper;


    @Override
    public PageInfo<Invitation> getSaleList(String order, int pageNum, int pageSize) {
        Page<Invitation> page = PageHelper.startPage(pageNum, pageSize);
        iSaleMapper.getSaleList(order);
        return page.toPageInfo();

    }

    @Override
    public PageInfo<ReplyDetail> getSaleReply(String order, int pageNum, int pageSize) {
        Page<ReplyDetail> page = PageHelper.startPage(pageNum, pageSize);
        iSaleMapper.getSaleReply(order);
        return page.toPageInfo();

    }
/*
    @Override
    public List<Sale> getSaleList(int pageIndex, int pageSize, String order) {
        return iSaleDao.getSaleList((pageIndex - 1) * pageSize, pageSize, order);
    }
*/


}
