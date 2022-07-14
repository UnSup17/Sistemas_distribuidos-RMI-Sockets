package sop_rmi_gestionSensores;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dto.DatosSensorDTO;

public interface GestionSensoresInt extends Remote{
    public boolean registrarSensor(int numHabitacion) throws RemoteException;
    public boolean enviarDatosSensor(int numHabitacion, DatosSensorDTO objDatosSensor) throws RemoteException;
}
