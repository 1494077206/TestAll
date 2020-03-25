package zy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zy.entity.Student;
import zy.result.ResultReturn;
import zy.service.StudentService;
import zy.vo.ListVo;

import java.util.List;

/**
 * Created by Administrator on 2020/3/14.
 */
@RestController
@CrossOrigin
@Slf4j
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Student login(@RequestBody Student student){
      Student stu = studentService.doLogin(student);
      return stu;
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public List<ListVo> listVos(){
        for (ListVo listVo : studentService.voList()) {
            System.out.println(listVo);
        }
        return studentService.voList();
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ResultReturn addStudent(@RequestBody Student students){

        long startTime = System.currentTimeMillis();
        studentService.addStudent(students);

        long sum=0;
        long endTime = System.currentTimeMillis();

        sum+=endTime-startTime;
        log.info("共执行{}",sum);
        return new ResultReturn(true,"添加成功",students);
    }

}
