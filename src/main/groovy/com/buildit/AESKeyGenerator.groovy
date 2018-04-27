package com.buildit

import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

class AESKeyGenerator {


    public static final String ALGORITHM = "AES"

    static String generate(KeySize keySize) {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM)
        keyGen.init(keySize.length)
        SecretKey secretKey = keyGen.generateKey()
        return Base64.getEncoder().encodeToString(secretKey.getEncoded())
    }

    static enum KeySize {

        SMALL(128), MEDIUM(192), LARGE(256)

        private final int length

        KeySize(int length) {
            this.length = length
        }

        int getLength() {
            return length
        }
    }
}
