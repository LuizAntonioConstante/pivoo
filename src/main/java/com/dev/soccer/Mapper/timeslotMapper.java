package com.dev.soccer.Mapper;

import com.dev.soccer.DTO.requests.timeslotRequest;
import com.dev.soccer.model.timeslot;
import org.springframework.stereotype.Component;

@Component
public class timeslotMapper {
    public timeslot toEntity(timeslotRequest request){
        timeslot timeslot = new timeslot();

        timeslot.setTimeslot_day(request.timeslot_day());
        timeslot.setTimeslot_hour(request.timeslot_hour());
        timeslot.setPrice(request.price());
        timeslot.setStatus(request.status());
        timeslot.setPaid(request.paid());
        timeslot.setCancel_date(request.cancel_date());

        return timeslot;
    }
}
