package messenger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncryptionServiceTest {
    EncryptionService encryptionService;

    @BeforeEach
    void setUp(){
        encryptionService = new EncryptionService();
    }

    @Test
    void encrypt_ciphersMessage() {
        assertEquals("notayniksgto", encryptionService.encrypt("nagyontitkos"));
    }

    @Test
    void decrypt_deciphersMessage() {
        assertEquals("nagyontitkos", encryptionService.decrypt("notayniksgto"));
    }
}