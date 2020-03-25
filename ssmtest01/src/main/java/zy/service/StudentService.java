package zy.service;

import lombok.extern.slf4j.Slf4j;
import zy.controller.StudentController;
import zy.entity.Student;
import zy.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zy.vo.ListVo;

import java.util.List;

/**
 * Created by Administrator on 2020/3/14.
 */
@Service
@Transactional
@Slf4j
public class StudentService {


    @Autowired
    private StudentMapper studentMapper;

    public List<ListVo> voList(){
       return studentMapper.voList();
    }

    public Student doLogin(Student student) {
        return studentMapper.doLogin(student);
    }

    public Student addStudent(Student students) {
        studentMapper.addStudent(students);


        return students;
    }
}
