/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import co.edu.unicauca.servidor.dto;

/**
 *
 * @author David Escobar
 */
public class reporteMensaje {
    
    private DatosSensorDTO datos;
    private String date;

    public reporteMensaje(DatosSensorDTO datos, String date) {
        this.datos = datos;
        this.date = date;
    }

    public DatosSensorDTO getMensaje() {
        return datos;
    }

    public void setMensaje(DatosSensorDTO datos) {
        this.datos = datos;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    
}
