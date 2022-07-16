package co.edu.unicauca.clienteNotificacion.servicios;

import co.edu.unicauca.clienteNotificacion.controladores.NotificacionCllbckImpl;
import co.edu.unicauca.clienteNotificacion.utilidades.UtilidadesRegistroC;
import co.edu.unicauca.servidor.controladores.ControladorRegistroClienteNotificacionInt;

public class ClienteDeObjetos {
    public static void main(String[] args) {
        try {
            int numPuertoRMIRegistry = 8089;
            String direccionIpRMIRegistry = "localhost";
            ControladorRegistroClienteNotificacionInt servidor = (ControladorRegistroClienteNotificacionInt) UtilidadesRegistroC.obtenerObjRemoto(numPuertoRMIRegistry,
                    direccionIpRMIRegistry, "objRemoteNotificacion");
            NotificacionCllbckImpl objNuevoClienteNotificacion = new NotificacionCllbckImpl();
            servidor.registrarReferenciaClienteNotificacion(objNuevoClienteNotificacion);
        } catch (Exception e) {
            System.out.println("No se pudo realizar la conexion...");
            System.out.println(e.getMessage());
        }
    }
}