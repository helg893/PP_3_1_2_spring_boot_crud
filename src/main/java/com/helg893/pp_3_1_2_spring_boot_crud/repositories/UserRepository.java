package com.helg893.pp_3_1_2_spring_boot_crud.repositories;

import com.helg893.pp_3_1_2_spring_boot_crud.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
