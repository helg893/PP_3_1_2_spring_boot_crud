package com.helg893.pp_3_1_2_spring_boot_crud.services;

import com.helg893.pp_3_1_2_spring_boot_crud.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(long id);
    void save(User user);
    void update(long id, User updatedUser);
    void delete(long id);
}
