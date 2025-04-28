/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.practicewebsocket.client;

import com.example.practicewebsocket.Message;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Justin
 */
public class ClientGUI {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyStompClient stomp = new MyStompClient("Blaze");
        stomp.sendMessage(new Message("Blaze","Hello Sringboot"));
    }
}
