package com.health.mapper;

import com.health.entities.ChdRecord;
import com.health.entities.ChdRecordExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ChdRecordMapper extends Mapper<ChdRecord> {

    @Select("select * from chd_record where user_id = #{userId} order by create_time desc limit 1")
    ChdRecord selectLastRecord(@Param("userId") String userId);

    @Select("select distinct count(*) from chd_record where positive > 0.8")
    Integer selectHighLevel();

    @Select("select distinct count(*) from chd_record where positive > 0.5 and positive < 0.8")
    Integer selectMidLevel();

    @Select("select distinct count(*) from chd_record where positive < 0.5")
    Integer selectLowLevel();

    @Select("select distinct count(*) from chd_record where positive > 0.9")
    Integer selectHighProLevel();
}