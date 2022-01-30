package io.cloudadc.dubbo.devops.mongodb;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import io.cloudadc.devops.loan.api.Loan;

/**
 * Run Docker via:
 *     docker run -itd --rm --name=mongodb -p 27017:27017 mongo:5.0.5
 *     docker run -it --rm --name=mongo --link mongodb mongo:5.0.5 mongo --host mongodb loan
 * @author ksong
 *
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
	

	public static void main(String[] args) throws IOException, InterruptedException {
		
		SpringApplication.run(Application.class, args);
	}
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public void run(String... args) throws Exception {
		
		List<Loan> list = mongoTemplate.findAll(Loan.class);
		list.forEach( l -> {
			Query query = new Query(); 
			query.addCriteria(Criteria.where("id").is(101));
			mongoTemplate.remove(query, Loan.class);
			System.out.println("remove " + l);
		});
				
		System.out.println("Insert Loans");
		mongoTemplate.insert(new Loan(101, "Kylin", "18611907049"));
		mongoTemplate.insert(new Loan(102, "Kylin", "18611907049"));
		
		System.out.println("Get Loan By ID");
		Query query = new Query(); 
		query.addCriteria(Criteria.where("id").is(101));
		list = mongoTemplate.find(query, Loan.class);
		list.forEach(l -> System.out.println(l));
		
		System.out.println("Get All Loans");
		list = mongoTemplate.findAll(Loan.class);
		list.forEach(l -> System.out.println(l));
		
		Loan loan = new Loan(101, "Kylin", "18611907066");
		Update update = new Update();
		update.set("user", loan.getUsers());
		update.set("phone", loan.getPhone());
		query = new Query(); 
		query.addCriteria(Criteria.where("id").is(101));
		mongoTemplate.updateMulti(query, update, Loan.class);
		System.out.println("Updated " + loan);
		
		System.out.println("Get Loan By ID");
		query = new Query(); 
		query.addCriteria(Criteria.where("id").is(101));
		list = mongoTemplate.find(query, Loan.class);
		list.forEach(l -> System.out.println(l));
		
		query = new Query(); 
		query.addCriteria(Criteria.where("id").is(101));
		list = mongoTemplate.findAllAndRemove(query, Loan.class);
		System.out.println(list + " be deleted");
		
		query = new Query(); 
		query.addCriteria(Criteria.where("id").is(102));
		list = mongoTemplate.findAllAndRemove(query, Loan.class);
		System.out.println(list + " be deleted");
		
		
		
		System.out.println("Exit");
	}


}
