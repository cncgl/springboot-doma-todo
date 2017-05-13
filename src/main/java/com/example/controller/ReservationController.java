package com.example.controller;

import com.example.Reservation;
import com.example.ReservationDao;
import org.seasar.doma.jdbc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Reservation show(@PathVariable Integer id) {
        return reservationDao.find(id);
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation create(@Valid @RequestBody ReservationRequest request) {
        Reservation reservation = new Reservation(request.getName());
        Result result = reservationDao.insert(reservation);
        return (Reservation)result.getEntity();
    }

    @RequestMapping(method=RequestMethod.PUT, value="{id}")
    public Reservation update(@PathVariable Integer id, @Valid @RequestBody ReservationRequest request) {
        Reservation reservation = new Reservation(id, request.getName());
        Result result = reservationDao.update(reservation);
        return (Reservation)result.getEntity();
    }

    @RequestMapping(method=RequestMethod.DELETE, value="{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Integer id) {
        Reservation entity = reservationDao.find(id);
        reservationDao.delete(entity);
    }
}
