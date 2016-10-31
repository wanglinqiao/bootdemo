package com.jyall.service;

import com.jyall.mapper.ProductMapper;
import com.jyall.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wang.linqiao on 2016/10/31.
 */
@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public List<Product> getProductList(Map<String,String> param){
        return productMapper.getProductList(param);
    }
}
