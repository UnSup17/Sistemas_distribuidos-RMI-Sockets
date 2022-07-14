package sop_rmi_gestionSensores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import dto.DatosSensorDTO;

public class GestionSensoresImpl extends UnicastRemoteObject implements GestionSensoresInt {
    private Map<Integer, DatosSensorDTO> datosHabitaciones;

    public GestionSensoresImpl() throws RemoteException {
        super();
        this.datosHabitaciones = new HashMap<Integer, DatosSensorDTO>();
    }

    @Override
    public boolean registrarSensor(int numHabitacion) throws RemoteException {
        System.out.println("Entrando a registrar Sensor...");
        datosHabitaciones.put(numHabitacion, null);
        return false;
    }

    @Override
    public boolean enviarDatosSensor(int numHabitacion, DatosSensorDTO objDatosSensor) throws RemoteException {
        datosHabitaciones.put(numHabitacion, objDatosSensor);
        return false;
    }
}