package com.health.mapper;

//import com.health.entities.User;
//import com.health.entities.UserExample;
//import com.health.vo.UserPredictUPVO;
//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Select;
//import tk.mybatis.mapper.common.Mapper;
import com.health.dto.UserCertifyDTO;
import com.health.entities.ChatMessage;
import com.health.entities.Review;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

public interface CertifyMapper extends Mapper<UserCertifyDTO> {
//    @Select("select * from review")
//    List<Review> selectAll();
//        用户提交审核信息
@Insert("INSERT INTO review (title, content,  create_time,filer_id,img) " +
        "VALUES (#{title}, #{content},  #{createTime},  #{filer_id},  #{img})")
void insertReview(UserCertifyDTO userCertifyDTO);
//        用户查询提交的审核记录
@Select("SELECT * FROM review where review.filer_id = #{userId}")
List<Review> selectReviewsById(String userId);
//        管理员查询所有审核信息
@Select("SELECT * FROM review")
List<Review> selectAllReviews();
//修改用户身份
@Update("UPDATE h_user set role = 2 where user_id = #{userId}")
void updateUserRole(int userId);
//        管理员通过/驳回审核请求
@Update("UPDATE review " +
        "SET status = #{status}, note = #{note}, end_time = #{endTime} " +
        "WHERE id = #{id}")
void updateReview(Review review);

}
