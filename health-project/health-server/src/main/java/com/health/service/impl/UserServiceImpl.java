package com.health.service.impl;

import com.health.constant.MessageConstant;
import com.health.dto.UserCertifyDTO;
import com.health.dto.UserDTO;
import com.health.dto.UserLoginDTO;
import com.health.dto.UserSignUpDTO;
import com.health.entities.*;
import com.health.exception.AccountNotFoundException;
import com.health.exception.PasswordErrorException;
import com.health.mapper.*;
import com.health.service.UserService;
import com.health.vo.ChatApplyVO;
import com.health.vo.CountDataVO;
import com.health.vo.DoctorVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.service.impl
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private MedicineMapper medicineMapper;

    @Resource
    private MessageMapper messageMapper;

    @Resource
    private ChdRecordMapper chdRecordMapper;

    @Resource
    private ChdRecordMapper recordMapper;

    @Resource
    private CertifyMapper certifyMapper;

    @Resource
    private ChatMessageMapper chatMessageMapper;

    @Resource
    private DoctorMapper doctorMapper;

    @Resource
    private ChatServiceImpl chatServiceImpl;

    @Override
    public User login(UserLoginDTO userLoginDTO) {
       String username = userLoginDTO.getUsername();
       String password = userLoginDTO.getPassword();

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);

        List<User> users = userMapper.selectByExample(userExample);

        if(users == null || users.size() == 0){
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        User user = users.get(0);
        //密码比对
         password= DigestUtils.md5DigestAsHex(password.getBytes());
         if(!password.equals(user.getPassword())){
             throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
         }
        return user;
    }

    @Override
    public void register(UserSignUpDTO userSignUpDTO) {
        //判断是否存在相同的用户名
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(userSignUpDTO.getUsername());
        List<User> users = userMapper.selectByExample(userExample);
        if(users != null && users.size() > 0){
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_FOUND);}
        else {
            String password = userSignUpDTO.getPassword();
            password = DigestUtils.md5DigestAsHex(password.getBytes());
            User user = new User();
            BeanUtils.copyProperties(userSignUpDTO,user);
            user.setPassword(password);
            user.setUpdateTime(new Date());
            user.setCreateTime(new Date());
            userMapper.insert(user);}

        }



    @Override
    public void update(UserDTO userDTO) {
        User user=new User();
        BeanUtils.copyProperties(userDTO,user);
        user.setUpdateTime(new Date());
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void certify(UserCertifyDTO userCertifyDTO) {
        // 1. 获取当前时间（本地时区，如中国的 GMT+8）
        LocalDateTime now = LocalDateTime.now();
        // 2. 定义目标格式（空格分隔日期和时间，无毫秒）
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 3. 格式化为指定字符串
        String formattedTime = now.format(formatter);
        userCertifyDTO.setCreateTime(formattedTime);
        certifyMapper.insertReview(userCertifyDTO);
    }

    @Override
    public List<Review> getCertifyById(String userId) {
        return certifyMapper.selectReviewsById(userId);
    }

    @Override
    public List<Message> getMessages() {
        //查询前五条新记录
        return  messageMapper.selectMessageFive();
    }

    @Override
    public CountDataVO countData(Integer userId) {
        CountDataVO countDataVO = new CountDataVO();
        ChdRecord chdRecord= chdRecordMapper.selectLastRecordByUserId(userId);
        countDataVO.setScore(chdRecord.getScore());
        //BMI=体重(kg)/身高(m)的平方
        countDataVO.setBMI(chdRecord.getWeight()/(chdRecord.getHeight()*chdRecord.getHeight()));
        if (chdRecord.getScore()>=90){
        countDataVO.setLevel(1);}
        else if (chdRecord.getScore()>=70) {
            countDataVO.setLevel(2);}
        else if (chdRecord.getScore()>=50) {
            countDataVO.setLevel(3);
        }else {
            countDataVO.setLevel(4);
        }
        countDataVO.setUseCount(chdRecordMapper.selectCountByUserId(userId));
        return countDataVO;
    }

    @Override
    public String applyChat(ChatApply chatApply) {
        if(!chatServiceImpl.checkChat(chatApply.getApplyId(), chatApply.getRecevieId())){
            // 1. 获取当前时间（本地时区，如中国的 GMT+8）
            LocalDateTime now = LocalDateTime.now();
            // 2. 定义目标格式（空格分隔日期和时间，无毫秒）
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            // 3. 格式化为指定字符串
            String formattedTime = now.format(formatter);
            chatApply.setCreateTime(formattedTime);
            int row = chatMessageMapper.insertChatApply(chatApply);
            if (row > 0) {
                return "发送申请成功";
            }else {
                return "发送申请失败";
            }
        }else {
            return "会话已存在，无需再次申请";
        }

    }

    @Override
    public void passApply(Integer id) {
        chatMessageMapper.updateChatApply(id);
    }

    @Override
    public List<ChatApplyVO> getChatApplyList(Integer userId){
        return chatMessageMapper.getChatApplyList(userId);
    }
    @Override
    public List<ChatApplyVO> getApplyList(Integer userId){
        return chatMessageMapper.getApplyList(userId);
    }

    @Override
    public List<DoctorVO> getAllDoctor() {
        return doctorMapper.getAllDoctors();
    }

    @Override
    public void saveImagePath(String fileUrl) {
//        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<Medicine> getMedical() {


        return medicineMapper.selectALLMedicine();
    }

    @Override
    public void saveAvtorPath(String filePath,Integer userId) {
        userMapper.updateUserImg(filePath,userId);
    }
    @Override
    public void saveApplyPath(String filePath,Integer userId) {
        userMapper.updateApplyImg(filePath,userId);
    }
}
