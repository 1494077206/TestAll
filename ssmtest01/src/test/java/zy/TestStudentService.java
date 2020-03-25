package zy;




//import zy.service.StudentService;
//import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;
import zy.entity.Student;
import zy.fastDfs.FastDFSClient;
import zy.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zy.vo.ListVo;


/**
 * Created by Administrator on 2020/3/14.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class TestStudentService {
    @Autowired
    private StudentService studentService;

    @Test
    public void stuList(){
        System.out.println("调用方法");
        for (ListVo vo : studentService.voList()) {
            System.out.println(vo);
        }
    }
//"D:/pic/jiushen.jpg", "jpg"
    @Test
    public void testFastDfs() throws Exception {
        FastDFSClient client = new FastDFSClient("D:\\IdeaWorkSpace\\TestAll\\ssmtest01\\src\\main\\resources\\fdfs_client.conf");
        String jpg = client.uploadFile("D:/pic/jiushen.jpg", "jpg");
        log.info("上传的文件为:{}",jpg);
    }
}
