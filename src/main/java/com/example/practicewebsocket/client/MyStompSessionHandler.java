package com.example.practicewebsocket.client;


import com.example.practicewebsocket.Message;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;

public class MyStompSessionHandler extends StompSessionHandlerAdapter {
    private String username;

    public MyStompSessionHandler(String username) {
        this.username = username;
    }

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        System.out.println("Connected to server");
        session.send("/app/connect", username);

        session.subscribe("/topic/messages", new StompFrameHandler() {
            @Override
            public Type getPayloadType(StompHeaders headers) {
                System.out.println("Runing getPayloadType");
                return Message.class;
            }

            @Override
            public void handleFrame(StompHeaders headers, Object payload) {
                try{
                    if(payload instanceof Message){
                        Message message = (Message) payload;
                        System.out.println("Received message: " + message.getUser() + ": " + message.getMessage());
                    }else{
                        System.out.println("Received unexpected payload type: " + payload.getClass());
                    }
                }catch(Exception e) {
                    e.printStackTrace();
                }

            }

        });
        System.out.println("Suscribed to /topic/messages");
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {
        exception.printStackTrace();
    }
}
