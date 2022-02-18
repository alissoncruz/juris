package com.juris.user;

import com.juris.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repository;

    public void save(User user){
        repository.save(user);
    }
}
