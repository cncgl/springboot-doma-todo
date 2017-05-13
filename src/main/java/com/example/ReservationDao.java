package com.example;

import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;
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

    // @Insert(sqlFile = true)
    @Insert
    @Transactional
    Result<Reservation> insert(Reservation reservation);
    // int insert(Reservation reservation);

    @Update(sqlFile = true)
    @Transactional
    Result<Reservation> update(Reservation reservation);
    // int update(Reservation reservation);

    @Delete(sqlFile = true)
    @Transactional
    Result<Reservation> delete(Reservation reservation);
    // int delete(Reservation reservation);
}
