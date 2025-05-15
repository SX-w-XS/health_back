package com.health.service;

import com.health.dto.UserCertifyDTO;
import com.health.dto.UserDTO;
import com.health.dto.UserLoginDTO;
import com.health.dto.UserSignUpDTO;
import com.health.entities.ChatApply;
import com.health.entities.Message;
import com.health.entities.Review;
import com.health.entities.User;
import com.health.vo.ChatApplyVO;
import com.health.vo.CountDataVO;
import com.health.vo.DoctorVO;
import com.health.vo.UserVO;

import java.util.List;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.service
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
public interface UserService {
    User login(UserLoginDTO userLoginDTO);

    void register(UserSignUpDTO userSignUpDTO);

    void update(UserDTO user);

    void certify(UserCertifyDTO userCertifyDTO);

    List<Review> getCertifyById(String userId);

    List<Message> getMessages();

    CountDataVO countData(Integer userId);

    String applyChat(ChatApply chatApply);

    List<ChatApplyVO> getChatApplyList(Integer userId);
    List<ChatApplyVO> getApplyList(Integer userId);
    void passApply(Integer id);
    List<DoctorVO> getAllDoctor();
    void saveImagePath(String fileUrl);
}
