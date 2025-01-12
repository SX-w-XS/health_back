package com.health.service.impl;

import com.health.constant.MessageConstant;
import com.health.dto.UserDTO;
import com.health.dto.UserLoginDTO;
import com.health.dto.UserSignUpDTO;
import com.health.entities.User;
import com.health.entities.UserExample;
import com.health.exception.AccountNotFoundException;
import com.health.exception.PasswordErrorException;
import com.health.mapper.UserMapper;
import com.health.service.UserService;
import com.health.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.UUID;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.service.impl
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
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
    public void register(UserSignUpDTO userSignUpDTO) {
        //判断是否存在相同的用户名
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(userSignUpDTO.getUsername());
        List<User> users = userMapper.selectByExample(userExample);
        if(users != null && users.size() > 0){
        String password = userSignUpDTO.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        User user = new User();
        BeanUtils.copyProperties(userSignUpDTO,user);
        user.setPassword(password);
        userMapper.insert(user);}
        else {
             throw new AccountNotFoundException(MessageConstant.ACCOUNT_FOUND);
        }
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
    public void update(UserDTO userDTO) {
        User user=new User();
        BeanUtils.copyProperties(userDTO,user);
        userMapper.updateByPrimaryKeySelective(user);
    }
}
