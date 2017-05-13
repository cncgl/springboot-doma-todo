package com.example;

import lombok.Getter;
import org.seasar.doma.*;

/**
 * Created by shigeru on 17/05/05.
 */
@Entity(immutable = true)
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private final Integer id;
    @Getter
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
