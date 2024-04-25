package com.fiserv.jarvis.service;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author F1W1JF7
 */
public class ConexionSSH {
    
    public ConexionSSH(){

    }
    
    public Session ConnectSSH(String user, String pass, String host, int port){
        
        try {
            JSch jsch =new JSch();
            Properties p =new Properties();
            
            p.setProperty("StrictHostKeyChecking","no");
            
            System.out.println("User: " + user + " - Pass: " + pass + " - Host: " + host + " Port: " + port);
            
            
            Session session = jsch.getSession(user, host, port);
            session.setConfig(p);
            session.setPassword(pass);
            session.connect();
            
            return session;
            
        } catch (JSchException ex) {
            Logger.getLogger(ConexionSSH.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<String> sendMessageSSH(Session session, String command){
        
        try{
            List<String> buffer =new ArrayList<>();
            
            ChannelExec channel = (ChannelExec) session.openChannel("exec");
            InputStream in = channel.getInputStream();
            
            // ejecutamos comandos
            channel.setCommand(command);
            channel.connect();
            
            
            //obtenemos la respuesta
            BufferedReader reader =new BufferedReader(new InputStreamReader(in));
            
            String linea;
            
            while( (linea = reader.readLine()) != null ){
                buffer.add(linea);
                System.out.println("linea recibida: [ " + linea + " ]");
            }
            
            //cerramos los canales.
            channel.disconnect();
            session.disconnect();
            
            System.out.println("Se cerraron las conexiones SSH.");
            
            return buffer;
            
            //System.out.println("-------- Cerrando conexion al Tandem --------");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"[ERROR] Verificar conexión con el Host.");
            
            return null;
        }

        
        
        
    }
    
}
