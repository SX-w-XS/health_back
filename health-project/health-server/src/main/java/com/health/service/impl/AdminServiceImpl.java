package com.health.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.health.constant.MessageConstant;
import com.health.dto.MessageAddDTO;
import com.health.dto.MessageDTO;
import com.health.dto.UserDTO;
import com.health.dto.UserLoginDTO;
import com.health.entities.*;
import com.health.exception.AccountNotFoundException;
import com.health.exception.PasswordErrorException;
import com.health.mapper.*;
import com.health.service.AdminService;
import com.health.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.service.impl
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserMapper userMapper;

    @Resource
    private MessageMapper messageMapper;

    @Resource
    private SuggestionMapper suggestionMapper;

    @Resource
    private ChdRecordMapper chdRecordMapper;

    @Resource
    private CertifyMapper certifyMapper;

    @Resource
    private DiseaseKnowledgeMapper diseaseKnowledgeMapper;

    @Resource
    private DoctorMapper doctorMapper;

    @Resource
    private MedicineMapper medicineMapper;

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
    public UserVO queryById(String id) {
        User user = userMapper.selectByPrimaryKey(id);
        if(user != null){
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user,userVO);
            return userVO;
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        try {
            userMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            throw new RuntimeException("删除失败");
        }

    }

    @Override
    public void deleteBatch(String[] ids) {
        try {
            for (String id : ids) {
                userMapper.deleteByPrimaryKey(id);
            }
        } catch (Exception e) {
            throw new RuntimeException("删除失败");
        }
    }

    @Override
    public PageInfo<User> queryAll(int pageNum, int pageSize,int limit) {
        PageHelper.startPage(pageNum,pageSize);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andRoleNotEqualTo(1);
        List<User> users = userMapper.selectByExample(userExample);

        PageInfo<User> pageInfo = new PageInfo<>(users);
        pageInfo.setList(users);
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        return pageInfo;
    }

    @Override
    public PageInfo<Message> queryAllMessage(int pageNum, int pageSize, int limit) {
        PageHelper.startPage(pageNum,pageSize);
        MessageExample messageExample = new MessageExample();

        List<Message> messages = messageMapper.selectByExample(messageExample);

        PageInfo<Message> pageInfo = new PageInfo<>(messages);
        pageInfo.setList(messages);
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        return pageInfo;
    }

    @Override
    public PageInfo<UserVO> queryUser(UserDTO user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();

        if (user.getUsername() != null && !user.getUsername().isEmpty()){
        criteria.andUsernameLike("%"+user.getUsername()+"%");}

        if (user.getPhone() != null ){
            criteria.andPhoneEqualTo(user.getPhone());}

        if (user.getEmail() != null && !user.getEmail().isEmpty()){
            criteria.andEmailEqualTo(user.getEmail());}

        if (user.getRole() != null ){
            criteria.andRoleEqualTo(user.getRole());}

        if (user.getUserSex() != null){
            criteria.andRoleEqualTo(user.getUserSex());}

        if (user.getNickname() != null && !user.getNickname().isEmpty()){
            criteria.andNicknameEqualTo(user.getNickname());}

        if(user.getUserId() != null){
            criteria.andUserIdEqualTo(user.getUserId());
        }

        if(user.getStatus() != null){
            criteria.andStatusEqualTo(user.getStatus());
        }

        if(user.getUserAge()!= null){
            criteria.andUserAgeEqualTo(user.getUserAge());
        }

        if(user.getDiseaseId() != null){
            criteria.andDiseaseIdEqualTo(String.valueOf(user.getDiseaseId()));
        }

        List<User> users = userMapper.selectByExample(userExample);
        List<UserVO> userVOS = new ArrayList<>();
        if(users != null && users.size() > 0){
            for (User user1 : users) {
                UserVO userVO = new UserVO();
                BeanUtils.copyProperties(user1,userVO);
                userVOS.add(userVO);
            }
            PageInfo<UserVO> pageInfo = new PageInfo<>(userVOS);
            pageInfo.setList(userVOS);
            return pageInfo;

        }


        return null;
    }

    @Override
    public PageInfo<Message> queryMessage(MessageDTO messageDTO) {
        MessageExample messageExample = new MessageExample();
        MessageExample.Criteria criteria = messageExample.createCriteria();

       if (messageDTO.getKind() != null){
           criteria.andKindEqualTo(messageDTO.getKind());}

       if(messageDTO.getTitle() != null){
           criteria.andTitleLike("%"+messageDTO.getTitle()+"%");
       }

       List<Message> messages = messageMapper.selectByExample(messageExample);
        if(messages != null && messages.size() > 0){
            PageInfo<Message> pageInfo = new PageInfo<>(messages);
            pageInfo.setList(messages);
            return pageInfo;
        }

        return null;
    }

    @Override
    public void addMessage(MessageAddDTO messageAddDTO) {
        Message message = new Message();
        BeanUtils.copyProperties(messageAddDTO,message);
        message.setCreatetime(new Date());
        messageMapper.insert(message);
    }


    @Override
    public void deleteMessage(List<Integer> ids) {
        MessageExample messageExample = new MessageExample();
        MessageExample.Criteria criteria = messageExample.createCriteria();
        criteria.andMessageIdIn(ids);
        messageMapper.deleteByExample(messageExample);
}

    @Override
    public  List<SuggestionVO> getSuggestion() {

        List<Suggestion> suggestions = suggestionMapper.selectAll();
        List<SuggestionVO> suggestionVOS = new ArrayList<>();
        for (Suggestion suggestion : suggestions) {
            SuggestionVO suggestionVO = new SuggestionVO();
            BeanUtils.copyProperties(suggestion,suggestionVO);
            suggestionVOS.add(suggestionVO);
        }

        return suggestionVOS;
    }

    @Override
    public void addUser(UserDTO userAddDTO) {
        User user = new User();
        BeanUtils.copyProperties(userAddDTO,user);
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());
        if(userAddDTO.getRole() == null){
        user.setRole(0);}
        userMapper.insert(user);
    }

    @Override
    public CountUserVO queryCount() {
        CountUserVO countUserVO = new CountUserVO();
        countUserVO.setTotal(userMapper.selectTotal());
        countUserVO.setMan(userMapper.selectMan());
        countUserVO.setWoman(userMapper.selectWoman());
        countUserVO.setHighLevelCVD(chdRecordMapper.selectHighLevel());
        countUserVO.setLowLevelCVD(chdRecordMapper.selectLowLevel());
        countUserVO.setMidLevelCVD(chdRecordMapper.selectMidLevel());
        countUserVO.setHighProLevelCVD(chdRecordMapper.selectHighProLevel());
        countUserVO.setMessageCount(messageMapper.countMessage());
        return countUserVO;
    }

    @Override
    public List<Review> queryCertify(){
        return certifyMapper.selectAllReviews();
    }

    @Override
    public void handleCertify(Review review) {
        log.info("{}",review.getStatus());
        if (review.getStatus() == 1){
            certifyMapper.updateUserRole((Integer) review.getFilerId());
        }
        // 1. 获取当前时间（本地时区，如中国的 GMT+8）
        LocalDateTime now = LocalDateTime.now();
        // 2. 定义目标格式（空格分隔日期和时间，无毫秒）
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 3. 格式化为指定字符串
        String formattedTime = now.format(formatter);
        review.setEndTime(formattedTime);
        certifyMapper.updateReview(review);
        //根据id查询用户信息，将对应信息插入到医生信息表
        User user = userMapper.selectByPrimaryKey((Integer) review.getFilerId());
        Doctor doctor = new Doctor();
        doctor.setDoctorId(user.getUserId());
        doctor.setDoctorAge(user.getUserAge());
        doctor.setDoctorName(user.getNickname());
        doctor.setDoctorSex(user.getUserSex());
        insertDoctor(doctor);
    }

    @Override
    public void insertDoctor(Doctor doctor) {
        doctorMapper.insertDoctor(doctor);
    }

    public List<UserGrowthVO> getGrowthSeries(LocalDate start, LocalDate end) {
        // 查询实际数据

        List<UserPredictUPVO> rawData = userMapper.findDailyGrowth(start, end);
        Map<LocalDate, Integer> dataMap = new HashMap<>();
        for (UserPredictUPVO record : rawData) {
           dataMap.put(record.getPredictTime(), record.getCount());
        }

        // 生成完整日期序列
        List<UserGrowthVO> result = new ArrayList<>();
        int total = 0;

        for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
            int daily = dataMap.getOrDefault(date, 0);
            total += daily;

            UserGrowthVO growth = new UserGrowthVO();
            growth.setDate(date);
            growth.setDailyCount(daily);
            growth.setTotalCount(total);
            result.add(growth);
        }

        return result;
    }
    /**
     * 简单线性预测
     * @param history 历史数据（至少包含7天）
     * @param days 预测天数
     * @return 预测结果（包含累计总数）
     */
    public List<UserGrowthVO> simplePredict(List<UserGrowthVO> history, int days) {
        // 计算日均增长
        double avgGrowth = history.stream()
                .mapToInt(UserGrowthVO::getDailyCount)
                .average()
                .orElse(0);

        // 生成预测数据
        List<UserGrowthVO> forecast = new ArrayList<>();
        int currentTotal = history.get(history.size()-1).getTotalCount();

        for (int i = 1; i <= days; i++) {
            LocalDate date = history.get(history.size()-1).getDate().plusDays(i);
            currentTotal += avgGrowth;

            UserGrowthVO growth = new UserGrowthVO();
            growth.setDate(date);
            growth.setDailyCount((int) Math.round(avgGrowth));
            growth.setTotalCount(currentTotal);
            forecast.add(growth);
        }

        return forecast;
    }

    @Override
    public void addKnowledge(DiseaseKnowledge diseaseKnowledge){
        // 1. 获取当前时间（本地时区，如中国的 GMT+8）
        LocalDateTime now = LocalDateTime.now();
        // 2. 定义目标格式（空格分隔日期和时间，无毫秒）
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 3. 格式化为指定字符串
        String formattedTime = now.format(formatter);
        diseaseKnowledge.setCreateTime(formattedTime);
        diseaseKnowledgeMapper.insertKnowledge(diseaseKnowledge);
    }

    @Override
    public void deleteKnowledge(int id){
        diseaseKnowledgeMapper.deleteKnowledgeById(id);
    }

    @Override
    public void updateKnowledge(DiseaseKnowledge diseaseKnowledge) {
        diseaseKnowledgeMapper.updateKnowledge(diseaseKnowledge);
    }

    @Override
    public List<DiseaseKnowledge> getKnowledge() {
        return diseaseKnowledgeMapper.selectAllKnowledge();
    }

    @Override
    public void addMedicine(Medicine medicine) {
        System.out.println(medicine.getUseage());
        medicineMapper.insertMedicine(medicine);

    }

    @Override
    public void deleteMedicine(Integer medicineId) {
        medicineMapper.deleteMedicine(medicineId);
    }

    @Override
    public void updateMedicine(String path,String medicalName) {
        medicineMapper.updateMedicine(path,medicalName);
    }
}

