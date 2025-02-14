import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Introduce un número positivo");
        Scanner sc = new Scanner(System.in);
        int numero = Integer.parseInt(sc.nextLine());
        int resultado = sumaPrimerosNumeros(numero);

        System.out.println("El resultado es: " + resultado);
    }


        public static int sumaPrimerosNumeros(int cantidad){
            if(cantidad <= 0){
                throw new IllegalArgumentException("El numero debe ser mayor que 0");
            }

            return (int) ((1+cantidad)/2.0*cantidad);
        }

}