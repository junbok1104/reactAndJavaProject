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

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner{

	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private OwnerRepository ownerRepository;
	
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
		
		//CommandLineRunner를 이용하여 H2 DB에 데이터를 먼저 넣기 위해 사용
		carRepository.save(new Car(owner1, "Ford", "Mustang", "Red", "ADF-1121", 2021, 59000));
		carRepository.save(new Car(owner2, "Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000));
		carRepository.save(new Car(owner2, "Toyota", "Prius", "Silver", "KKO-0212", 2020, 39000));
		
		for(Car car : carRepository.findAll()) { 
			logger.info(car.getBrand() + " " + car.getModel());
		}
		
	}

}
