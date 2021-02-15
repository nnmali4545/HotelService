package com.hotelservice.Controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hotelservice.Controller,com.hotelservice.Service")
public class HotelServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelServiceApplication.class, args);
	}

}
