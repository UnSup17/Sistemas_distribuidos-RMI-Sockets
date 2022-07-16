/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author David Escobar
 */
public class ServidorConcurrente extends PlantillaServidor{

    
    private ArrayList<reporteMensaje> reportes;
    
    public ServidorConcurrente() {
        this.reportes = new ArrayList<reporteMensaje>();
    }


    @Override
    public void atenderPeticiones() {
        try {            
            while (true) {
                System.out.println("id del hilo principal:"+Thread.currentThread().getId());
                this.objsocket=objservidor.accept();
                System.out.println("Cliente conectado");
                new GestorDeHilo(this.objsocket,reportes).start();
            }
        } catch (Exception excep) {
            excep.printStackTrace();
        }
    }
    
    public void agregarReporte(reporteMensaje reporte){
        this.reportes.add(reporte);
    }
    
}
