package zy.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import zy.http.HttpClientUtil;

@Component
@EnableAsync
@Slf4j
/***
 *  异步调用
 */
public class TestService {

    @Value("${custom.ftpConfig.count}")
    private int count;//1

    @Value("${custom.ftpConfig.startNum}")
    private int startNum;//1

    @Value("${custom.ftpConfig.endNum}")
    private int endNum; //5

    @Async
    public void ttt() throws Exception {
        String s = send();
        if (s.equalsIgnoreCase("0")) {
            System.out.println("调用T平台成功!");
        } else {
            while (startNum < endNum) {
                String s2 = send();
                if (s2.equalsIgnoreCase("0")) {
                    System.out.println("重试" + count + "次调用T平台成功!");
                } else {
                    System.out.println("重试" + count + "次");
                    count++;
                    if (count == endNum) {
                        System.out.println("放弃调用T平台");
                        return;
                    }
                }
            }
        }
    }

    public String send() throws Exception {
       return HttpClientUtil.doGet("http://127.0.0.1:8081/list");
    }
}
