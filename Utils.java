package com.fiserv.jarvis.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author F1W1JF7
 */
public class Utils {
    
    public static void initDirectoryJarvis(){
        File fileDirectory = null;
        
        List<String> listaFolders =new ArrayList<>();
        listaFolders.add("C:/Jarvis");
        listaFolders.add("C:/Jarvis/Config");
        listaFolders.add("C:/Jarvis/Enform");
        listaFolders.add("C:/Jarvis/Audit");
        listaFolders.add("C:/Jarvis/Libs");
        listaFolders.add("C:/Jarvis/Libs/ddls");
        listaFolders.add("C:/Jarvis/Libs/tkns");
        listaFolders.add("C:/Jarvis/Test");
        listaFolders.add("C:/Jarvis/Docs");
        
        for(int i=0; i<listaFolders.size(); i++){
            fileDirectory =new File(listaFolders.get(i));
            if (!fileDirectory.exists()) {
                //Creamos el Directorio
                fileDirectory.mkdir();
            }
        }
        
    }
        
    public static boolean checkFileOrDirectory(String file){
        File fileDirectory =new File(file);

        return fileDirectory.exists();
    }
    
    
    public static List<String> readFile(String filename) {
        
        List<String> lst =new ArrayList<>();
        try{
            File myObj = new File( filename);
            //File myObj = new File( "C:\\Jarvis\\Libs\\ddl\\CAF.txt");
            Scanner myReader = new Scanner(myObj);
        
            while (myReader.hasNextLine()) {
              lst.add(myReader.nextLine());
            }
            
            myReader.close();
            
        }catch(FileNotFoundException e){
            System.out.println("Error al leer el archivo.");
        }
        
        return lst;
        
    }
    
    public static boolean saveFile(String file, String text){
        try(FileWriter myWriter = new FileWriter(file)) {
            myWriter.write(text);
            return true;
        } catch (IOException e) {
            System.out.println("Error en la escritura del archivo.");
        }
        
        return false;
    }
    
    public static int createFile(String file){
        
        File myFile = new File(file);
        try {
            if (myFile.createNewFile()) {
                return 1;
            } else {
                return 0;
            }
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 2;
    }
        
    public static String getProperty(String file, String property){
        
        try(InputStream fis = new FileInputStream(file)) {
            Properties prop = new Properties();    
            prop.load(fis);
            
            String valorProp = prop.getProperty(property);
            
            return valorProp;
        
        }catch(Exception e) {
            System.out.println("Unable to find the specified properties file");
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static File[] getFilesFromDirectory(String directoryPath){

        try{
            File directory = new File(directoryPath); 

            File[] files = directory.listFiles(); 

            if (files != null) { 
                return files;
            }else{
                JOptionPane.showMessageDialog(null,"No se han encontrado archivos en el Directorio." );
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error en el Directorio. \n Verificar Property File." );
        }

        return null;

    }
    
    
    
    
    
}
