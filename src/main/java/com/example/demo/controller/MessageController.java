package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.model.Message;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages(@RequestParam(value = "id", required = false) AppUser user) {
        List<Message> messages;
        if (user == null) {
            messages = messageService.getAllMessages();
        } else {
            messages = messageService.getMessagesBySender(user);
        }
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postMessage(@RequestBody Message message) {
        messageService.postMessage(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
