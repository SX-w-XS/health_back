package com.health.mapper;

import com.health.entities.Suggestion;
import com.health.entities.SuggestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface SuggestionMapper extends Mapper<Suggestion> {
    long countByExample(SuggestionExample example);

    int deleteByExample(SuggestionExample example);

    List<Suggestion> selectByExampleWithBLOBs(SuggestionExample example);

    List<Suggestion> selectByExample(SuggestionExample example);

    int updateByExampleSelective(@Param("row") Suggestion row, @Param("example") SuggestionExample example);

    int updateByExampleWithBLOBs(@Param("row") Suggestion row, @Param("example") SuggestionExample example);

    int updateByExample(@Param("row") Suggestion row, @Param("example") SuggestionExample example);
}