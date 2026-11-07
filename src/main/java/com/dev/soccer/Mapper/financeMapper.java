package com.dev.soccer.Mapper;

import com.dev.soccer.DTO.requests.financeRequest;
import com.dev.soccer.model.finance;
import org.springframework.stereotype.Component;

@Component
public class financeMapper {
    public finance toEntity(financeRequest request){
        finance finance = new finance();

        finance.setType(request.type());
        finance.setPaidreceived_date(request.paidreceived_date());
        finance.setRemove_date(request.remove_date());
        finance.setAmount(request.amount());
        finance.setDue_date(request.due_date());


        return finance;
    }
}
