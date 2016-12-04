package com.hiveit.pe.eai.encryptdecrypt.bean;

public class EncryptDecryptRequest {
	
	private String codEncrypt;
	private String codDecrypt;
	private byte[] key;
	private String typeTest;
	
	public String getCodEncrypt() {
		return codEncrypt;
	}
	public void setCodEncrypt(String codEncrypt) {
		this.codEncrypt = codEncrypt;
	}
	public String getCodDecrypt() {
		return codDecrypt;
	}
	public void setCodDecrypt(String codDecrypt) {
		this.codDecrypt = codDecrypt;
	}
	public byte[] getKey() {
		return key;
	}
	public void setKey(byte[] key) {
		this.key = key;
	}
	public String getTypeTest() {
		return typeTest;
	}
	public void setTypeTest(String typeTest) {
		this.typeTest = typeTest;
	}	
}
