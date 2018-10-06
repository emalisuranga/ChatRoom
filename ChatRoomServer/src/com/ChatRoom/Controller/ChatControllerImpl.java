/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ChatRoom.Controller;

import com.ChatRoom.Observer.ChatObserver;
import com.ChatRoom.Observerble.ChatObserverble;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Emal Isuranga
 */
public class ChatControllerImpl implements ChatController{
 
    private ChatObserverble chatObserverble = new ChatObserverble();
    @Override
    public void addChatObserver(ChatObserver chatObserver) throws RemoteException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        chatObserverble.addChatObserver(chatObserver);
    }

    @Override
    public void removeChatObserver(ChatObserver chatObserver) throws RemoteException {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       chatObserverble.removeChatObserver(chatObserver);
    }

    @Override
    public void sendMassge(String message) throws RemoteException {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      chatObserverble.notifyChatObserver(message);
    }
    
}
