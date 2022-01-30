package io.cloudadc.devops.loan.provider.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.client.result.UpdateResult;

import io.cloudadc.devops.loan.api.Loan;
import io.cloudadc.devops.loan.api.LoanService;

@DubboService(version = "${demo.service.version}", loadbalance = "roundrobin")
public class LoanServiceImpl implements LoanService {
	
	Logger logger = LoggerFactory.getLogger(LoanServiceImpl.class);
	
	@Autowired
	MongoTemplate mongoTemplate;


	@Override
	public List<Loan> getLoanById(Integer id) {
		
		logger.info("getLoanById be invoked, id: " + id );
		
		Query query = new Query(); 
		query.addCriteria(Criteria.where("id").is(id));
		List<Loan> list = mongoTemplate.find(query, Loan.class);
		
		return list;
	}

	@Override
	public Integer deleteLoanById(Integer id) {
		
		logger.info("deleteLoanById be invoked, id: " + id );
		
		Query query = new Query(); 
		query.addCriteria(Criteria.where("id").is(id));
		List<Loan> list = mongoTemplate.findAllAndRemove(query, Loan.class);
		
		return list.size();
	}

	@Override
	public List<Loan> getAllLoans() {
		
		logger.info("getAllLoans be invoked");
		
		List<Loan> list = mongoTemplate.findAll(Loan.class);
		
		return list;
	}

	@Override
	public void addLoan(Loan loan) {

		logger.info("addLoan be invoked: " + loan);
		
		mongoTemplate.insert(loan);
	}

	@Override
	public Integer updateLoan(Loan loan) {
		
		logger.info("updateLoan be invoked: " + loan);
		
		Update update = new Update();
		update.set("user", loan.getUsers());
		update.set("phone", loan.getPhone());
		Query query = new Query(); 
		query.addCriteria(Criteria.where("id").is(loan.getId()));
		UpdateResult result = mongoTemplate.updateMulti(query, update, Loan.class);
		
		return result.getMatchedCount() > 0 ? 1 : 0 ;
	}

	

}
