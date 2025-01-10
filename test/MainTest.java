import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void sumaPrimerosNumeros() {
        assertAll(
                () -> assertEquals(1, Main.sumaPrimerosNumeros(1)),
                () -> assertEquals(15, Main.sumaPrimerosNumeros(5)),
                () -> assertEquals(5050, Main.sumaPrimerosNumeros(100))
        );
    }
}