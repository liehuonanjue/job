package com.dao;

import com.entity.Invitation;
import com.entity.ReplyDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISaleMapper {

    //带条件分页查询
    public List<Invitation> getSaleList(@Param("order") String order);

    //带条件分页查询
    public List<ReplyDetail> getSaleReply(@Param("order") String order);
}
