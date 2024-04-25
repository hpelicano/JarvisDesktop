package com.fiserv.jarvis.models;

/**
 * @author Pelicano, Hector Roman
 */
public class dbRecord {
    
    private String impleId;      //Id de Implementacion
    private String csmId;        //Id de Modificacion
    private char   suffix;       //Sufijo para versionado y tracking de proyectos
    private String type;         //Proyect - Incidente - mejora
    private String chgId;        //Id de Change
    private String responsables; //Mnemonicos de los involucrados
    private String estado;       //Estado del proyecto: "Produccion","Desarrollo", etc
    private String Origen;       //por ejemplo PR0102023
    private String fechaIni;     //Fecha de inicio del proyecto
    private String fechaFin;     //Fecha de fin del proyecto
    private String fechaProd;    //Fecha de puesta en produccion 
    private String descripcion;  //informar detalle de fuentes modificados
    private String srcModif;     //fuentes modificados
    private String objImple;     //Objetos implementados
    private String subvols;      //Subvolumenes involucrados

    public dbRecord() {
        
    }

    
        
    
    public String getImpleId() {
        return impleId;
    }

    public void setImpleId(String impleId) {
        this.impleId = impleId;
    }

    public String getCsmId() {
        return csmId;
    }

    public void setCsmId(String csmId) {
        this.csmId = csmId;
    }

    public char getSuffix() {
        return suffix;
    }

    public void setSuffix(char suffix) {
        this.suffix = suffix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChgId() {
        return chgId;
    }

    public void setChgId(String chgId) {
        this.chgId = chgId;
    }

    public String getResponsables() {
        return responsables;
    }

    public void setResponsables(String responsables) {
        this.responsables = responsables;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getOrigen() {
        return Origen;
    }

    public void setOrigen(String Origen) {
        this.Origen = Origen;
    }

    public String getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(String fechaIni) {
        this.fechaIni = fechaIni;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getFechaProd() {
        return fechaProd;
    }

    public void setFechaProd(String fechaProd) {
        this.fechaProd = fechaProd;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSrcModif() {
        return srcModif;
    }

    public void setSrcModif(String srcModif) {
        this.srcModif = srcModif;
    }

    public String getObjImple() {
        return objImple;
    }

    public void setObjImple(String objImple) {
        this.objImple = objImple;
    }

    public String getSubvols() {
        return subvols;
    }

    public void setSubvols(String subvols) {
        this.subvols = subvols;
    }

    @Override
    public String toString() {

        return impleId + ";" + 
               csmId   + ";" + 
                suffix + ";" + 
                type   + ";" + 
                chgId  + ";" + 
          responsables + ";" + 
                estado + ";" + 
                Origen + ";" + 
              fechaIni + ";" + 
              fechaFin + ";" + 
             fechaProd + ";" + 
           descripcion + ";" + 
              srcModif + ";" + 
              objImple + ";" + 
               subvols + "@";
    }
    
    
    
}
