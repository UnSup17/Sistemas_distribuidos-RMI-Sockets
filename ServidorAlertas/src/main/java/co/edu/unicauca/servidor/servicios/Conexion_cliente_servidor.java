package co.edu.unicauca.servidor.servicios;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import modelo.reporteMensaje;

public class Conexion_cliente_servidor {
    private String dirIpServidor = "";
    private int puertoServidor;
    private DataInputStream flujoEntrada;
    private DataOutputStream flujoSalida;
    private Socket socket;

    public void ServerConnection(String dirIP, int puerto){
        try {
            setDirIpServidor(dirIP);
            setPuertoServidor(puerto);
            setSocket(new Socket(dirIP, puerto));
            setFlujoEntrada(new DataInputStream(getSocket().getInputStream()));
            setFlujoSalida(new DataOutputStream(getSocket().getOutputStream()));
        } catch (IOException excep) {
            excep.printStackTrace();
        }
    }
    
    public boolean enviar_mensaje(reporteMensaje mensaje){
        Gson gson = new Gson();
        try {
            String json = gson.toJson(mensaje);
            flujoSalida.writeUTF(json);
            getSocket().close();
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrio un error al enviar el reporte");
            return false;
        }
    }

    public String getDirIpServidor() {
        return dirIpServidor;
    }

    public void setDirIpServidor(String dirIpServidor) {
        this.dirIpServidor = dirIpServidor;
    }

    public int getPuertoServidor() {
        return puertoServidor;
    }

    public void setPuertoServidor(int puertoServidor) {
        this.puertoServidor = puertoServidor;
    }

    public DataInputStream getFlujoEntrada() {
        return flujoEntrada;
    }

    public void setFlujoEntrada(DataInputStream flujoEntrada) {
        this.flujoEntrada = flujoEntrada;
    }

    public DataOutputStream getFlujoSalida() {
        return flujoSalida;
    }

    public void setFlujoSalida(DataOutputStream flujoSalida) {
        this.flujoSalida = flujoSalida;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

}
