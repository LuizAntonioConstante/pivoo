package com.dev.pivoo.Mapper;


import com.dev.pivoo.DTO.requests.planningfinanceRequest;
import com.dev.pivoo.model.planningfinance;
import org.springframework.stereotype.Component;

@Component
public class planningfinanceMapper {
    public planningfinance toEntity(planningfinanceRequest request){
        planningfinance planningfinance = new planningfinance();

        planningfinance.setPlanning(request.planning());

        return planningfinance;
    }
}
