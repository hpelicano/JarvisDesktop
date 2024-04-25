package com.fiserv.jarvis.utils;

import java.io.File;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * @author F1W1JF7
 */
public class BuildTree {
    
    private DefaultMutableTreeNode root = null;
    private DefaultTreeModel modelo = null;
    private File fichero;
    
    public BuildTree(File fichero) {
        this.fichero = fichero;
    }
    
    public DefaultTreeModel Build(){
        root =new DefaultMutableTreeNode (fichero.getName());
        modelo =new DefaultTreeModel(root);
        
        return getNodesAndLeafs( root, fichero );
        
    }

        
    private DefaultTreeModel getNodesAndLeafs(DefaultMutableTreeNode nodo, File carpeta){
        File[] archivos = carpeta.listFiles();
        if (archivos != null){
            int contador = 0;
            for(File f:archivos){
                DefaultMutableTreeNode hijo =new DefaultMutableTreeNode(f.getName());
                modelo.insertNodeInto(hijo, nodo, contador);
                contador++;
                if(f.isDirectory()){
                    getNodesAndLeafs(hijo, f);
                }
            }
        }else{
            //nada
        }
        
        return modelo;
        
    }
    
}
