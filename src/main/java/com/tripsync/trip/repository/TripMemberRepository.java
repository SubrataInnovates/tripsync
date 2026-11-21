
package com.tripsync.trip.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripsync.trip.entity.TripMember;

public interface TripMemberRepository
        extends JpaRepository<TripMember, Long> {

    // Find all members of a trip
    List<TripMember> findByTrip_Id(Long tripId);

    // Find all trips associated with a user
    List<TripMember> findByUser_Id(Long userId);

    // Find a specific member in a trip
    Optional<TripMember> findByTrip_IdAndUser_Id(
            Long tripId, Long userId);

    // Check whether a user is already a member of a trip
    boolean existsByTrip_IdAndUser_Id(
            Long tripId, Long userId);
}
