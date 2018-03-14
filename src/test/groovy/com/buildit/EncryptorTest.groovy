package com.buildit

import org.junit.Test

import static org.hamcrest.CoreMatchers.equalTo
import static org.junit.Assert.assertThat

class EncryptorTest {

    @Test
    void shouldEncryptString(){
        String result = Encryptor.encrypt("ca5a73b6-6251-11e7-a6f2-57b0d429b22", "test")
        assertThat(result as String, equalTo("Z/RVOJ11QT8="))
    }

    @Test
    void shouldDecryptString(){
        String result = Encryptor.decrypt("2E4779A1-A318-4679-A794-915E73CC045A", "47Tv8dpZivY=")
        assertThat(result as String, equalTo("test"))
    }
}
