package co.edu.unicauca.servidor.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;

import co.edu.unicauca.servidor.dto.DatosSensorDTO;

public interface GestionSensoresInt extends Remote{
    public boolean registrarSensor(int numHabitacion) throws RemoteException;
    public boolean enviarDatosSensor(int numHabitacion, DatosSensorDTO objDatosSensor) throws RemoteException;
}