package com.jyall.resource;

import com.jyall.common.Constans;
import com.jyall.pojo.Product;
import com.jyall.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 商品管理
 * Created by wang.linqiao on 2016/10/31.
 */
@Controller
@RequestMapping("/product")
@Api(description = "商品管理相关接口",value = "/product")
public class ProductResource {
    private Logger logger = LoggerFactory.getLogger(ProductResource.class);

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "获取商品列表",notes = "",httpMethod = "GET")
    @RequestMapping("/getProductList")
    public String getProductList(Model model){
        try {
            List<Product> productList = productService.getProductList(null);
            model.addAttribute("productList",productList);

            return "/product/product_list";
        }catch (Exception e){
            logger.error("获取用户列表失败",e);
            return null;
        }
    }

}
