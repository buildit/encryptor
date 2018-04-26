package com.buildit

import org.apache.commons.lang3.text.WordUtils

import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

class Encryptor {

    public static final String SPEC = "AES"

    static String encrypt(String key, String value) {
        validateKey(key)
        SecretKeySpec skeySpec = generateSecretKeySpec(key)
        Cipher cipher = Cipher.getInstance(SPEC)
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec)
        byte[] encrypted = cipher.doFinal(value.getBytes())
        return WordUtils.wrap(new String(Base64.getEncoder().encode(encrypted)), 100, "\n", true)
    }

    static String decrypt(String key, String value) {
        validateKey(key)
        SecretKeySpec skeySpec = generateSecretKeySpec(key)
        Cipher cipher = Cipher.getInstance(SPEC)
        cipher.init(Cipher.DECRYPT_MODE, skeySpec)
        byte[] original = cipher.doFinal(Base64.getDecoder().decode(value.replace("\n", "")))
        return new String(original)
    }

    static generateSecretKeySpec(String key){
        def bytes = key.getBytes("UTF-8")
        return new SecretKeySpec(bytes, SPEC)
    }

    static validateKey(String key){
        def bytes = key.getBytes("UTF-8")
        if(bytes.length != 16){
            throw new IllegalArgumentException("Please provide a key with 16 characters.")
        }
    }


}