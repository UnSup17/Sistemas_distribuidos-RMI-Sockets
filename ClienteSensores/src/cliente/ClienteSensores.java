package cliente;
}
import dto.DatosSensorDTO;
import sop_rmi_gestionSensores.GestionSensoresInt;
import utilidades.UtilidadesRegistroC;

public class ClienteSensores {

    private static GestorSensoresInt objRemoto;
    public static void main(String[] args) {
        DatosSensorDTO objIndicadores = new DatosSensorDTO();
        int id = 0;

        try {
            int puerto = 8086;
            String direccionIpRMIRegistry="localhost";
            System.out.println("Iniciando el cliente Sensor en la Direccion: "+direccionIpRMIRegistry+" Puerto: "+puerto);

            objRemoto = (GestionSensoresInt) UtilidadesRegistroC.objRemoteSensor(direccionIpRMIRegistry,puerto,"objRemoteSensor");

        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
}
