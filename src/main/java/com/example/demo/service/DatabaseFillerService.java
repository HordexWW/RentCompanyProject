package com.example.demo.service;

import com.example.demo.model.AppUser;
import com.example.demo.model.Department;
import com.example.demo.model.Message;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.repository.MessageRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Data
@Service
public class DatabaseFillerService {

    private final AppUserRepository appUserRepository;
    private final MessageRepository messageRepository;

    @PostConstruct
    public void fillDatabaseWithSomeAppUsers() {
        appUserRepository.saveAll(Arrays.asList(
                new AppUser("Simon", "Shmygin", Department.LIGHT),
                new AppUser("Ilia", "Loktev", Department.SOUND)
                )
        );
    }

    @PostConstruct
    public void fillDatabaseWithSomeMessages() {
        messageRepository.saveAll(Arrays.asList(
                new Message(LocalDateTime.now(), appUserRepository.getById(1L), "Some content 1"),
                new Message(LocalDateTime.now(), appUserRepository.getById(2L), "Some content 2.1"),
                new Message(LocalDateTime.now(), appUserRepository.getById(2L), "Some content 2.2")
        ));
    }
}
