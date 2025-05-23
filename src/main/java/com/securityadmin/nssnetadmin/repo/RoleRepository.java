package com.securityadmin.nssnetadmin.repo;

import com.securityadmin.nssnetadmin.model.AppRole;
import com.securityadmin.nssnetadmin.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);

}