package com.sistemabancario;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

    public static void main(String[] args) {
        //agregar hilo para detector de fallas, sería una clase nueva por agregar,
        // la clase debería ser un thread, debe tener una variable que indique cual 
        // es el servidor que esta funcionando
        try  {
            ControlFallos cf = new ControlFallos("1","1");
            cf.start();
            ServerSocket server = new ServerSocket(25000);
            while (true) { 
                System.out.println("Esperando conexiones");
                 
                Socket s = server.accept();
                 // Crear los streams
                DataInputStream in = new DataInputStream(s.getInputStream());
                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                out.writeUTF("Hola"); 
            }
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
