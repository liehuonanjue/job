package com.service;

import com.github.pagehelper.PageInfo;
import com.entity.Sale;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by FLC on 2018/8/24.
 */
public interface ISaleService {
    //销售
    public int insertSale(Sale sale);
    //查询
    PageInfo<Sale> getSaleList(String order, int pageNum, int pageSize);
//    public List<Sale> getSaleList(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("order") String order);
}
