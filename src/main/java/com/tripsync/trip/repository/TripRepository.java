package com.tripsync.trip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripsync.trip.entity.Trip;

public interface TripRepository extends JpaRepository<Trip,Long>
{

}
