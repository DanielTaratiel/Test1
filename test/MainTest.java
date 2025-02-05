import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

class MainTest {

    static InputStream old;


    static ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    static PrintStream originalOut = System.out;

    @BeforeAll
    public static void setUpClass() throws UnsupportedEncodingException {
        old=System.in;

        // Redirect System.out to a ByteArrayOutputStream
        System.setOut(new PrintStream(outputStream));
    }

    @AfterAll
    public static void tearDownClass() {
        System.setIn(old);

        // Restore the original System.out after each test
        System.setOut(originalOut);
    }

    @Test
    void main() throws UnsupportedEncodingException {
        String inputString = "5\n";
        String outputString =
                "Introduce un número positivo" + System.lineSeparator() +
                "El resultado es: 15" + System.lineSeparator();
        System.setIn(new ByteArrayInputStream(inputString.getBytes("UTF-8")));
        Main.main(null);
        assertEquals(outputString,outputStream.toString());
    }

    @Test
    void sumaPrimerosNumeros() {
        assertAll(
                () -> assertEquals(1, Main.sumaPrimerosNumeros(1)),
                () -> assertEquals(15, Main.sumaPrimerosNumeros(5)),
                () -> assertEquals(5050, Main.sumaPrimerosNumeros(100)),
                () -> assertThrows(IllegalArgumentException.class, () -> Main.sumaPrimerosNumeros(-1))
        );
    }



}