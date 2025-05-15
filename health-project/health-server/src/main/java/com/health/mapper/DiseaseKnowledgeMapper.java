package com.health.mapper;

import com.health.dto.UserCertifyDTO;
import com.health.entities.DiseaseKnowledge;
import com.health.entities.DiseaseKnowledgeExample;
import com.health.entities.Review;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
public interface DiseaseKnowledgeMapper extends Mapper<DiseaseKnowledge> {
    //管理员
    @Insert("INSERT INTO chronic_disease_knowledge (disease_name, causes,  harmfulness,prevention,create_time) " +
            "VALUES (#{diseaseName}, #{causes},  #{harmfulness},  #{prevention},#{createTime})")
    void insertKnowledge(DiseaseKnowledge knowledge);

    @Delete("DELETE FROM chronic_disease_knowledge WHERE disease_id = #{id}")
    void deleteKnowledgeById(int id);

    @Update("UPDATE chronic_disease_knowledge " +
            "set disease_name = #{diseaseName},causes = #{causes},harmfulness=#{harmfulness},prevention=#{prevention} where disease_id = #{diseaseId}")
    void updateKnowledge(DiseaseKnowledge knowledge);

    @Select("SELECT * FROM chronic_disease_knowledge")
    List<DiseaseKnowledge> selectAllKnowledge();

}