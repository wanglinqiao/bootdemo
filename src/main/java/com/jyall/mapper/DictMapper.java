package com.jyall.mapper;

import com.jyall.pojo.Dict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by wang.linqiao on 2016/10/31.
 */
@Mapper
public interface DictMapper {

    @Select("select * from dict where typeCode = #{type}")
    public List<Dict> getDictByTypeCode(@Param("type") String type);
}
