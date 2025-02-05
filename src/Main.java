//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Suma de los 100 primeros números");

        int resultado = sumaPrimerosNumeros(100);

        System.out.println("El resultado es: " + resultado);
    }


        public static int sumaPrimerosNumeros(int cantidad){
            if(cantidad <= 0){
                throw new IllegalArgumentException("El numero debe ser mayor que 0");
            }
            int suma = 0;
            for (int i = 1; i <= cantidad; i++) {
                suma += i;
            }
            return suma;
        }

}