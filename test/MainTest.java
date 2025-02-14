import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.io.*;

class MainTest {

    //Variable para guardar la entrada de teclado.
    static InputStream old;

    //Variable que recoge la salida por consola.
    static ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    // Variable para guardar la salida por consola original.
    static PrintStream originalOut = System.out;

    @BeforeAll
    public static void setupAll() throws UnsupportedEncodingException {

        // Guardamos la entrada por teclado en old.
        old=System.in;

        // La nueva salida por consola es outputStream
        System.setOut(new PrintStream(outputStream));
    }

    @AfterAll
    public static void finishAll() {
        System.out.println("Aquí va todo lo que hacemos después de todos los test. No soy Obligatorio");

        // Restablecemos la entrada de Teclado.
        System.setIn(old);

        // Restablecemos la salida por consola.
        System.setOut(originalOut);
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Me ejecuto antes de cada test. No soy Obligatorio");
    }

    @AfterEach
    public void setDown() {
        System.out.println("Me ejecuto después de cada test. No soy Obligatorio");
    }


    @Test
    void main() throws UnsupportedEncodingException {
        String inputString = "5\n";
        String outputString =
                "Me ejecuto antes de cada test. No soy Obligatorio" + System.lineSeparator() +
                "Introduce un número positivo" + System.lineSeparator() +
                "El resultado es: 15" + System.lineSeparator();

        // La nueva entrada por teclado es establecida con  inputString.
        System.setIn(new ByteArrayInputStream(inputString.getBytes("UTF-8")));
        Main.main(null);

        // Comparamos la salida esperada con la real.
        assertEquals(outputString,outputStream.toString(), "La salida por pantalla es incorrecta.");
    }

    @Test
    void sumaPrimerosNumeros() {
        assertAll(
                () -> assertEquals(1, Main.sumaPrimerosNumeros(1), "Suma 1 número"),
                () -> assertEquals(15, Main.sumaPrimerosNumeros(5), "Suma 5 números"),
                () -> assertEquals(5050, Main.sumaPrimerosNumeros(100), "Suma 10 números"),
                () -> assertThrows(IllegalArgumentException.class, () -> Main.sumaPrimerosNumeros(-1), "Cantidad Negativa")
        );
    }



}