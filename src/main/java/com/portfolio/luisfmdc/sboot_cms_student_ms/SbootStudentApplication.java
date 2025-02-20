package com.portfolio.luisfmdc.sboot_cms_student_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SbootStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbootStudentApplication.class, args);
	}

}
