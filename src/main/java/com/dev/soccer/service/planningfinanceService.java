package com.dev.soccer.service;

import com.dev.soccer.DTO.requests.planningfinanceRequest;
import com.dev.soccer.DTO.requests.timeslotRequest;
import com.dev.soccer.Mapper.planningfinanceMapper;
import com.dev.soccer.Mapper.timeslotMapper;
import com.dev.soccer.Repository.clientRepository;
import com.dev.soccer.Repository.planningfinanceRepository;
import com.dev.soccer.Repository.timeslotRepository;
import com.dev.soccer.model.client;
import com.dev.soccer.model.planningfinance;
import com.dev.soccer.model.timeslot;
import jakarta.transaction.Transactional;
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
