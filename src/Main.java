import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String input;

        System.out.println("Bienvenido a la Calculadora CLI");
        while (true) {
            System.out.print("Ingresa tu operación (p.ej., 3*2) o 'salir' para finalizar: ");
            input = scanner.nextLine();

            if ("salir".equalsIgnoreCase(input)) {
                break;
            }

            try {
                double result = calculator.evaluate(input);
                System.out.println("Resultado: " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("¡Hasta luego!");
    }
}