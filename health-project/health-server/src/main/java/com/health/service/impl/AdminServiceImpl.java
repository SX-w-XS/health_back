package com.health.service.impl;

import com.health.constant.MessageConstant;
import com.health.dto.UserLoginDTO;
import com.health.entities.User;
import com.health.entities.UserExample;
import com.health.exception.AccountNotFoundException;
import com.health.exception.PasswordErrorException;
import com.health.mapper.UserMapper;
import com.health.service.AdminService;
import com.health.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.service.impl
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserMapper userMapper;

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
    public List<User> queryAll() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andRoleNotEqualTo(1);
        return userMapper.selectByExample(userExample);
    }


}
