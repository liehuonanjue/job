package com.service;

import com.entity.Invitation;
import com.entity.ReplyDetail;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ISaleService {
    //查询
    public PageInfo<Invitation> getSaleList(String order, int pageNum, int pageSize);
//    public List<Sale> getSaleList(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("order") String order);

    //带条件分页查询
    public PageInfo<ReplyDetail> getSaleReply(String order, int pageNum, int pageSize);

}
