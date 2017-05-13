package com.example.controller;

import com.example.Reservation;
import com.example.ReservationDao;
import org.seasar.doma.jdbc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method=RequestMethod.GET, value="{id}")
    public Reservation show(@PathVariable int id) {
        return reservationDao.find(id);
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation create(@RequestBody Reservation entity) {
        System.out.println("before:" + entity);
        Result result = reservationDao.insert(entity);
        System.out.println("after:" + result);
        return entity;
    }

    @RequestMapping(method=RequestMethod.PUT, value="{id}")
    public Reservation update(@PathVariable int id, @RequestBody Reservation entity) {
        System.out.println("before:" + entity);
        Result result = reservationDao.update(entity);
        System.out.println("after:" + result);
        return entity;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable int id) {
        Reservation entity = reservationDao.find(id);
        reservationDao.delete(entity);
    }
}
