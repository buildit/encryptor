package com.buildit

import org.apache.commons.lang3.text.WordUtils

class Encryptor {

    static encrypt(String secret, String string){
        WordUtils.wrap(AESEncryptionUtils.encrypt(secret, string), 100, "\n", true)
    }

    static decrypt(String secret, String string){
        AESEncryptionUtils.decrypt(secret, string)
    }
}