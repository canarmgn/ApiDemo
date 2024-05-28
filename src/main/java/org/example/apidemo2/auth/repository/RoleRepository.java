package org.example.apidemo2.auth.repository;

import org.example.apidemo2.auth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {

}
