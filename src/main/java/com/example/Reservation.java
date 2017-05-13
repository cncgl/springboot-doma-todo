package com.example;

import org.seasar.doma.*;

/**
 * Created by shigeru on 17/05/05.
 */
@Entity(immutable = true)
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Integer id;
    private final String name;

    @Override
    public String toString() {
        return "[" + id + "," + name + "]";
    }

    public Reservation(String name) {
        this.id = null;
        this.name = name;
    }
    public Reservation(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
