package com.splitwise.mini.service;

import java.util.List;

import com.splitwise.mini.dto.ExpenseSplitDTO;

public interface ExpenseSplitService {
	List<ExpenseSplitDTO> getExpenseSplitsByExpenseId(Integer expenseId);
	 String requestToMarkAsPaid(Integer splitId);
	 String requestToMarkAsSettled(Integer splitId);

}
