package com.buildit

import org.junit.Test

import static com.buildit.AESKeyGenerator.KeySize.LARGE
import static com.buildit.AESKeyGenerator.KeySize.MEDIUM
import static com.buildit.AESKeyGenerator.KeySize.SMALL
import static org.assertj.core.api.Assertions.assertThat

class AESKeyGeneratorTest {

    @Test
    void should_generate_correct_small_key_length() {
        String key = AESKeyGenerator.generate(SMALL)
        assertThat(key.length()).isEqualTo(24)
    }

    @Test
    void should_generate_correct_medium_key_length() {
        String key = AESKeyGenerator.generate(MEDIUM)
        assertThat(key.length()).isEqualTo(32)
    }

    @Test
    void should_generate_correct_large_key_length() {
        String key = AESKeyGenerator.generate(LARGE)
        assertThat(key.length()).isEqualTo(44)
    }
}
