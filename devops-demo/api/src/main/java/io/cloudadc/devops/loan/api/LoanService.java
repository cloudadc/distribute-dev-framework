package io.cloudadc.devops.loan.api;

import java.util.List;

public interface LoanService {

	void addLoan(Loan loan);
	
	List<Loan> getLoanById(Integer id);
	
	List<Loan> getAllLoans();
	
	Integer updateLoan(Loan loan);
	
	Integer deleteLoanById(Integer id);


}
