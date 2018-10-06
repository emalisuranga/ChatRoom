/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ChatRoom.Connector;

import com.ChatRoom.Controller.ChatController;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Emal Isuranga
 */
public class ServerConnector {

    private static ServerConnector serverConnector;
    private ChatController chatController;

    private ServerConnector() throws NotBoundException, MalformedURLException, RemoteException {
        chatController = (ChatController) Naming.lookup("rmi://localhost:5050/ChatServer");
    }

    public static ServerConnector getServerConnector() throws NotBoundException, MalformedURLException, RemoteException {
        if (serverConnector == null) {
            serverConnector = new ServerConnector();
        }

        return serverConnector;
    }

    public ChatController getChatController() {
        return chatController;
    }
}
