package com.example.demo.service;

import com.example.demo.model.AppUser;
import com.example.demo.model.Department;
import com.example.demo.repository.AppUserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Data
@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;

    @Override
    public List<AppUser> getAllAppUsers() {
        return appUserRepository.findAll();
    }
}
