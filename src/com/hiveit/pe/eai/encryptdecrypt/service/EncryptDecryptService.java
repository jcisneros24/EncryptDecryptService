package com.hiveit.pe.eai.encryptdecrypt.service;

import com.hiveit.pe.eai.encryptdecrypt.bean.EncryptDecryptRequest;
import com.hiveit.pe.eai.encryptdecrypt.bean.EncryptDecryptResponse;

public interface EncryptDecryptService {
	
	EncryptDecryptResponse encryptDecrypt(EncryptDecryptRequest request);
	
}
