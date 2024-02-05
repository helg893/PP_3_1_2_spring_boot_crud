package com.helg893.pp_3_1_2_spring_boot_crud.services;

import com.helg893.pp_3_1_2_spring_boot_crud.models.User;
import com.helg893.pp_3_1_2_spring_boot_crud.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Transactional
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void update(long id, User updatedUser) {
        updatedUser.setId(id);
        userRepository.save(updatedUser);
    }

    @Transactional
    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @PostConstruct
    private void init() {
        userRepository.save(new User("Chuck", "Norris", "chuck@norr.is"));
        userRepository.save(new User("Bruce", "Lee", "bruce@l.ee"));
        userRepository.save(new User("Гарик", "Харламов", "гар@харлам.ов"));
    }
}
