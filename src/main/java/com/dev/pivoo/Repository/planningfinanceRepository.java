package com.dev.pivoo.Repository;

import com.dev.pivoo.model.planningfinance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface planningfinanceRepository extends JpaRepository<planningfinance,Long> {

    @Query("SELECT c FROM planningfinance c WHERE c.exclude_date IS NULL")
    List<planningfinance> findActivePlanningfinances();

    @Query("SELECT c FROM planningfinance c WHERE c.exclude_date IS NOT NULL")
    List<planningfinance> findInactivePlanningfinances();

}
