package com.jyall.mapper.provider;

import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * Created by wang.linqiao on 2016/10/31.
 */
public class ProductMapperProvider {

    public String getProductList(Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM product where 1=1");
        if (param == null || param.isEmpty()) {
            return sb.toString();
        }
        String idOrName=param.get("idOrName");
        String title = param.get("title");
        String price = param.get("price");
        if (idOrName != null && StringUtils.isNotBlank(idOrName)) {
            sb.append(" and (id like '%"+idOrName+"%' or name like '%"+idOrName+"%')");
        }
        if (title!=null&&StringUtils.isNotBlank(title)){
            sb.append(" and title like '%"+title+"%'");
        }
        if (price!=null&&StringUtils.isNotBlank(price)){
            String[] splits = price.split("-");
            sb.append(" and (price between "+splits[0]+" and "+splits[1]+")");
        }
        return sb.toString();
    }
}
