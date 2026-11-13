package com.dev.pivoo.DTO.requests;

import com.dev.pivoo.model.enums.week_days;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDateTime;

public record timeslotRequest (
    week_days timeslot_day,

    Time timeslot_hour,

    Long id_client,

    BigDecimal price,

    String status,

    Boolean paid,

    LocalDateTime cancel_date
){}
