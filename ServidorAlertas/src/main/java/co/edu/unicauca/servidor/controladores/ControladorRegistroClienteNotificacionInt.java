
package co.edu.unicauca.servidor.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;

import co.edu.unicauca.clienteNotificacion.controladores.NotificacionCllbckInt;

public interface ControladorRegistroClienteNotificacionInt extends Remote {
    public boolean registrarReferenciaClienteNotificacion(NotificacionCllbckInt clienteNotificacion) throws RemoteException;
    public void enviarMensaje(String mensaje) throws RemoteException;
}
