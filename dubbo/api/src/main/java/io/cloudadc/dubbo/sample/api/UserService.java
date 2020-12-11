package io.cloudadc.dubbo.sample.api;

import java.util.List;

public interface UserService {

	List<UserAddress> getUserAddress(Integer userID);
}
