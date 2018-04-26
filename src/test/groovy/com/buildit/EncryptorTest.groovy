package com.buildit

import org.junit.Test

import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

import static com.buildit.utils.ResourcePath.resourcePath
import static org.hamcrest.CoreMatchers.equalTo
import static org.junit.Assert.assertThat

class EncryptorTest {

    @Test
    void shouldEncryptString(){
        String result = Encryptor.encrypt("WwajuX4sMjnDJ7ze", "test")
        assertThat(result as String, equalTo("iN4NEaonmYmKv+ZmBIigWw=="))
    }

    @Test
    void shouldEncryptAndWrapLongString(){
        def key = new File(resourcePath("key", "")).text as String
        def encrypted = new File(resourcePath("key_encrypted", "")).text as String
        String result = Encryptor.encrypt("WwajuX4sMjnDJ7ze", key)
        assertThat(result as String, equalTo(encrypted))
    }

    @Test
    void shouldDecryptString(){
        String result = Encryptor.decrypt("WwajuX4sMjnDJ7ze", "iN4NEaonmYmKv+ZmBIigWw==")
        assertThat(result as String, equalTo("test"))
    }

    @Test
    void shouldDencryptAndWrapLongString(){
        def key = new File(resourcePath("key", "")).text as String
        def encrypted = new File(resourcePath("key_encrypted", "")).text as String
        String result = Encryptor.decrypt("WwajuX4sMjnDJ7ze", encrypted)
        assertThat(result as String, equalTo(key))
    }

    @Test(expected = IllegalArgumentException.class)
    void shouldThrowExceptionWhenKeyIsTooLong(){
        String result = Encryptor.encrypt("WwajuX4sMjnDJ7zess", "test")
        assertThat(result as String, equalTo("iN4NEaonmYmKv+ZmBIigWw=="))
    }

    @Test(expected = IllegalArgumentException.class)
    void shouldThrowExceptionWhenKeyIsTooShort(){
        String result = Encryptor.encrypt("WwajuX4sMjnDJ7zess", "test")
        assertThat(result as String, equalTo("iN4NEaonmYmKv+ZmBIigWw=="))
    }
}
