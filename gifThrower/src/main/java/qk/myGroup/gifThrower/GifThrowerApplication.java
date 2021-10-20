package qk.myGroup.gifThrower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;



@SpringBootApplication
@EnableFeignClients
public class GifThrowerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GifThrowerApplication.class, args);
	}

}
