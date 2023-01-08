package com.emlakcepteservice.service;

import com.emlakcepteservice.model.Message;
import com.emlakcepteservice.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public void createMessage(Message message) {
        messageRepository.createMessage(message);
    }

    public List<Message> getAllMessage() {
        return messageRepository.findAllMessage();
    }

    public void printAllMessage() {
        getAllMessage().forEach(message -> System.out.println(message.getTitle()));
    }

    public void update(Message message , Long id) {
        messageRepository.update(message, id);
    }
    public void delete(Long id) {
        messageRepository.delete(id);
    }
    public Message getById(Long id) {
        return messageRepository.getById(id);
    }
}
