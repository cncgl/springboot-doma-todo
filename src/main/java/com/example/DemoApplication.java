package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@SpringBootApplication
// @RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	ReservationDao reservationDao;

	@RequestMapping(path = "/")
	List<Reservation> all()	{
		return reservationDao.selectAll();
	}

	@RequestMapping(path = "/", params = "name")
	List<Reservation> name(@RequestParam String name) {
		return reservationDao.selectByName(name);
	}
}
