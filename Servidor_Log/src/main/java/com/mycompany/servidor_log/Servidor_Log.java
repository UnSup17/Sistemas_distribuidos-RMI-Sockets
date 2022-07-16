/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.servidor_log;

import modelo.PlantillaServidor;
import modelo.ServidorConcurrente;

/**
 *
 * @author David Escobar
 */
public class Servidor_Log {

    public static void main(String[] args) {

        int puerto = 5000;
        System.out.println("Iniciando servidor de LOGS");
        System.out.println("Servidor arrancando en el puerto " + puerto);
        PlantillaServidor objServidor = new ServidorConcurrente();
        objServidor.inicializarServidor(puerto);
        objServidor.ejecutarServidor();

    }
}
