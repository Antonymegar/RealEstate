package com.example.realestate.Repositories;

import com.example.realestate.model.Role;
import com.example.realestate.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role,Long > {
     Optional<Role> findByName(RoleName roleName);
}
