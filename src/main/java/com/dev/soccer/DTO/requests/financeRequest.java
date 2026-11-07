package com.dev.soccer.DTO.requests;

import com.dev.soccer.model.enums.finance_type;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record financeRequest (

    finance_type type,

    LocalDateTime paidreceived_date,

    LocalDateTime remove_date,

    BigDecimal amount,

    LocalDate due_date,

    Long id_client,

    Long id_timeslot,

    Long id_planning
){}
