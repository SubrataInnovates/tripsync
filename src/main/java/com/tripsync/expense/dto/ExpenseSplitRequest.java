package com.tripsync.expense.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public record ExpenseSplitRequest(@NotNull Long userId,@NotNull @DecimalMin("0.00") BigDecimal shareAmount)
{

}
