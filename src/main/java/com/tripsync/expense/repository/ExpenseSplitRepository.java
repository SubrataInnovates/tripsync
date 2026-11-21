package com.tripsync.expense.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripsync.expense.entity.ExpenseSplit;


public interface ExpenseSplitRepository
        extends JpaRepository<ExpenseSplit, Long> {

    // Find all splits for a particular expense
    List<ExpenseSplit> findByExpense_Id(Long expenseId);

    // Find all expense splits belonging to a user
    List<ExpenseSplit> findByUser_Id(Long userId);

    // Find expense splits for a user within a particular trip
    List<ExpenseSplit> findByExpense_Trip_IdAndUser_Id(
            Long tripId, Long userId);
}

