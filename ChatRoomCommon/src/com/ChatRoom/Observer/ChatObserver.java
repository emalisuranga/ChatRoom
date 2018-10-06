/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ChatRoom.Observer;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Emal Isuranga
 */
public interface ChatObserver extends Remote{
    public void update(String message) throws RemoteException;
}
