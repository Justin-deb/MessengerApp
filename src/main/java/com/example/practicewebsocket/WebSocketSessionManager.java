package com.example.practicewebsocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WebSocketSessionManager {
    private final List<String> activeUsernames = new ArrayList<>();
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public WebSocketSessionManager(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void addUser(String username){
        activeUsernames.add(username);
    }

    public void removeUser(String username){
        activeUsernames.remove(username);
    }

    public void broadcastActiveUsernames(){
        messagingTemplate.convertAndSend("/topic/users", activeUsernames);
        System.out.println("Broadcasting active users to /topic/users: " + activeUsernames);
    }
}
