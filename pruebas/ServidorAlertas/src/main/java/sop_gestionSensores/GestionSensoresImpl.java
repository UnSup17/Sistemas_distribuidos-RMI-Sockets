/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sop_gestionSensores;

import dto.DatosSensorDTO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author David Escobar
 */
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
        System.out.println("Entrando a EnviarDatosSensor...");
        datosHabitaciones.put(numHabitacion, objDatosSensor);
        return false;
    }
}
