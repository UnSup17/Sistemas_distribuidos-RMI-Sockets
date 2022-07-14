/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sop_gestionSensores;

import dto.DatosSensorDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author David Escobar
 */
public interface GestionSensoresInt extends Remote{
    public boolean registrarSensor(int numHabitacion) throws RemoteException;
    public boolean enviarDatosSensor(int numHabitacion, DatosSensorDTO objDatosSensor) throws RemoteException;
}
