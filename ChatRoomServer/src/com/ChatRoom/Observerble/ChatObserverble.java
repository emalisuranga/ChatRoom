/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ChatRoom.Observerble;

import com.ChatRoom.Observer.ChatObserver;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emal Isuranga
 */
public class ChatObserverble {

    private ArrayList<ChatObserver> ChatClientList = new ArrayList<>();

    public void addChatObserver(ChatObserver chatObserver) {
        ChatClientList.add(chatObserver);
    }

    public void removeChatObserver(ChatObserver chatObserver) {
        ChatClientList.remove(chatObserver);
    }

    public void notifyChatObserver(String message) throws RemoteException {
        for (ChatObserver client : ChatClientList) {
          //  client.update(message);
            new Thread(){
            public void run(){
                try {
                    client.update(message);
                } catch (RemoteException ex) {
                    Logger.getLogger(ChatObserverble.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }.start();
            
            }
        }
    }

