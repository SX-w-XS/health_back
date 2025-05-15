package com.health.mapper;

import com.health.entities.ChatApply;
import com.health.entities.ChatMessage;
import com.health.vo.ChatApplyVO;
import com.health.vo.ChatMessageVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ChatMessageMapper extends Mapper<ChatMessage> {

    @Select("SELECT * FROM chat_record ORDER BY chat_id DESC LIMIT #{limit}")
    List<ChatMessage> selectRecentMessages(int limit);
    //插入会话申请
    @Insert("insert into conversation (apply_id, recevie_id, content,create_time,status) values (#{applyId}, #{recevieId},#{content},#{createTime}, 0)")
    int insertChatApply(ChatApply chatApply);
    //通过会话申请
    @Update("update conversation set status = 1 where chat_id = #{id}")
    void updateChatApply(Integer id);
    //检查是否存在会话
    @Select("select * from conversation where apply_id = #{applyId} and recevie_id = #{recevieId}")
    ChatApply checkChat(Integer applyId, Integer recevieId);
    //用户查询所有会话
    @Select("select c.*,u.user_img as img,u.nickname as bickname from conversation c join h_user u on (c.apply_id = #{userId} and u.user_id = c.recevie_id) where c.apply_id = #{userId}")
    List<ChatApplyVO> getChatApplyList(Integer userId);
    //医生获取与自身相关的会话
    @Select("select c.*,u.user_img as img,u.nickname as bickname from conversation c join h_user u on (c.recevie_id = #{userId} and u.user_id = c.apply_id) where c.recevie_id = #{userId}")
    List<ChatApplyVO> getApplyList(Integer userId);

    //消息记录相关sql
    //插入消息记录
    @Insert("insert into chat_record (sender_id, receive_id, content,send_time) values (#{id}, #{sender},#{content}, #{timestamp})")
    void sendAndSaveMessage(ChatMessage chatMessage);
    //查询消息记录
    @Select("select sender_id,receive_id,content,send_time from chat_record where (sender_id = #{sendId} and receive_id = #{receiveId}) or (sender_id = #{receiveId} and receive_id = #{sendId})")
        List<ChatMessageVO> getHistoryMessage(Integer sendId, Integer receiveId);
}