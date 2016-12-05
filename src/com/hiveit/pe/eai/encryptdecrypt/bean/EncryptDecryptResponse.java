package com.hiveit.pe.eai.encryptdecrypt.bean;

public class EncryptDecryptResponse {
	
	private String codEncrypted;
	private String codDecrypted;
	private byte[] key;
	private String codRpta;
	private String msgRpta;
	
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
	public String getCodRpta() {
		return codRpta;
	}
	public void setCodRpta(String codRpta) {
		this.codRpta = codRpta;
	}
	public String getMsgRpta() {
		return msgRpta;
	}
	public void setMsgRpta(String msgRpta) {
		this.msgRpta = msgRpta;
	}
	
}
