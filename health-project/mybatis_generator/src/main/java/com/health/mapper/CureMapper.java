package com.health.mapper;

import com.health.entities.Cure;
import com.health.entities.CureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface CureMapper extends Mapper<Cure> {
    long countByExample(CureExample example);

    int deleteByExample(CureExample example);

    List<Cure> selectByExampleWithBLOBs(CureExample example);

    List<Cure> selectByExample(CureExample example);

    int updateByExampleSelective(@Param("row") Cure row, @Param("example") CureExample example);

    int updateByExampleWithBLOBs(@Param("row") Cure row, @Param("example") CureExample example);

    int updateByExample(@Param("row") Cure row, @Param("example") CureExample example);
}