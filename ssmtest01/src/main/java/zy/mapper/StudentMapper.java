package zy.mapper;

import zy.entity.Student;
import zy.vo.ListVo;

import java.util.List;

/**
 * Created by Administrator on 2020/3/14.
 */
public interface StudentMapper {

    Student doLogin(Student student);

    List<ListVo> voList();

    void addStudent(Student students);
}
