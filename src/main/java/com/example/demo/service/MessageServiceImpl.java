package com.example.demo.service;


import com.example.demo.model.AppUser;
import com.example.demo.model.Message;
import com.example.demo.repository.MessageRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Data
@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public void postMessage(Message message) {
        messageRepository.save(message);
    }

    @Override
    public List<Message> getMessagesBySender(AppUser sender) {
        return messageRepository.getMessagesBySender(sender);
    }


}
