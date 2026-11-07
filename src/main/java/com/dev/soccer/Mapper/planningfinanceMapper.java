package com.dev.soccer.Mapper;


import com.dev.soccer.DTO.requests.planningfinanceRequest;
import com.dev.soccer.model.planningfinance;
import com.dev.soccer.model.timeslot;
import org.springframework.stereotype.Component;

@Component
public class planningfinanceMapper {
    public planningfinance toEntity(planningfinanceRequest request){
        planningfinance planningfinance = new planningfinance();

        planningfinance.setPlanning(request.planning());

        return planningfinance;
    }
}
