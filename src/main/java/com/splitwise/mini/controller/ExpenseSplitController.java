package com.splitwise.mini.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.splitwise.mini.dto.ExpenseSplitDTO;
import com.splitwise.mini.service.ExpenseSplitService;

@RestController
@RequestMapping("/api/expense-splits")
public class ExpenseSplitController {

    private final ExpenseSplitService expenseSplitService;

    public ExpenseSplitController(ExpenseSplitService expenseSplitService) {
        this.expenseSplitService = expenseSplitService;
    }

    @GetMapping("/{expenseId}")
    public List<ExpenseSplitDTO> getExpenseSplits(@PathVariable Integer expenseId) {
        return expenseSplitService.getExpenseSplitsByExpenseId(expenseId);
    }

    @PatchMapping("/request-payment/{splitId}")
    public ResponseEntity<String> requestToMarkAsPaid(@PathVariable Integer splitId) {
        String message = expenseSplitService.requestToMarkAsPaid(splitId);
        return message.equals("Split not found")
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(message);
    }
    
    @PatchMapping("/verify-payment/{splitId}")
    public ResponseEntity<String> requestToMarkAsSettled(@PathVariable Integer splitId) {
        String message = expenseSplitService.requestToMarkAsSettled(splitId);
        return message.equals("Split not found")
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(message);
    }
}
