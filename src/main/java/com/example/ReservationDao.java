package com.example;

import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by shigeru on 17/05/05.
 */
@ConfigAutowireable
@Dao
public interface ReservationDao {
    @Select
    List<Reservation> selectAll();

    @Select
    List<Reservation> selectByName(String name);

    @Select
    Reservation find(int id);

    @Insert(sqlFile = true)
    @Transactional
    int insert(Reservation reservation);

    @Update(sqlFile = true)
    @Transactional
    int update(Reservation reservation);

    @Delete(sqlFile = true)
    @Transactional
    int delete(Reservation reservation);
}
