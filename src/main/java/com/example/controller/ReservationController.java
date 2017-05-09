package com.example.controller;

import com.example.Reservation;
import com.example.ReservationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by shigeru on 17/05/08.
 */
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationDao reservationDao;

    @RequestMapping(method=RequestMethod.GET)
    public List<Reservation> index() {
        return reservationDao.selectAll();
    }

    @RequestMapping(method=RequestMethod.GET, value="/{id}")
    public Reservation show(@PathVariable int id) {
        return reservationDao.find(id);
    }


    @RequestMapping(method=RequestMethod.DELETE, value="/{id}")
    public void destroy(@PathVariable int id) {}
}
