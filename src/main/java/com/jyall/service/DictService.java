package com.jyall.service;

import com.jyall.mapper.DictMapper;
import com.jyall.pojo.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wang.linqiao on 2016/10/28.
 */
@Service
public class DictService {
    @Autowired
    private DictMapper dictMapper;

    public List<Dict> getDictByTypeCode(String type) {
       return dictMapper.getDictByTypeCode(type);
    }
}
