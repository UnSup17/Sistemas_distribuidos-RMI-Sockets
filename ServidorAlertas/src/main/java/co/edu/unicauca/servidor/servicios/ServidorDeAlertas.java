package co.edu.unicauca.servidor.servicios;

import co.edu.unicauca.servidor.utilidades.UtilidadesRegistroS;
import java.rmi.RemoteException;

public class ServidorDeAlertas {
    public static void main(String args[]) throws RemoteException {
        UtilidadesRegistroS.registrarObjNotificacion();
        UtilidadesRegistroS.registrarObjSensor();
    }
}
