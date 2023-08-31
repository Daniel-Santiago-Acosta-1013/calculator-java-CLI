public class Calculator {
    public double evaluate(String input) throws Exception {
        String[] tokens;
        double num1, num2;

        if (input.contains("+")) {
            tokens = input.split("\\+");
            num1 = Double.parseDouble(tokens[0]);
            num2 = Double.parseDouble(tokens[1]);
            return num1 + num2;
        } else if (input.contains("-")) {
            tokens = input.split("-");
            num1 = Double.parseDouble(tokens[0]);
            num2 = Double.parseDouble(tokens[1]);
            return num1 - num2;
        } else if (input.contains("*")) {
            tokens = input.split("\\*");
            num1 = Double.parseDouble(tokens[0]);
            num2 = Double.parseDouble(tokens[1]);
            return num1 * num2;
        } else if (input.contains("/")) {
            tokens = input.split("/");
            num1 = Double.parseDouble(tokens[0]);
            num2 = Double.parseDouble(tokens[1]);
            if (num2 == 0) {
                throw new Exception("Error: División por cero.");
            }
            return num1 / num2;
        } else if (input.contains("^")) {
            tokens = input.split("\\^");
            num1 = Double.parseDouble(tokens[0]);
            num2 = Double.parseDouble(tokens[1]);
            return Math.pow(num1, num2);
        } else if (input.startsWith("sqrt")) {
            num1 = Double.parseDouble(input.substring(4));
            return Math.sqrt(num1);
        } else {
            throw new Exception("Operación no reconocida.");
        }
    }
}
