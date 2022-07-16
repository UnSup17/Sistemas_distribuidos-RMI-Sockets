package co.edu.unicauca.clienteNotificacion.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NotificacionCllbckInt extends Remote {
    public void notificar(String mensaje, int cantidadUsuarios) throws RemoteException;
}
