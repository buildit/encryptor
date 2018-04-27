package com.buildit

import org.apache.commons.text.WordUtils


class Encryptor {

    static final String NEWLINE = "\n"

    static encrypt(String secret, String string){
        WordUtils.wrap(AESEncryptionUtils.encrypt(secret, string), 100, NEWLINE, true)
    }

    static decrypt(String secret, String string){
        AESEncryptionUtils.decrypt(secret, string.replace(NEWLINE, ""))
    }
}