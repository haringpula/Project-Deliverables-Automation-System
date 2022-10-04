package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainControllerTest {
    MainController controller;

    @BeforeEach
    void setUp() {
        controller = new MainController();
    }

    // XXX: Test passes but does not actually connects to database
    @Test
    @DisplayName("Getting credentials from external CSV file")
    public void givenCSV_whenGetCredentials_thenSuccess() {
        assertEquals(2, controller.findDeliverableId("PDAS"));

    }

}
