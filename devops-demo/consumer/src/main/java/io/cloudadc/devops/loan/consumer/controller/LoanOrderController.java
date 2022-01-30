package io.cloudadc.devops.loan.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.cloudadc.devops.loan.api.Loan;
import io.cloudadc.devops.loan.api.LoanService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping(produces = {"application/json", "application/xml"})
@Tag(name = "order", description = "The order API")
public class LoanOrderController {
	
	@Autowired
	private LoanService loanService;

	@RequestMapping(path = {"/api/loan"}, method = {RequestMethod.GET})
	@Operation(summary = "Get Loan by id", description = "Return a Loan")
	public List<Loan> loan(@RequestParam("id") @Parameter(description = "id", required = true)Integer id) {
		return loanService.getLoanById(id);
	}
	
	@RequestMapping(path = {"/api/loans"}, method = {RequestMethod.GET})
	@Operation(summary = "Get all Loans", description = "Return all Loans")
	public List<Loan> loan() {
		return loanService.getAllLoans();
	}
	
	@RequestMapping(path = {"/api/loan/delete"}, method = {RequestMethod.DELETE})
	@Operation(summary = "Delete Loan", description = "Delete Loan")
	public Integer deleteLoan(@RequestParam("id") @Parameter(description = "id", required = true)Integer id) {
		return loanService.deleteLoanById(id);
	}
	
	@RequestMapping(path = {"/api/loan"}, method = {RequestMethod.POST})
	@Operation(summary = "Add Loan", description = "Add Loan")
	public void loan(@io.swagger.v3.oas.annotations.parameters.RequestBody @org.springframework.web.bind.annotation.RequestBody Loan loan) {
		loanService.addLoan(loan);
	}
	
	@RequestMapping(path = {"/api/loan"}, method = {RequestMethod.PUT})
	@Operation(summary = "Update Loan", description = "Update Loan")
	public Integer updateLoan(@io.swagger.v3.oas.annotations.parameters.RequestBody @org.springframework.web.bind.annotation.RequestBody Loan loan) {
		return loanService.updateLoan(loan);
	}
	
}
