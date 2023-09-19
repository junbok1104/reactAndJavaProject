package com.packt.cardatabase;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;
import com.packt.cardatabase.domain.User;
import com.packt.cardatabase.domain.UserRepository;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner{

	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	@Autowired
	private UserRepository urRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Application Started");
	}

	@Override
	public void run(String... args) throws Exception {
		
		//소유자 객체를 추가하고 DB에 저장
		Owner owner1 = new Owner("John", "Johnson");
		Owner owner2 = new Owner("Mary", "Robinson");
		ownerRepository.saveAll(Arrays.asList(owner1, owner2));
		
		// 자동차 객체를 추가하고 소유자 객체에 연결하며 데이터베이스에 저장
		Car car1 = new Car(owner1,"Ford", "Mustang", "Red","ADF-1121",2021,59000);
		Car car2 = new Car(owner2,"Nissan", "Mustang", "White","SSJ-3002",2019,29000);
		Car car3 = new Car(owner2,"Toyota", "Prius", "Silver","KKO-0212",2020,39000);
		
		carRepository.saveAll(Arrays.asList(car1, car2, car3));
			
		for(Car car : carRepository.findAll()) { 
			logger.info(car.getBrand() + " " + car.getModel());
		}
		
		// 사용자 이름 : user, 암호 : user
		urRepository.save(new User("user", "$2a$04$JuVoz7PT10hDD65Rw5dRCu4MH1gweZHmO1NLgaZf5ecum4CMx4BJ6", "USER"));

		// 사용자 이름 : admin, 암호 : admin
		urRepository.save(new User("admin", "$2a$04$bSrQJM9j46.PKKP9Wlvr/eoDak9sgGyoyB9E/26mJlpJpTD4rawIO", "ADMIN"));
		
	}

}
