package com.jyall.common;

import com.jyall.pojo.Dict;
import com.jyall.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wang.linqiao on 2016/10/28.
 */
@Component
public class Constans {
    @Autowired
    private DictService dictService;

    public static final Map<String, String> PRODUCT_SORT_MAP = new HashMap<>();

    //    @PostConstruct
    public void init() {
        PRODUCT_SORT_MAP.clear();
        List<Dict> productSort = dictService.getDictByTypeCode("1");
        if (productSort != null && !productSort.isEmpty()) {
            for (int i = 0; i < productSort.size(); i++) {
                Dict dict = productSort.get(i);
                PRODUCT_SORT_MAP.put(dict.getId().toString(), dict.getContent());
            }
        }
    }
}
