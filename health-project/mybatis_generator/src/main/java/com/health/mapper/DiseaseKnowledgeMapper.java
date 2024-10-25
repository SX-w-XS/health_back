package com.health.mapper;

import com.health.entities.DiseaseKnowledge;
import com.health.entities.DiseaseKnowledgeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface DiseaseKnowledgeMapper extends Mapper<DiseaseKnowledge> {
    long countByExample(DiseaseKnowledgeExample example);

    int deleteByExample(DiseaseKnowledgeExample example);

    List<DiseaseKnowledge> selectByExampleWithBLOBs(DiseaseKnowledgeExample example);

    List<DiseaseKnowledge> selectByExample(DiseaseKnowledgeExample example);

    int updateByExampleSelective(@Param("row") DiseaseKnowledge row, @Param("example") DiseaseKnowledgeExample example);

    int updateByExampleWithBLOBs(@Param("row") DiseaseKnowledge row, @Param("example") DiseaseKnowledgeExample example);

    int updateByExample(@Param("row") DiseaseKnowledge row, @Param("example") DiseaseKnowledgeExample example);
}