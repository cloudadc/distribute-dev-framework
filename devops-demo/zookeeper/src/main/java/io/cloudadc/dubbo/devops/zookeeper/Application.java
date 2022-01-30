package io.cloudadc.dubbo.devops.zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application{
	

	public static void main(String[] args) throws InterruptedException {
		
		new EmbeddedZooKeeper(2181, false).start();
		
		Thread.sleep(1000);
		
		SpringApplication.run(Application.class, args);
	}


}
