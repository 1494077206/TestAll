package zy.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zy.entity.User;
import zy.mapper.UserMapper;
import zy.result.ResultReturn;

import java.util.List;

/**
 * Created by Administrator on 2020/3/20.
 */
@Service
@Transactional
@Slf4j
public class UserService {


    @Autowired
    private UserMapper userMapper;

    public List<User> list() {
      return userMapper.userList();
    }

    public List<User>  add(List<User> userList) {
        int errorCount=0;
        int i = userMapper.addUser(userList);
        if (i>0){
            return userList;
        }else{
            errorCount++;
        }
        System.out.println("添加失败:"+errorCount);
        return null;
    }
}
