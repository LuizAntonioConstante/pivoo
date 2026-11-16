package com.dev.pivoo.Mapper;


import com.dev.pivoo.DTO.requests.planningfinanceRequest;
import com.dev.pivoo.model.planningfinance;
import org.springframework.stereotype.Component;

@Component
public class planningfinanceMapper {
    public planningfinance toEntity(planningfinanceRequest request){
        planningfinance planningfinance = new planningfinance();

        planningfinance.setPlanning(request.planning());
        planningfinance.setRemove_date(request.exclude_date());

        return planningfinance;
    }

    public void updateEntity(planningfinance editPlanningfinance, planningfinanceRequest request){

        if (request.planning() != null){
            editPlanningfinance.setPlanning(request.planning());
        }
    }
}
