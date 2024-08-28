import java.util.Scanner;

public class Calculator {
    private int display = 0;
    private String operator;
    private boolean firstInput = true;

    private int sum(int a, int b) {
        return a + b;
    }

    private int subtract(int a, int b) {
        return a - b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    private int divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero");
            return 0;
        }
        return a / b;
    }

    public void calculator() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (isNumber(input)) {
                int number = Integer.parseInt(input);

                if (firstInput) {
                    display = number;
                    firstInput = false;
                } else {
                    switch (operator) {
                        case "+":
                            display = sum(display, number);
                            break;
                        case "-":
                            display = subtract(display, number);
                            break;
                        case "*":
                            display = multiply(display, number);
                            break;
                        case "/":
                            display = divide(display, number);
                            break;
                        default:
                            System.out.println("Unknown operator");
                            break;
                    }
                }
            } else if (input.equals("=")) {
                break;
            } else {
                operator = input;
            }
        }

        System.out.println("Result: " + display);
    }

    public static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculator();
    }
}