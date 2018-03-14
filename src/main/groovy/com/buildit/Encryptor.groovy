package com.buildit

import org.acegisecurity.util.EncryptionUtils
import org.apache.commons.lang3.text.WordUtils

class Encryptor {

    static encrypt(String secret, String string){
        WordUtils.wrap(EncryptionUtils.encrypt(secret, string), 100, "\n", true)
    }

    static decrypt(String secret, String string){
        EncryptionUtils.decrypt(secret, string)
    }
}