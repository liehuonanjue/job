package com.dao;

import com.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IProductDao {
    //查询
    public List<Product> getProductList();

    //查询库存
    public Product getProductById(Integer id);

    //修改库存
    int updateProduct(@Param("quantity") Integer quantity, @Param("id") Integer id);
}
