/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import java.rmi.RemoteException;
import sop_gestionSensores.GestionSensoresImpl;
import utilidades.UtilidadesRegistroS;

/**
 *
 * @author David Escobar
 */

public class ServidorAlertas {
    public static void main(String args[]) throws RemoteException {
        try {
            String direccionIpRMIRegistry="localhost";
            int numPuertoRMIRegistry = 8086;

            System.out.println("Iniciando servidor dir: "+direccionIpRMIRegistry+ " Puerto: " +numPuertoRMIRegistry);
            
            GestionSensoresImpl objRemoto =  new GestionSensoresImpl();//se leasigna el puerto de escucha del objeto remoto
            
            UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto, direccionIpRMIRegistry, numPuertoRMIRegistry, "objRemoteSensor");
            
        } catch (Exception e) {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" +  e.getMessage());
        }
    }
}
