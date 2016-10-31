package com.jyall.mapper;

import com.jyall.mapper.provider.ProductMapperProvider;
import com.jyall.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * Created by wang.linqiao on 2016/10/31.
 */
@Mapper
public interface ProductMapper {

    @SelectProvider(type = ProductMapperProvider.class,method = "getProductList")
    public List<Product> getProductList(Map<String,String> param);
}
