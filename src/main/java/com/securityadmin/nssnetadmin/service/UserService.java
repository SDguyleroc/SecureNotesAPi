package com.securityadmin.nssnetadmin.service;

import com.securityadmin.nssnetadmin.dto.UserDTO;
import com.securityadmin.nssnetadmin.model.User;

import java.util.List;

public interface UserService {

    void updateUserRole(Long userId, String roleName);

    List<User> getAllUsers();

    UserDTO getUserById(Long id);

    User findByUsername(String username);
}
