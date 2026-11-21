package com.tripsync.trip.dao;



import java.time.LocalDate;

public record TripResponse(

        Long id,
        String title,
        String description,
        String destination,
        LocalDate startDate,
        LocalDate endDate,
        Long ownerId,
        String ownerName
) {
}