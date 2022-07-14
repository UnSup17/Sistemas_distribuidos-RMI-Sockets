/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author David Escobar
 */
public class UtilidadesRegistroS {
    public static void arrancarNS(int numPuertoNS) throws RemoteException {
        try {
            Registry registro = LocateRegistry.getRegistry(numPuertoNS);
            String[] vector = registro.list();
            System.out.println("Nombres de objetos remotos registrados ");
            for (String IDObjetoRemoto : vector) {
                System.out.println("Nombre : " + IDObjetoRemoto);
            }
            System.out.println("El rmiRegistry se ha obtenido y se encuentra escuchando en el puerto: " + numPuertoNS);
        } catch (RemoteException e) {
            System.out.println("El rmiRegistry no se localizó en el puerto: " + numPuertoNS);
            LocateRegistry.createRegistry(numPuertoNS);
            System.out.println("El registro se ha creado en el puerto: " + numPuertoNS);
        }
    }

    public static void RegistrarObjetoRemoto(Remote objetoRemoto, String dirIPNS, int numPuertoNS,
            String identificadorObjetoRemoto) {
        String UrlRegistro = "rmi://" + dirIPNS + ":" + numPuertoNS + "/" + identificadorObjetoRemoto;
        try {
            Naming.rebind(UrlRegistro, objetoRemoto);
            System.out.println("Se realizó el registro del objeto remoto en el ns ubicado en la dirección: " + dirIPNS
                    + " y " + "puerto" + numPuertoNS);
        } catch (RemoteException e) {
            System.out.println("Error en el registro del objeto remoto");
        } catch (MalformedURLException e) {
            System.out.println("Error, url inválida");
        }
    }
}