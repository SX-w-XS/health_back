package com.health.service;

import com.github.pagehelper.PageInfo;
import com.health.dto.MessageAddDTO;
import com.health.dto.MessageDTO;
import com.health.dto.UserDTO;
import com.health.dto.UserLoginDTO;
import com.health.entities.Message;
import com.health.entities.User;
import com.health.vo.CountUserVO;
import com.health.vo.SuggestionVO;
import com.health.vo.UserGrowthVO;
import com.health.vo.UserVO;

import java.time.LocalDate;
import java.util.List;

public interface AdminService {
    User login(UserLoginDTO userLoginDTO);

    UserVO queryById(String id);

    void deleteById(String id);

    void deleteBatch(String[] ids);

    PageInfo<User> queryAll(int pageNum, int pageSize, int limit);

    PageInfo<Message> queryAllMessage(int pageNum, int pageSize, int limit);

    PageInfo<UserVO> queryUser(UserDTO user);

    PageInfo<Message> queryMessage(MessageDTO messageDTO);

    void addMessage(MessageAddDTO messageAddDTO);

    void deleteMessage(List<Integer> ids);

    List<SuggestionVO> getSuggestion();

    void addUser(UserDTO userAddDTO);

    CountUserVO queryCount();

    List<UserGrowthVO> getGrowthSeries(LocalDate startDate, LocalDate endDate);

    List<UserGrowthVO> simplePredict(List<UserGrowthVO> history, int futureDays);
}
