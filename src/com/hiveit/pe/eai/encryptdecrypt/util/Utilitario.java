package com.hiveit.pe.eai.encryptdecrypt.util;

import java.util.Random;

import javax.crypto.spec.DESedeKeySpec;

public class Utilitario {
	
	public static byte[] llave(){
		byte[] key = null;
		
		try {
			//Llave autogenerada (DINAMICA) de tipo DESedeKeySpec
			DESedeKeySpec newKey = TripleDESEncryption.generateKey();
			//llave autogenerada parsing to byte[]
			key = newKey.getKey();
		} catch (Exception e) {
			System.out.println("No se pudo generar la llave"+e);
		}
		return key;
	}
		
	public static String encriptar(String codigoEncriptar,byte [] llaveDescencriptar){
			
		String codigoEncriptado = null;
		
		try {
			
			DESedeKeySpec keySpe = new DESedeKeySpec(llaveDescencriptar); 
     	  	codigoEncriptado = TripleDESEncryption.encrypt( codigoEncriptar, keySpe );
		}
		catch (Exception e) {
			System.out.println("No se pudo encriptar"+e);
		}     
		return codigoEncriptado;
}
   
	public static String desencriptar(String CodigoEncriptado, byte [] llaveDescencriptar){
	  	   
	  	   String codigoDesencriptado = null;
	  	   
	   	  try {
	   		  	   	  	  
	       	  DESedeKeySpec keySpe = new DESedeKeySpec(llaveDescencriptar); 
	       	  codigoDesencriptado = TripleDESEncryption.decrypt(CodigoEncriptado, keySpe);
	       	     	  
	   	  }catch (Exception e) {   		  
	   		  System.out.println("No se pudo desencriptar"+e);	   		
	   	  }	     
	   	  return codigoDesencriptado;
	}	

  public static int aleatorio(){		
  		System.out.println("[---------------- Inicio Generacion numero de 6 digitos   ----------------]");		
		int numRandom = 0;	
		Random rnd = new Random(); 
	    try {
	    	
	    	rnd.setSeed(System.currentTimeMillis()); 
	    	numRandom = 100000 + rnd.nextInt(900000);
			System.out.println("CODIGO AUTOGENERADO.................."+numRandom+"......\n");
	        
		}catch (Exception e) {
			System.out.println("no se pudo encriptar"+e);
		}	    	
	    System.out.println("[---------------- Fin Generacion numero de 6 digitos   ----------------]");			    
	    return numRandom;	    
	}	
  
  public static boolean isNumeric(String cadena){
  	try {
  		Integer.parseInt(cadena);
  		return true;
  	} catch (NumberFormatException nfe){
  		return false;
  	}
  }
  
  public static String validateNull(Object obj) {
	  return (obj == null) ? Constantes.VACIO : obj.toString().trim();		    
  }
    
}
