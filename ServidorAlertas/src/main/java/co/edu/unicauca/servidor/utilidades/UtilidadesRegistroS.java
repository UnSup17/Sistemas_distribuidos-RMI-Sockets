package co.edu.unicauca.servidor.utilidades;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import co.edu.unicauca.servidor.controladores.ControladorRegistroClienteNotificacionImpl;
import co.edu.unicauca.servidor.controladores.GestionSensoresImpl;

public class UtilidadesRegistroS {
    public static void registrarObjSensor() {
        int numPuertoRMIRegistry_Sensor = 8088;
        String direccionIpRMIRegistry_Sensor = "localhost";
        try {
            GestionSensoresImpl objRemoto_Sensor = new GestionSensoresImpl();
            UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry_Sensor);
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto_Sensor, direccionIpRMIRegistry_Sensor,
                    numPuertoRMIRegistry_Sensor, "objRemoteSensor");
        } catch (Exception e) {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto SENSOR" + e.getMessage());
        }
    }

    public static void registrarObjNotificacion() {
        int numPuertoRMIRegistry_Notificacion = 8089;
        String direccionIpRMIRegistry_Notificacion = "localhost";
        try {
            ControladorRegistroClienteNotificacionImpl objRemoto_Notificacion = new ControladorRegistroClienteNotificacionImpl();
            UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry_Notificacion);
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto_Notificacion, direccionIpRMIRegistry_Notificacion,
                    numPuertoRMIRegistry_Notificacion, "objRemoteNotificacion");
        } catch (Exception e) {
            System.err.println(
                    "No fue posible Arrancar el NS o Registrar el objeto remoto NOTIFICACION" + e.getMessage());
        }
    }

    private static void arrancarNS(int numPuertoRMI) throws RemoteException {
        try {
            Registry registro = LocateRegistry.getRegistry(numPuertoRMI);
            String[] vector = registro.list();
            for (String idNS : vector) {
                System.out.println("ns : " + idNS);
            }
            System.out.println("El rmiRegistry se ha obtenido y se encuentra escuchando en el puerto: "
                    + numPuertoRMI);
        } catch (RemoteException e) {
            System.out.println("El rmiRegistry no se localizó en el puerto: " + numPuertoRMI);
            LocateRegistry.createRegistry(numPuertoRMI);
            System.out.println("El rmiRegistry  se ha creado en el puerto: " + numPuertoRMI);
        }
    }

    private static void RegistrarObjetoRemoto(Remote objetoRemoto, String dirIPNS, int numPuertoNS,
            String identificadorObjetoRemoto) {
        String UrlRegistro = "rmi://" + dirIPNS + ":" + numPuertoNS + "/" + identificadorObjetoRemoto;
        try {
            Naming.rebind(UrlRegistro, objetoRemoto);
            System.out.println("Se realizó el registro del objeto remoto en el ns ubicado en la dirección: "
                    + dirIPNS + " y " + "puerto " + numPuertoNS);
        } catch (RemoteException e) {
            System.out.println("Error en el registro del objeto remoto");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            System.out.println("Error url inválida");
            e.printStackTrace();
        }
    }
}