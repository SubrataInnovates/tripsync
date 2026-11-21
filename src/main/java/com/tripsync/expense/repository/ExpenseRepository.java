package com.tripsync.expense.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripsync.expense.entity.Expense;



public interface ExpenseRepository
        extends JpaRepository<Expense, Long> {

    // Get all expenses of a trip, newest first
    List<Expense> findByTrip_IdOrderByExpenseDateDesc(Long tripId);

    // Get a particular expense belonging to a trip
    Optional<Expense> findByIdAndTrip_Id(Long id, Long tripId);

    // Get expenses paid by a particular user in a trip
    List<Expense> findByPaidBy_IdAndTrip_Id(Long userId, Long tripId);
}
