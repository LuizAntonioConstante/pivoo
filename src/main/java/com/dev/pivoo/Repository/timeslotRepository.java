package com.dev.pivoo.Repository;

import com.dev.pivoo.model.timeslot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface timeslotRepository extends JpaRepository<timeslot,Long> {

    @Query("SELECT c FROM timeslot c WHERE c.cancel_date IS NULL")
    List<timeslot> findActiveTimeslots();

    @Query("SELECT c FROM timeslot c WHERE c.cancel_date IS NOT NULL")
    List<timeslot> findInactiveTimeslots();

}
