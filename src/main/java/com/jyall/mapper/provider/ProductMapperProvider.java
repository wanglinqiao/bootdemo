package com.jyall.mapper.provider;

import java.util.Map;

/**
 * Created by wang.linqiao on 2016/10/31.
 */
public class ProductMapperProvider {

    public String getProductList(Map<String,String> param){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM product where 1=1");
        return sb.toString();
    }
}
