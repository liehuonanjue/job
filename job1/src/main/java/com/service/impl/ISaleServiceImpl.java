package com.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.dao.ISaleDao;
import com.entity.Sale;
import com.service.ISaleService;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by FLC on 2018/8/24.
 */
@Service("iSaleServiceImpl")
public class ISaleServiceImpl implements ISaleService {
    @Resource
    private ISaleDao iSaleDao;


    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public int insertSale(Sale sale) {
        return iSaleDao.insertSale(sale);
    }

    @Override
    public PageInfo<Sale> getSaleList(String order, int pageNum, int pageSize) {
        Page<Sale> page = PageHelper.startPage(pageNum, pageSize);
        iSaleDao.getSaleList(order);
        return page.toPageInfo();

    }
/*
    @Override
    public List<Sale> getSaleList(int pageIndex, int pageSize, String order) {
        return iSaleDao.getSaleList((pageIndex - 1) * pageSize, pageSize, order);
    }
*/


}
