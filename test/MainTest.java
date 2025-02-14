import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.io.*;

// Nombre que aparece cuando se lanzan los test de esta clase.
@DisplayName("Ejemplos de Test Unitarios en la Clase Main")
// Sirve para poder ejecutar los test en un cierto orden.
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
        // Imprimo en la consola original y si sale por pantalla pero el test no lo captura.
        originalOut.println("Me ejecuto antes de cada test. No soy Obligatorio");
    }

    @AfterEach
    public void setDown() {
        // Imprimo en la consola original y si sale por pantalla pero el test no lo captura.
        originalOut.println("Me ejecuto después de cada test. No soy Obligatorio");
    }


    @Test
    @DisplayName("Test del método main()")
    // Este test se ejecuta el segundo.
    @Order(2)
    void main() throws UnsupportedEncodingException {
        String inputString = "5\n";
        String outputString =
                "Introduce un número positivo" + System.lineSeparator() +
                "El resultado es: 15" + System.lineSeparator();

        // La nueva entrada por teclado es establecida con  inputString.
        System.setIn(new ByteArrayInputStream(inputString.getBytes("UTF-8")));
        Main.main(null);

        // Comparamos la salida esperada con la real.
        assertEquals(outputString,outputStream.toString(), "La salida por pantalla es incorrecta.");
    }

    @Test
    @DisplayName("Test del método sumaPrimerosNumeros()")
    // Este test se ejecuta primero.
    @Order(1)
    @EnabledOnOs(value = {OS.LINUX, OS.WINDOWS})
    @EnabledOnJre(value = {JRE.JAVA_18})
    void sumaPrimerosNumeros() {
        assertAll(
                () -> assertEquals(1, Main.sumaPrimerosNumeros(1), "Suma 1 número"),
                () -> assertEquals(15, Main.sumaPrimerosNumeros(5), "Suma 5 números"),
                () -> assertEquals(5050, Main.sumaPrimerosNumeros(100), "Suma 10 números"),
                () -> assertThrows(IllegalArgumentException.class, () -> Main.sumaPrimerosNumeros(-1), "Cantidad Negativa")
        );
    }

    @Test
    @DisplayName("Test para comparar arrays")
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_11) // Podemos activar o desactivar el test para un rango de JRE
    public void arrayEquals() {
        // Arrange, preparamos el test
        int[] valor = {1,2,3,4,5};
        int[] esperado = {1,2,3,4,5};
        // Actuamos, en este caso no hacemos nada
        System.out.println("array == array");

        // Comprobamos resulatdos de dos maneras.
        assertAll(
                () -> assertEquals(esperado, valor, "Las variables no son iguales"),
                () -> assertArrayEquals(esperado, valor, "Los array no son iguales")
        );

    }



}