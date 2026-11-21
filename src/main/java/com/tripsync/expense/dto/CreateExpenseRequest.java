package com.tripsync.expense.dto;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.tripsync.expense.entity.ExpensesCategory;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record CreateExpenseRequest(

    @NotBlank
    @Size(max = 150)
    String title,

    @Size(max = 1000)
    String description,

    @NotNull
    ExpensesCategory category,

    @NotNull
    @DecimalMin(value = "0.01")
    @Digits(integer = 10, fraction = 2)
    BigDecimal amount,

    @NotNull
    LocalDate expenseDate,

    @NotEmpty
    @NotNull
    @Size(min=1)
    List<@Valid ExpenseSplitRequest> splits

) {
}