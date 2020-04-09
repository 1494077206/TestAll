package zy.controller;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import zy.http.HttpClientUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("test")
public class TestController {

    @RequestMapping(value = "t",method = RequestMethod.GET)
    public void t(HttpServletResponse response) throws IOException {
        String s = send();
        if (s.equalsIgnoreCase("no")){
            log.info("调用T平台失败");
        }else{
            log.info("调用T平台成功");
            response.sendRedirect("http://localhost:8081/list");
        }
    }


    private String send(){

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @SneakyThrows
            @Override
            public String get() {
                String s = HttpClientUtil.doGet("http://localhost:8081/test/t2");
                if (s.equalsIgnoreCase("no")){
                    return "no";
                }else{
                    return s;
                }
            }
        });

        try {
            int count = 1;
            for (int i=1;i<=5;i++){
                String s = future1.get();
                if ("ok".equals(s)){
                    log.info("返回的值为:"+s);
                    return s;
                }else{
                    log.warn("调用T平台失败,重试:"+count+"次");
                    future1.get();
                    ++count;
                    if (count>5){
                       log.warn("放弃listVos方法,不调了");
                        return "no";
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "error";
    }


    @RequestMapping(value = "t2",method = RequestMethod.GET)
    public String t2(){
        return "no";
    }

    public static void main(String[] args) {
    }
}
