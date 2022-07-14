package utilidades;

// import java.net.MalformedURLException;
// import java.rmi.ConnectException;
// import java.rmi.Naming;
// import java.rmi.NotBoundException;
// import java.rmi.Remote;
// import java.rmi.RemoteException;

public class UtilidadesRegistroC {
    // public static GestionNotificacionesInt construirObjetoRemoto(String[] args) {
    //     GestionNotificacionesInt objRemoto = null;
    //     do {
    //         String direccionIpRMIRegistry;
    //             int numPuertoRMIRegistry;
    //             if (args.length < 1){
    //                 System.out.println("Cual es el la direccion ip donde se encuentra  el rmiregistry ");
    //                 direccionIpRMIRegistry = UtilidadesConsola.leerCadena();
    //             }else {
    //                 direccionIpRMIRegistry = args[0];
    //             }
    //             if (args.length < 2) {
    //                 System.out.println("Cual es el numero de puerto por el cual escucha el rmiregistry ");
    //                 numPuertoRMIRegistry = UtilidadesConsola.leerEntero(); 
    //             } else {
    //                 numPuertoRMIRegistry = Integer.parseInt(args[1]);
    //             }
    //         objRemoto = (GestionNotificacionesInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry,numPuertoRMIRegistry, "objetoRemotoNotificacion");
    //     } while (objRemoto == null);
    //     return objRemoto;
    // }

    // public static Remote obtenerObjRemoto(String dirIPNS,int puertoNS, String identificadorObjetoRemoto) {
    //     String URLRegistro = "rmi://" + dirIPNS + ":" + puertoNS + "/"+identificadorObjetoRemoto;
    //     try {
    //         return Naming.lookup(URLRegistro);
    //     }
    //     catch (NotBoundException e) {
    //         System.out.println("Error, objeto remoto no localizado");
    //     }
    //     catch (MalformedURLException e) {
    //         System.out.println("Error, url inválida");
    //     }
    //     catch (ConnectException e) {
    //         System.out.println("Coneccion rechazada, corrija datos");
    //     }
    //     catch (RemoteException e) {
    //         System.out.println("Excepcion en obtencion del objeto remoto"+ e);
    //     }
    //     return null;
    // }
}