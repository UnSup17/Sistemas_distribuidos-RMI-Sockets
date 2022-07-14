/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.clientesensores;

import dto.DatosSensorDTO;
import java.rmi.RemoteException;
import sop_gestionSensores.GestionSensoresInt;
import utilidades.UtilidadesRegistroC;

/**
 *
 * @author David Escobar
 */
public class ClienteSensores {
    
    private static GestionSensoresInt objRemoto;

    public static void main(String[] args) {
        DatosSensorDTO objIndicadores = new DatosSensorDTO(10, 10, 10, 10, 10);
        int id = 0;

        try {
            String direccionIpRMIRegistry="localhost";
            int puerto = 8086;
            System.out.println("Iniciando el cliente Sensor en la Direccion: "+direccionIpRMIRegistry+" Puerto: "+puerto);

            objRemoto = (GestionSensoresInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry,puerto,"objRemoteSensor");
            
            boolean valor = objRemoto.enviarDatosSensor(1, objIndicadores);
            
            if (valor == false) {
                System.out.println("Si llego ");
            }else{
                System.out.println("No llego ");
            }
            
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("La operacion no se pudo completar, intente nuevamente...");
        }
    }
}
