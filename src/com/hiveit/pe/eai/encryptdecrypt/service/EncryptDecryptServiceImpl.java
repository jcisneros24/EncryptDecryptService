package com.hiveit.pe.eai.encryptdecrypt.service;

import com.hiveit.pe.eai.encryptdecrypt.bean.EncryptDecryptRequest;
import com.hiveit.pe.eai.encryptdecrypt.bean.EncryptDecryptResponse;
import com.hiveit.pe.eai.encryptdecrypt.util.PropertiesExterno;
import com.hiveit.pe.eai.encryptdecrypt.util.Utilitario;

public class EncryptDecryptServiceImpl implements EncryptDecryptService{	
	
	PropertiesExterno propertiesExterno = new PropertiesExterno();
	
	@Override
	public EncryptDecryptResponse encryptDecrypt(EncryptDecryptRequest request) {
	
		EncryptDecryptResponse response = null;	
		
		try {
			response = new EncryptDecryptResponse();
			byte[] key = Utilitario.llave();		
			
			if(!propertiesExterno.getOpcEncryt().isEmpty() && propertiesExterno.getOpcEncryt().equals(request.getTypeOpc())){
				String codEncrypt = request.getCodEncrypt();	

				if(!codEncrypt.isEmpty() && codEncrypt != null){

					response.setCodEncrypted(Utilitario.encriptar(codEncrypt,key));	
					response.setCodRpta("0");
					response.setMsgRpta("Operacion exitosa");
					
				}else{
					response.setCodRpta("1");
					response.setMsgRpta("Error: no se pudo encriptar");
				}
			}else if(!propertiesExterno.getOpcDecrypt().isEmpty() && propertiesExterno.getOpcDecrypt().equals(request.getTypeOpc())){
				String codDecrypt = request.getCodDecrypt();		
				key = request.getKey();
				
				if(!codDecrypt.isEmpty() && codDecrypt != null){
					
					response.setCodDecrypted(Utilitario.desencriptar(codDecrypt,key));					
					response.setCodRpta("0");
					response.setMsgRpta("Operacion exitosa");
					
				}else{				
					response.setCodRpta("2");
					response.setMsgRpta("Error: No se pudo desencriptar");
				}				
			}else{
				response.setCodRpta("3");
				response.setMsgRpta("Error: tipo de operacion no valida");
			}	
		}catch (Exception e){
			response.setCodRpta("4");
			response.setMsgRpta("Error: "+e);
		}
		return response;
	}		
}
