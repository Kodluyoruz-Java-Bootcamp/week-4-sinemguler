package com.emlakcepteservice.controller;

import com.emlakcepteservice.model.Message;
import com.emlakcepteservice.model.Realty;
import com.emlakcepteservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<Message> getAll() {
        return messageService.getAllMessage();
    }

    @PostMapping
    public ResponseEntity<Message> create(@RequestBody Message message) {
        System.out.println("message" + message);
        messageService.createMessage(message);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        messageService.delete(id);
        return "deleted" + id;
    }

    @PutMapping("/update")
    public void update(@RequestBody Message message, Long id) {
        messageService.update(message, id);
    }

    @GetMapping("/{id}")
    public Message getById(@PathVariable() Long id) {
        return messageService.getById(id);
    }
}
