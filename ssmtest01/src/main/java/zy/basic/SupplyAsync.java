package zy.basic;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * @Author lizhilong
 * @create 2019/11/18 18:17
 * @desc supplyAsync 方法有返回值，在get()方法后被触发
 */
public class SupplyAsync {
    public  static void main(String[] args){
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "Hello";
            }
        });

        System.out.println("-------------");

        try {
            String s = future1.get();
            System.out.println(s);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
