/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ChatRoom.Main;

import com.ChatRoom.Controller.ChatController;
import com.ChatRoom.Observer.ChatObserver;
import com.ChatRoom.Observer.ChatObserverImpl;
import com.ChatRoom.View.ChatWindow;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.ChatRoom.Connector.ServerConnector;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;

/**
 *
 * @author Emal Isuranga
 */
public class StartClient {

    public static void main(String[] args) {
        try {
            String name = JOptionPane.showInputDialog(null, "Enter User Name");
            ChatWindow chatWindow = new ChatWindow();
            ChatObserverImpl chatObserverImpl = new ChatObserverImpl(chatWindow);
            ChatController chatController = ServerConnector.getServerConnector().getChatController();
            chatController.addChatObserver(chatObserverImpl);
        } catch (RemoteException ex) {
            Logger.getLogger(StartClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(StartClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(StartClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
