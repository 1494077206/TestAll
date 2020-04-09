package zy.basic;

import java.util.concurrent.CompletableFuture;



/**
 * @Author lizhilong
 * @create 2019/11/18 18:07
 * @desc
 * runAsyn 无返回结果，执行get()方法时，任务被触发。
 */
public class RunAsync {



    public  static  void  main(String [] args) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
            System.out.println("Hello");
        });
        System.out.println("--------------");
        try {
            future.get();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
