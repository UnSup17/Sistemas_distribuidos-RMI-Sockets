package co.edu.unicauca.servidor.controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.clienteNotificacion.controladores.NotificacionCllbckInt;

public class ControladorRegistroClienteNotificacionImpl extends UnicastRemoteObject implements ControladorRegistroClienteNotificacionInt {

    private final List<NotificacionCllbckInt> clientesNotificacion; // lista que almacena la referencia remota de los clientes notificacion

    public ControladorRegistroClienteNotificacionImpl() throws RemoteException {
        super();
        clientesNotificacion = new ArrayList<>();
    }

    @Override
    public synchronized boolean registrarReferenciaClienteNotificacion(NotificacionCllbckInt clienteNotificacion) throws RemoteException {
        // método que unicamente puede ser accedido por un hilo
        System.out.println("Invocando al método registrar cliente notificacion desde el servidor");
        if (!clientesNotificacion.contains(clienteNotificacion)) {
            enviarMensaje("ome");
            return clientesNotificacion.add(clienteNotificacion);
        }
        return false;
    }

    @Override
    public void enviarMensaje(String mensaje) throws RemoteException {
        notificarclientesNotificacion("un cliente envio el siguiente mensaje: " + mensaje);
    }

    private void notificarclientesNotificacion(String mensaje) throws RemoteException {
        System.out.println("Invocando al método notificar clientesNotificacion desde el servidor");
        for (NotificacionCllbckInt objUsuario : clientesNotificacion) {
            objUsuario.notificar(mensaje, clientesNotificacion.size());// el servidor hace el callback
        }
    }
}
