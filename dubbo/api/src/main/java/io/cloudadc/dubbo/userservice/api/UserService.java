package io.cloudadc.dubbo.userservice.api;

import java.util.List;

public interface UserService {

	List<UserAddress> getUserAddress(Integer userID);
}
