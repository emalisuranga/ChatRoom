/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ChatRoom.Main;

import com.ChatRoom.Controller.ChatControllerImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emal Isuranga
 */
public class ServerStart {

    public static void main(String[] args) {
        try {
            Registry chatRegistry = LocateRegistry.createRegistry(5050);
            System.out.println("Chat Server is Starting");
            chatRegistry.rebind("ClienntServer", new ChatControllerImpl());
        } catch (RemoteException ex) {
            Logger.getLogger(ServerStart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
