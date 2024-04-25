package com.fiserv.jarvis.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author F1W1JF7
 */
public class ConexionServiceImpl implements IConexionService {

    @Override
    public Socket createSocket(InetAddress host, Integer port) {
        Socket ns;
        try {

            ns = new Socket(host, port);
            System.out.println("Just connected to " + ns.getRemoteSocketAddress()); 
            return ns;

        } catch (IOException ex) {
            Logger.getLogger(ConexionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public List<String> sendMessage(Socket s, String m) {
        
        PrintWriter toServer = null;
        BufferedReader fromServer = null;
        String line;
        List<String> buffer = null;
        
        try {
            toServer = new PrintWriter(s.getOutputStream(),true);
            fromServer = new BufferedReader(new InputStreamReader(s.getInputStream()));
            
            //Envio al server el mensaje
            toServer.println( m );
            
            buffer =new ArrayList<>();
            
            // Evaluar guardar en un baffer todo lo que venga del server
            // y luego retornarlo a quien llamo a la funcion
            while((line =  fromServer.readLine()) != null){
                buffer.add(line);
                System.out.println(line);
            }
            
            
            return buffer;
            
        } catch (IOException ex) {
            Logger.getLogger(ConexionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);	
        } finally {
            try {
                if(toServer != null){
                    toServer.close();
                    System.out.println("Se cerro el fd de 'toServer'");
                }
                if(fromServer != null){
                    fromServer.close();
                    System.out.println("Se cerro el fd de 'fromServer'");
                }
                if(s != null){
                    s.close();
                    System.out.println("Se cerro el fd del 'Socket'");
                }
            } catch (IOException ex) {
                Logger.getLogger(ConexionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
        
        
    }

      
    
}
