package zy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("zy.mapper")
public class Ssmtest01Application {

	public static void main(String[] args) {
		SpringApplication.run(Ssmtest01Application.class, args);
	}

}
