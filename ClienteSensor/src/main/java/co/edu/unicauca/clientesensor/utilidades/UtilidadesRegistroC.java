package co.edu.unicauca.clientesensor.utilidades;

import java.rmi.Naming;
import java.rmi.Remote;

import co.edu.unicauca.servidor.controladores.GestionSensoresInt;

public class UtilidadesRegistroC {
    public static GestionSensoresInt construirObjetoRemoto(int numPuertoRMIRegistry, String direccionIpRMIRegistry) {
        GestionSensoresInt objRemoto = null;
        try {
            do {
                objRemoto = (GestionSensoresInt) UtilidadesRegistroC.obtenerObjRemoto(numPuertoRMIRegistry,
                direccionIpRMIRegistry, "objRemoteSensor");
                if (objRemoto != null)
                    return objRemoto;
                UtilidadesConsola.esperaReintentar();
            } while(objRemoto == null);
        } catch (Exception e) {
            System.out.println("No se pudo realizar la conexion...");
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Remote obtenerObjRemoto(int puerto, String dirIP, String nameObjReg) {
        String URLRegistro;
        URLRegistro = "rmi://" + dirIP + ":" + puerto + "/" + nameObjReg;
        try {
            return Naming.lookup(URLRegistro);
        } catch (Exception e) {
            System.out.println("Excepcion en obtencion del objeto remoto" + e);
            return null;
        }
    }
}