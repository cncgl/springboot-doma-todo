package com.example.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by shigeru on 17/05/14.
 */
@ToString
public class ReservationRequest {

    @NotEmpty
    @Getter
    @Setter
    private String name;
}
