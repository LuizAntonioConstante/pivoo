package com.dev.pivoo.service;

import com.dev.pivoo.DTO.requests.planningfinanceRequest;
import com.dev.pivoo.Mapper.planningfinanceMapper;
import com.dev.pivoo.Repository.planningfinanceRepository;
import com.dev.pivoo.model.planningfinance;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class planningfinanceService {

    private final planningfinanceRepository planningfinanceRepository;
    private final planningfinanceMapper planningfinanceMapper;

    public planningfinanceService(planningfinanceRepository planningfinanceRepository, planningfinanceMapper planningfinanceMapper) {
        this.planningfinanceRepository = planningfinanceRepository;
        this.planningfinanceMapper = planningfinanceMapper;
    }

    @Transactional
    public planningfinance saveplanningfinance(planningfinanceRequest request){

        planningfinance planningfinancefinal = planningfinanceMapper.toEntity(request);

        return planningfinanceRepository.save(planningfinancefinal);
    }

    @Transactional
    public void deletePlanningfinance(Long id){

        boolean exists = planningfinanceRepository.existsById(id);
        if(exists){
            planningfinanceRepository.deleteById(id);
        }
        else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "planningfinance not found"
            );
        }
    }

    @Transactional
    public planningfinance editPlanningfinance(Long id, planningfinanceRequest request){

        planningfinance editPlanningfinance = planningfinanceRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "planningfinance not found")
        );

        planningfinanceMapper.updateEntity(editPlanningfinance, request);

        return planningfinanceRepository.save(editPlanningfinance);
    }

    @Transactional(readOnly = true)
    public List<planningfinance> findAllPlanningfinances(){

        return planningfinanceRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<planningfinance> findActivePlanningfinances(){

        return planningfinanceRepository.findActivePlanningfinances();
    }

    @Transactional(readOnly = true)
    public List<planningfinance> findInactivePlanningfinances(){

        return planningfinanceRepository.findInactivePlanningfinances();
    }

    @Transactional(readOnly = true)
    public planningfinance getplanningfinanceById(Long id){

        return planningfinanceRepository.findById(id).orElseThrow();
    }

    @Transactional
    public planningfinance deactivatePlanningfinance(Long id){

        planningfinance editPlanningfinance = planningfinanceRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "planningfinance not found")
        );

        if (editPlanningfinance.getRemove_date() == null) {
            editPlanningfinance.setRemove_date(LocalDateTime.now());
        }

        return planningfinanceRepository.save(editPlanningfinance);

    }

    @Transactional
    public planningfinance reactivatePlanningfinance(Long id){

        planningfinance editPlanningfinance = planningfinanceRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "planningfinance not found")
        );

        if (editPlanningfinance.getRemove_date() != null) {
            editPlanningfinance.setRemove_date(null);
        }

        return planningfinanceRepository.save(editPlanningfinance);

    }
}
