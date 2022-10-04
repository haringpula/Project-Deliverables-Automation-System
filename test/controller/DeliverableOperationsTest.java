package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeliverableOperationsTest {
    DeliverableOperations operations;

    @BeforeEach
    void setUp() {
        operations = new DeliverableOperations();
    }

    // XXX: Test passes but does not actually connects to database
    @Test
    @DisplayName("Getting credentials from external CSV file")
    public void givenCSV_whenGetCredentials_thenSuccess() {
        assertEquals(2, operations.findDeliverableId("PDAS"));

    }

}
