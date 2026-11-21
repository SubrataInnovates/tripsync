package com.tripsync.sattlement.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripsync.sattlement.entity.Settlement;




public interface SettlementRepository
        extends JpaRepository<Settlement, Long> {

    // Get all settlements of a trip, newest first
    List<Settlement> findByTrip_IdOrderBySettleAtDesc(
            Long tripId);

    // Get all settlements paid by a user in a trip
    List<Settlement> findByTrip_IdAndPayer_Id(
            Long tripId, Long payerId);

    // Get all settlements received by a user in a trip
    List<Settlement> findByTrip_IdAndPayee_Id(
            Long tripId, Long payeeId);
}
