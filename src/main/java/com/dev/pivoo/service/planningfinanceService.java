package com.dev.pivoo.service;

import com.dev.pivoo.DTO.requests.planningfinanceRequest;
import com.dev.pivoo.Mapper.planningfinanceMapper;
import com.dev.pivoo.Repository.planningfinanceRepository;
import com.dev.pivoo.model.planningfinance;
import org.springframework.stereotype.Service;

@Service
public class planningfinanceService {

    private final planningfinanceRepository planningfinanceRepository;
    private final planningfinanceMapper planningfinanceMapper;

    public planningfinanceService(planningfinanceRepository planningfinanceRepository, planningfinanceMapper planningfinanceMapper) {
        this.planningfinanceRepository = planningfinanceRepository;
        this.planningfinanceMapper = planningfinanceMapper;
    }

    public planningfinance saveplanningfinance(planningfinanceRequest request){

        planningfinance planningfinancefinal = planningfinanceMapper.toEntity(request);

        return planningfinanceRepository.save(planningfinancefinal);
    }
}
