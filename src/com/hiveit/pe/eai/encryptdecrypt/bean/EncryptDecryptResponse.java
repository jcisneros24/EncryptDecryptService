package com.hiveit.pe.eai.encryptdecrypt.bean;

public class EncryptDecryptResponse {
	
	private String codEncrypted;
	private String codDecrypted;
	private byte[] key;
	
	public String getCodEncrypted() {
		return codEncrypted;
	}
	public void setCodEncrypted(String codEncrypted) {
		this.codEncrypted = codEncrypted;
	}
	public String getCodDecrypted() {
		return codDecrypted;
	}
	public void setCodDecrypted(String codDecrypted) {
		this.codDecrypted = codDecrypted;
	}
	public byte[] getKey() {
		return key;
	}
	public void setKey(byte[] key) {
		this.key = key;
	}
	
}
