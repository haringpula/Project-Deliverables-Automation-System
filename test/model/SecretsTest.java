package model;



import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class SecretsTest {
    Secrets secrets;

    @BeforeEach
    void setUp() {
        secrets = new Secrets();
    }

    @Test
    @Order(1)
    @DisplayName("Getting credentials from external CSV file")
    public void givenCSV_whenGetCredentials_thenSuccess() {
        assertDoesNotThrow(() -> secrets.getCredentials());
    }

    // BUG: Test does not recognize credentials
    /*@Test
    @Order(2)
    @DisplayName("executing CSV hash verifier")
    public void givenHash_whenHashVerifier_returnTrue() {
        secrets.getCredentials();
        secrets.getHash()
        assertTrue(secrets.csvHashVerifier());
    }*/

    @Test
    @Order(3)
    @DisplayName("executing CSV hash verifier")
    public void whenGetHash_returnStrHash() {
        assertEquals("k1plinG", secrets.getHash());
    }
}
