package com.emlakcepteservice.repository;

import com.emlakcepteservice.model.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageRepository {
    private List<Message> messageList = new ArrayList<>();

    public void createMessage(Message message) {
        messageList.add(message);
    }

    public List<Message> findAllMessage() {
        return messageList;
    }

    public void delete(Long id) {
        messageList.removeIf(message -> message.getId() == id);
    }
    public void update(Message message, Long id) {
        var item = getById(message.getId());
        item.setTitle(message.getTitle());
        item.setContent(message.getContent());
        item.setFrom(message.getFrom());
        item.setTo(message.getTo());
    }
    public Message getById(Long id) {
        for (Message message : messageList) {
            if (message.getId() == id) {
                return message;
            }
        }
        return null;
    }
}
