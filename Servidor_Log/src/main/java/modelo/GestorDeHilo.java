package modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import com.google.gson.Gson;
import java.net.Socket;
import java.util.ArrayList;

public class GestorDeHilo extends Thread {

    private Socket objSocketCliente;
    private  ArrayList<reporteMensaje> reportes;
    

    public GestorDeHilo(Socket objSocket, ArrayList<reporteMensaje> reportes) {
        this.objSocketCliente = objSocket;
        this.reportes = reportes;
    }

    @Override
    public void run() {
        try {
            Gson gson = new Gson();
            reporteMensaje reporteError;
            System.out.println("id del hilo generado:" + Thread.currentThread().getId());
            System.out.println("Atendiendo hilo de cliente");
            DataInputStream flujoEntrada;
            DataOutputStream flujoSalida;
            String message;
            flujoEntrada = new DataInputStream(objSocketCliente.getInputStream());
            flujoSalida = new DataOutputStream(objSocketCliente.getOutputStream());
            message = flujoEntrada.readUTF();//se bloquea el servidor
            reporteError = gson.fromJson(message, reporteMensaje.class);
            reportes.add(reporteError);
            
            /*
            if (message.equals("caracteristicas")) {
                //message = InformacionComputador.atenderPeticion();
                flujoSalida.writeUTF(message);
            }
            //message = InformacionComputador.atenderPeticion();                  
            if (message.equals("caracteristicas")) {
                flujoSalida.writeUTF(message);
            }
            */
            
            System.out.println("Error: "+ reporteError.getMensaje()+ " Fecha: "+reporteError.getDate());
            
            objSocketCliente.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
