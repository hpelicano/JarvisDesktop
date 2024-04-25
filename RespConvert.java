package com.fiserv.jarvis.models;

/**
 * @author F1W1JF7
 */

// Clase para la utilizacion de las Convert
public class RespConvert {
    private int[] array;
    private int i;

    public RespConvert() {
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] binario) {
        this.array = binario;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "{" + "Array=" + array + ", i=" + i + '}';
    }
    
    
    
}
