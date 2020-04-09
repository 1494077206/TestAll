package zy.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import zy.entity.Student;
import zy.mapper.StudentMapper;
import zy.resp.ResponseCodes;
import zy.resp.RestApiResponse;
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

    public RestApiResponse voList(){

        List<ListVo> listVos = studentMapper.voList();
        if(!CollectionUtils.isEmpty(listVos)){
            return RestApiResponse.success(listVos);
        }
        return RestApiResponse.build(ResponseCodes.NODATA);
    }

    public Student doLogin(Student student) {
        return studentMapper.doLogin(student);
    }

    public Student addStudent(Student students) {
        studentMapper.addStudent(students);


        return students;
    }
}
