package servidor;

import java.rmi.RemoteException;

import sop_rmi_gestionSensores.GestionSensoresImpl;
import utilidades.UtilidadesConsola;
import utilidades.UtilidadesRegistroS;

public class ServidorAlertas {
    public static void main(String args[]) throws RemoteException {
        try {
            String direccionIpRMIRegistry="localhost";
            int numPuertoRMIRegistry = 8088;
            System.out.println("Iniciando servidor dir: "+direccionIpRMIRegistry+ " Puerto: " +numPuertoRMIRegistry);
            
            GestionSensoresImpl objRemoto =  new GestionSensoresImpl();//se leasigna el puerto de escucha del objeto remoto
            UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto, direccionIpRMIRegistry, numPuertoRMIRegistry, "objetoRemotoUsuarios");
        } catch (Exception e) {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" +  e.getMessage());
        }
    }
}
