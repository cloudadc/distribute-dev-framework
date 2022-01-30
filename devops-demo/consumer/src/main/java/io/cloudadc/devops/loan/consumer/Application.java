package io.cloudadc.devops.loan.consumer;

import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.cloudadc.devops.loan.api.LoanService;

@SpringBootApplication
public class Application {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
		
	}
	
	// Direct conenct to provider
	//@DubboReference(version = "1.0.0", url = "dubbo://127.0.0.1:20880", timeout = 100, methods = { @Method(name = "getUserAddress", timeout = 300)})
	@DubboReference(version = "${demo.service.version}", loadbalance = "roundrobin")
	private LoanService loanService;
	
	@Bean
    public ApplicationRunner runner() {
        return args -> {
        	 logger.info(loanService.getAllLoans().toString());
        };
    }
	
	
	@Bean
	public LoanService loanService() {
		return loanService;
	}

}
