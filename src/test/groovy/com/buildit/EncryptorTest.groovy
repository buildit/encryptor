package com.buildit

import org.junit.Test

import java.security.InvalidKeyException

import static org.hamcrest.CoreMatchers.equalTo
import static org.junit.Assert.assertThat

class EncryptorTest {

    static final String AES_128_KEY        = "1234567812345678"                 // 16 bytes
    static final String AES_192_KEY        = "123456781234567812345678"         // 24 bytes
    static final String AES_256_KEY        = "12345678123456781234567812345678" // 32 bytes
    static final String INVALID_LENGTH_KEY = "132456"                           // 6 bytes - wrong!
    static final String PASSWORD           = "mysecretpassword"

    @Test
    void shouldEncryptWithAes128(){
        String encrypted = Encryptor.encrypt(AES_128_KEY, PASSWORD)
        String decrypted = Encryptor.decrypt(AES_128_KEY, encrypted)

        assertThat(decrypted as String, equalTo(PASSWORD))
    }

    @Test
    void shouldEncryptWithAes192(){
        String encrypted = Encryptor.encrypt(AES_192_KEY, PASSWORD)
        String decrypted = Encryptor.decrypt(AES_192_KEY, encrypted)

        assertThat(decrypted as String, equalTo(PASSWORD))
    }

    @Test
    void shouldEncryptWithAes256(){
        String encrypted = Encryptor.encrypt(AES_256_KEY, PASSWORD)
        String decrypted = Encryptor.decrypt(AES_256_KEY, encrypted)

        assertThat(decrypted as String, equalTo(PASSWORD))
    }

    @Test(expected = InvalidKeyException.class)
    void shouldFailWithInvalidKeyLength(){
        Encryptor.encrypt(INVALID_LENGTH_KEY, PASSWORD)
    }
}
