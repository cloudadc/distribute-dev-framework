package io.cloudadc.dubbo.sample.consumer;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.cloudadc.dubbo.sample.api.UserService;
import io.cloudadc.dubbo.sample.consumer.service.OrderService;
import io.cloudadc.dubbo.sample.consumer.service.impl.OrderServiceImpl;

@SpringBootApplication
public class Application {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
		
	}
	
	@DubboReference(
			version = "1.0.0",
            url = "dubbo://127.0.0.1:20880",
            timeout = 100,
            methods = {
            		@Method(name = "getUserAddress", timeout = 300)
            }
	)
	private UserService userService;
	
	@Bean
    public ApplicationRunner runner() {
        return args -> {
        	 logger.info(userService.getUserAddress(1001).toString());
        };
    }
	
	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl();
	}
	
	@Bean
	public UserService userService() {
		return userService;
	}

}
