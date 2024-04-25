package com.fiserv.jarvis.controller;

import com.fiserv.jarvis.forms.frmDataBase;
import com.fiserv.jarvis.models.dbRecord;
import com.fiserv.jarvis.service.IConexionService;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author F1W1JF7
 */
public class DataBaseController {
    //Propiedad de la clase para inyectar dependencias.
    private final IConexionService connService;
    
    
    
    //Inyeccion de dependencia por medio del constructor
    public DataBaseController(final IConexionService connService){
        this.connService = connService;
    }
   
    
    //-------------------------------------------------------------------------
    // A partir de Aca registramos todos los metodos del controlador
    //-------------------------------------------------------------------------
    
    //----------------------
    // Database CRUD
    //----------------------
    public void altaRegistro(frmDataBase frmDB){
        
    }
    
    public List<String> getAllRecords() throws UnknownHostException{
        String request ="/DDBB/GETALLRECORDS";
        List<String> recordBuffer =new ArrayList<>();
        Socket socket =new Socket();
        int serverPort = 7777;
		
        //byte IPAddress[] = { 10, 2, 50, (byte)253 };
        //InetAddress host = InetAddress.getByAddress(IPAddress);
        
        InetAddress host = InetAddress.getByName("NonStopAP2050242.1dc.com"); 
        System.out.println(host.getHostAddress());
        
        socket = connService.createSocket(host, serverPort);
        
        recordBuffer = connService.sendMessage(socket, request);
        
        
        return recordBuffer;
    }
    
    
    
    public List<String> createNewRecord(dbRecord record)throws UnknownHostException{
        String request ="/DDBB/ADDNEWRECORD==";
        List<String> recordBuffer =new ArrayList<>();
        
        Socket socket =new Socket();
        int serverPort = 7777;
        
        InetAddress host = InetAddress.getByName("NonStopAP2050242.1dc.com"); 
        System.out.println(host.getHostAddress());
        
        socket = connService.createSocket(host, serverPort);
        
        recordBuffer = connService.sendMessage(socket, request + record.toString());
        
        return recordBuffer;
    }
    
    public List<String> updtRecord(dbRecord record)throws UnknownHostException{
        String request ="/DDBB/UPDTRECORD==";
        List<String> recordBuffer =new ArrayList<>();
        
        Socket socket =new Socket();
        int serverPort = 7777;
        
        InetAddress host = InetAddress.getByName("NonStopAP2050242.1dc.com"); 
        System.out.println(host.getHostAddress());
        
        socket = connService.createSocket(host, serverPort);
        
        recordBuffer = connService.sendMessage(socket, request + record.toString());
        
        return recordBuffer;
    }
    
    public List<String> deleteRecord(dbRecord record)throws UnknownHostException{
        String request ="/DDBB/DELTRECORD==";
        List<String> recordBuffer =new ArrayList<>();
        
        Socket socket =new Socket();
        int serverPort = 7777;
        
        InetAddress host = InetAddress.getByName("NonStopAP2050242.1dc.com"); 
        System.out.println(host.getHostAddress());
        
        socket = connService.createSocket(host, serverPort);
        
        recordBuffer = connService.sendMessage(socket, request + record.toString());
        
        return recordBuffer;
    }
    
}
