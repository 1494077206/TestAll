package zy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zy.entity.User;
import zy.result.ResultReturn;
import zy.service.UserService;

import java.util.List;

/**
 * Created by Administrator on 2020/3/20.
 */

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResultReturn list(){
        if (userService.list() != null) {
            return new ResultReturn(true,"查询成功",userService.list());
        }else{
            return new ResultReturn(false,"查询失败");
        }
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResultReturn add(@RequestBody List<User> userList){
        long start = System.currentTimeMillis();

        List<User> add = userService.add(userList);
        long end   = System.currentTimeMillis();
        log.info("插入时间共:{}",String.valueOf(end-start)+"毫秒");
        return new ResultReturn(true,"插入成功！",add);
    }
}
