package io.cloudadc.dubbo.sample.provider.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cloudadc.dubbo.sample.api.UserAddress;
import io.cloudadc.dubbo.sample.api.UserService;

@DubboService(version = "1.0.0")
public class UserServiceImpl implements UserService {
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public List<UserAddress> getUserAddress(Integer userID) {
		
		logger.info("getUserAddress be invoked, userID: " + userID);
		
		List<UserAddress> list = new ArrayList<>();
		list.add(new UserAddress(userID, "Beijing, Chaoyang, Building #17", "18611908049"));
		list.add(new UserAddress(userID, "Beijing, Xicheng, Building #09", "18611908049"));
		return list;
	}

	

}
