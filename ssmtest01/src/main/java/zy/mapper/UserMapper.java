package zy.mapper;

import org.apache.ibatis.annotations.Param;
import zy.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2020/3/14.
 */
public interface UserMapper {


    List<User> userList();

    int addUser(@Param("users") List<User> users);
}
