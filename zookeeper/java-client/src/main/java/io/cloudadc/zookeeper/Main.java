package io.cloudadc.zookeeper;

import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	private static final int TIMEOUT = 3000; 

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		if (args.length < 1) {
            System.err
                    .println("USAGE: connectString [args ...]");
            System.exit(2);
        }
        String connectString = args[0];
        
		logger.info("start running");
		
		pressAnyKeyToContinue("Create a new ZooKeeper");
		
		ZooKeeper zk = new ZooKeeper(connectString, TIMEOUT, new Watcher() {

			@Override
			public void process(WatchedEvent event) {
				logger.info("Type: " + event.getType() + ", Path: " + event.getPath(), ", State: " + event.getState());
			}});
		
		pressAnyKeyToContinue("Create a path");
		
		zk.create("/java", "HelloWOrld".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		
		pressAnyKeyToContinue("Read from a /java");
		
		List<String> results = zk.getChildren("/java", true);
		System.out.println("/java: " + results);
		
		pressAnyKeyToContinue("Delete /java");
		zk.delete("/java", 1);
		
		pressAnyKeyToContinue("Close Java Client");
		zk.close();
		
		pressAnyKeyToContinue("exit");
	}
	
	@SuppressWarnings("static-access")
	private void pressAnyKeyToContinue(String msg) throws Exception { 
	        
		Thread.currentThread().sleep(2000);
		System.out.println();
		System.out.println("Press Enter key to ... " + msg);
		System.in.read();
		System.out.println();
	 }
	

}
