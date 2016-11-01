package com.jyall.resource;

import com.jyall.common.Constans;
import com.jyall.pojo.Product;
import com.jyall.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品管理
 * Created by wang.linqiao on 2016/10/31.
 */
@Controller
@RequestMapping("/product")
@Api(description = "商品管理相关接口", value = "/product")
public class ProductResource {
    private Logger logger = LoggerFactory.getLogger(ProductResource.class);

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "获取商品列表", notes = "", httpMethod = "GET")
    @RequestMapping("/getProductList")
    public String getProductList(Model model, String idOrName, String title, String price) {
        try {
            Map<String, String> param = new HashMap<>();
            param.put("idOrName", idOrName);
            param.put("title", title);
            param.put("price", price);
            StringBuilder queryParam = new StringBuilder();
            for (Map.Entry<String, String> entry : param.entrySet()) {
                if (!StringUtils.isEmpty(queryParam.toString())) {
                    queryParam.append("&");
                }
                String key = entry.getKey();
                if (!"pageNow".equals(key)) {
                    queryParam.append(key + "=" + (StringUtils.isEmpty(entry.getValue()) ? "" : entry.getValue()));
                }
            }

            List<Product> productList = productService.getProductList(param);
            model.addAttribute("productList", productList);
            model.addAttribute("idOrName",idOrName);
            model.addAttribute("title",title);
            model.addAttribute("price",price);
            model.addAttribute("queryParam",queryParam);

            return "/product/product_list";
        } catch (Exception e) {
            logger.error("获取用户列表失败", e);
            return null;
        }
    }

}
