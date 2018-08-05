package com.springmvc.jparepository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvc.pojo.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{
}
