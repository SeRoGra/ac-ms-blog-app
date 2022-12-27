package co.com.accenture.acmsblogapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = { "co.com.accenture.acmsblogapp.client" })
public class AcMsBlogAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcMsBlogAppApplication.class, args);
	}

}
