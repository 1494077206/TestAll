package zy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zy.entity.Student;
import zy.result.ResultReturn;
import zy.service.StudentService;
import zy.service.TestService;

import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2020/3/14.
 */
@RestController
@CrossOrigin
@Slf4j
public class StudentController {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    @Autowired
    private TestService testService;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Student login(@RequestBody Student student){
      Student stu = studentService.doLogin(student);
      return stu;
    }

    //假想的T平台
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String listVos(){
        return "0";
    }

    //访问listvo2方法调T平台
    @RequestMapping(value = "list2",method = RequestMethod.GET)
    public void listVos2() throws Exception {
        testService.ttt();
        System.out.println("abc");
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

    public static void main(String[] args) {
        String fileName="group1/M00/00/8D/CrCMk16MdceAdYe7AAAbIxAL5X0964.WAV";
       // String[] strArray = fileName.split("\\.");
       // int suffixIndex = strArray.length -1;
       // System.out.println(UUID.randomUUID().toString().substring(10) + "." + strArray[suffixIndex]);
        String newName = fileName.substring(fileName.lastIndexOf("/")+1);
        System.out.println(newName);
    }
}
