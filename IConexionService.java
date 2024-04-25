package com.fiserv.jarvis.service;

import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

/**
 * @author F1W1JF7
 */
public interface IConexionService {
    //Metodo de creacion de un nuevo socket de comunicacion
    public Socket createSocket(InetAddress host, Integer port);
    
    //Metodo que nos permite enviar un mensaje al server y obtener la respuesta
    // para procesarla en el BufferedReader
    public List<String> sendMessage(Socket s, String m);
    
}
