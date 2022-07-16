package co.edu.unicauca.clientesensor.servicios;

import java.rmi.RemoteException;

import co.edu.unicauca.clientesensor.utilidades.UtilidadesConsola;
import co.edu.unicauca.clientesensor.utilidades.UtilidadesRegistroC;
import co.edu.unicauca.servidor.controladores.GestionSensoresInt;
import co.edu.unicauca.servidor.dto.DatosSensorDTO;

public class ClienteDeObjetos {
    private static GestionSensoresInt objRemoto;
    private static int numHabitacion;

    public static void main(String[] args) throws RemoteException {
        objRemoto = UtilidadesRegistroC.construirObjetoRemoto(8088, "localhost");
        registrarSensor();
        enviarDatosSensor();
    }

    public static void registrarSensor() throws RemoteException {
        boolean retorno = false;
        do {
            System.out.println("Ingrese el numero de la habitacion del sensor:");
            numHabitacion = UtilidadesConsola.leerEntero();
            retorno = objRemoto.registrarSensor(numHabitacion);
            if (!retorno)
                System.out.println("Habitacion ya registrada, intente otra habitacion");
        } while (retorno == false);
    }

    public static void enviarDatosSensor() throws RemoteException {
        while(true) {
            System.out.println("Enviar datos del sensor? [1:Si]");
            if (UtilidadesConsola.leerEntero() == 1) {
                DatosSensorDTO objDatosSensor = llenarDatos();
                objRemoto.enviarDatosSensor(numHabitacion, objDatosSensor);
            }
        }
    }
    private static DatosSensorDTO llenarDatos() {
        DatosSensorDTO datos = new DatosSensorDTO();
        System.out.println("Frecuencia cardiaca:");
        datos.setFrecuenciaCardiaca(UtilidadesConsola.leerEntero());
        System.out.println("Frecuencia respiratoria:");
        datos.setFrecuenciaRespiratoria(UtilidadesConsola.leerEntero());
        System.out.println("Saturacion de oxigeno:");
        datos.setOxigeno(UtilidadesConsola.leerEntero());
        System.out.println("Temperatura:");
        datos.setTemperatura(UtilidadesConsola.leerDouble());
        System.out.println("Presion diastolica:");
        datos.setPresionDiastolica(UtilidadesConsola.leerEntero());
        System.out.println("Presion sistolica:");
        datos.setPresionSistolica(UtilidadesConsola.leerEntero());
        return datos;
    }
}