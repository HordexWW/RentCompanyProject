package com.example.demo.service;

import com.example.demo.model.AppUser;
import com.example.demo.model.Message;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageService {
    List<Message> getAllMessages();

    void postMessage(Message message);

    List<Message> getMessagesBySender(AppUser sender);
}
