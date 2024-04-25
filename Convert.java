package com.fiserv.jarvis.utils;

import com.fiserv.jarvis.models.RespConvert;

/**
 * @author F1W1JF7
 */
public class Convert {

    public static RespConvert DecimalToBinary(int numeroDecimal) {
        
        int[] binario = new int[100];
        int cociente;
        int i = 1;

        cociente = numeroDecimal;

        while (cociente != 0) {
            binario[i] = cociente % 2;
            cociente /= 2;

            ++i;
        }

        RespConvert resulato =new RespConvert();
        resulato.setArray(binario);
        resulato.setI(i);

        return resulato;

    }
     
    public static String DecimalToHexa(int numeroDecimal) {
        int residuo;
        String hexadecimal = "";
        char[] hexadecimales = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                                'A', 'B', 'C', 'D', 'E', 'F'};
        
        while (numeroDecimal > 0) {
            residuo = numeroDecimal % 16;
            hexadecimal = hexadecimales[residuo] + hexadecimal;
            
            numeroDecimal /= 16;
        }
        
        return hexadecimal;
    }

    public static RespConvert DecimalToOctal(int decimal) {
        int octal[] = new int[100];
        int cociente = decimal;
        int i = 1;
        
        while (cociente != 0) {
            octal[i] = cociente % 8;
            
            cociente /= 8;
            
            ++i;
        }
        
        RespConvert resultado = new RespConvert();
        resultado.setArray(octal);
        resultado.setI(i);
        
        return resultado;
    }

    public static long BinaryToDecimal(Long binario) {
        long decimal = 0;
        long residuo;
        int j = 1;
        
        while (binario != 0) {
            residuo = binario % 10;
            decimal += residuo * j;
            
            j *= 2;
            
            binario /= 10;
        }
        
        return decimal;
    }
    
    public static RespConvert BinaryToHexa(int binario) {
        int i = 1;
        int residuo;
        int decimal = 0;
        int[] hexadecimal = new int[100];
        
        while (binario > 0) {
            residuo = binario % 2;
            decimal += residuo * i;
            i *= 2;
            binario /= 10;
        }
        
        i = 0;
        
        while (decimal != 0) {
            hexadecimal[i] = decimal % 16;
            decimal /= 16;
            ++i;
        }
        
        RespConvert resultado = new RespConvert();
        resultado.setArray(hexadecimal);
        resultado.setI(i);
        
        return resultado;
    }
       
    public static RespConvert BinaryToOctal(int binario) {
        int[] octal = new int[100];
        int residuo;
        int decimal = 0;
        int i = 1;
        
        while (binario > 0) {
            residuo = binario % 10;
            decimal += residuo * i;
            
            i *= 2;
            
            binario /= 10;
        }
        
        i = 1;
        int cociente = decimal;
        
        while (cociente > 0) {
            octal[i] = cociente % 8;
            
            cociente /= 8;
            
            i++;
        }
        
        RespConvert resultado = new RespConvert();
        resultado.setArray(octal);
        resultado.setI(i);
        
        return resultado;
    }
    
    public static long OctalToDecimal(long octal) {
        int i = 0;
        long decimal = 0;
        
        while (octal != 0) {
            decimal = (long) (decimal + (octal % 10) * Math.pow(8, i));
            
            octal /= 10;
            
            ++i;
        }
        
        return decimal;
    }
    
    public static long OctalToBinary(long octal) {
        int i = 1;
        long binario = 0;
        int residuo;
        int[] valores_octales = {0, 1, 10, 11, 100, 101, 110, 111};
        
        while(octal != 0) {
            residuo = (int) (octal % 10);
            binario += i * valores_octales[residuo];
            
            octal /= 10;
            
            i *= 1000;
        }
        
        return binario;
    }
    
    public static String OctalTohexa(String octal) {
        int decimal = Integer.parseInt(octal, 8);
        
        return Integer.toHexString(decimal);
    }

    public static int HexaToDecimal(String hexadecimal) {
        final String DIGITOS = "0123456789ABCDEF";
        hexadecimal = hexadecimal.toUpperCase();
        
        int decimal = 0;
        
        for (int i = 0; i < hexadecimal.length(); i++) {
            char caracter = hexadecimal.charAt(i);
            int digito = DIGITOS.indexOf(caracter);
            
            decimal = 16 * decimal + digito;
        }
        
        return decimal;
    }


}

