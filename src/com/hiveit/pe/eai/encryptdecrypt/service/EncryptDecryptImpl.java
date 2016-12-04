package com.hiveit.pe.eai.encryptdecrypt.service;

import javax.swing.JOptionPane;

import com.hiveit.pe.eai.encryptdecrypt.bean.EncryptDecryptRequest;
import com.hiveit.pe.eai.encryptdecrypt.bean.EncryptDecryptResponse;
import com.hiveit.pe.eai.encryptdecrypt.util.PropertiesExterno;
import com.hiveit.pe.eai.encryptdecrypt.util.Utilitario;

public class EncryptDecryptImpl implements EncryptDecrypt{	
	
	PropertiesExterno propertiesExterno = new PropertiesExterno();
	
	@Override
	public EncryptDecryptResponse encryptDecrypt(EncryptDecryptRequest request) {
		//ENCRIPTAR		
		EncryptDecryptResponse response = null;	
		
		try {
			response = new EncryptDecryptResponse();
			String typeOpc = request.getTypeTest();		
			request.setCodEncrypt(Utilitario.validateNull(typeOpc));
			
			if(!propertiesExterno.getOpcEncryt().isEmpty() && typeOpc.equals(propertiesExterno.getOpcEncryt())){
				System.out.println("=====================================================================================");
				System.out.println("[---------------- Inicio de encriptamiento ----------------]");
				System.out.println("=====================================================================================\n");
				String input = request.getCodEncrypt();		
				request.setCodEncrypt(Utilitario.validateNull(input));
				if(!input.isEmpty()){
					request.setTypeTest(input);
					response.setCodEncrypted(Utilitario.encriptar(request.getCodEncrypt(),request.getKey()));	
					System.out.println("La llave para desencriptar es: "+request.getKey());
					System.out.println("El codigo encriptado es: "+response.getCodEncrypted());						
				}else{
					JOptionPane.showMessageDialog(null, "Error en el valor de entrada encrypt");
				}
			}else if(!propertiesExterno.getOpcDecrypt().isEmpty() && typeOpc.equals(propertiesExterno.getOpcDecrypt())){
	 	  	  	System.out.println("=====================================================================================");
	 	  	  	System.out.println("[---------------- Inicio de desencriptamiento ----------------]");
	 	  	  	System.out.println("=====================================================================================\n");
				String input = request.getCodDecrypt();		
				request.setCodDecrypt(Utilitario.validateNull(input));
				if(!input.isEmpty()){
					request.setTypeTest(input);
					response.setCodDecrypted(Utilitario.desencriptar(request.getCodDecrypt(),request.getKey()));					
					System.out.println("La llave para desencriptar es: "+request.getKey());
					System.out.println("El codigo encriptado es: "+response.getCodDecrypted());
				}else{				
					JOptionPane.showMessageDialog(null, "Error en el valor de entrada decrypt");
				}				
			}else{
				JOptionPane.showMessageDialog(null,"Error en el tipo de operacion");
			}	
		}catch (Exception e){
			JOptionPane.showMessageDialog(null,"Error!" +e);
		}
		return response;
	}		
}
