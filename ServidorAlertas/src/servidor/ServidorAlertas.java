package servidor;

import java.rmi.RemoteException;

import sop_rmi_gestionSensores.GestionSensoresImpl;
import utilidades.UtilidadesConsola;
import utilidades.UtilidadesRegistroS;

public class ServidorAlertas {
    public static void main(String args[]) throws RemoteException {
        try {
            String direccionIpRMIRegistry;
            int numPuertoRMIRegistry;
            if (args.length < 1){
                System.out.println("Cual es el la direccion ip donde se encuentra  el rmiregistry ");
                direccionIpRMIRegistry = UtilidadesConsola.leerCadena();
            }else {
                direccionIpRMIRegistry = args[0];
            }
            if (args.length < 2) {
                System.out.println("Cual es el numero de puerto por el cual escucha el rmiregistry ");
                numPuertoRMIRegistry = UtilidadesConsola.leerEntero(); 
            } else {
                numPuertoRMIRegistry = Integer.parseInt(args[1]);
            }
            
            GestionSensoresImpl objRemoto =  new GestionSensoresImpl();//se leasigna el puerto de escucha del objeto remoto
            UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto, direccionIpRMIRegistry, numPuertoRMIRegistry, "objetoRemotoUsuarios");
        } catch (Exception e) {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" +  e.getMessage());
        }
    }
}
