package com.workshoplab.services.impl;

import com.workshoplab.dto.UserLoginDto;
import com.workshoplab.entities.User;
import com.workshoplab.entities.dtos.UserRegisterDto;
import com.workshoplab.repositories.UserRepository;
import com.workshoplab.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean register(UserRegisterDto userRequest) {
        if (this.userRepository.existsByUsernameOrEmail(userRequest.getUsername(), userRequest.getEmail())) {
            return false;
        }

        if (!userRequest.getPassword().equals(userRequest.getConfirmPassword())) {
            return false;
        }

        var user = this.mapper.map(userRequest, User.class);

        this.userRepository.save(user);

        return true;
    }

    @Override
    public Long validateUserLoginDetails(UserLoginDto userRequest) {
        var user = this.userRepository.findFirstByUsername((userRequest.getUsername()));

        if (user == null) {

            return null;
        }

        if(!user.getPassword().equals(userRequest.getPassword())) {
            return null;
        }

        return user.getId();
    }

    @Override
    public String getXmlForImport() {
        return null;
    }

}
