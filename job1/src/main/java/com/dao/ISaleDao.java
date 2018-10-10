package com.dao;

import com.entity.Sale;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISaleDao {
    //销售
    public int insertSale(Sale sale);

    //查询
    public List<Sale> getSaleList(@Param("order") String order);
//        public List<Sale> getSaleList(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("order") String order);
}
