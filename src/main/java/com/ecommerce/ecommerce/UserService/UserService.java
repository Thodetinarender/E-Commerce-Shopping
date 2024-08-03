package com.ecommerce.ecommerce.UserService;

import com.ecommerce.ecommerce.dto.UserDto;
import com.ecommerce.ecommerce.model.User;

public interface UserService {
	
	User save (UserDto userDto);
	
	User findById(Long userId);
	
	User findByEmail(String email);

}
